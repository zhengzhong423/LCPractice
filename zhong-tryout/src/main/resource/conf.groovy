def now() { 
	return new Date().format('yyyy-MM-dd HH:mm:ss.SSS');
}

def timeBeforeNow(int days) {
	return new Date().minus(100).format('yyyy-MM-dd HH:mm:ss.SSS');
}

def obj = jsonSlurper.parseText('{"Integer": 12, "fraction": 12.55, "double": 12e13}')
println('{"Integer": 12, "fraction": 12.55, "double": 12e13}')

environments {
	Ingestion {
	    '*.*' {
	        	RowCountValidator {
	        		tableName="*.*"
	        	}
	        	SampleDataValidator{
	        		tableName='*.*'
	        	}
	    	}

	    'tlc.*' {
	    		RowCountValidator {
	    			tableName="tlc.*"
	        		dbCondition="modified_d<=" + now()
	        		prestoCondition="modified_d<=" + now()
	        		fastFailed=true
	        	}
	    	}

	    'tlc.lc$pd' {
				SampleDataValidator {
					tableName='tlc.lc$pd'
					sendEmailIfFailed=true;
					dbCondition="modified_d<=TO_TIMESTAMP('" + timeBeforeNow(100) + "', 'yyyy-mm-dd hh24:mi:ss.FF')"
	        		prestoCondition="modified_d<=" + "timestamp'" + timeBeforeNow(100) + "'"
	        	}
	        	RowCountValidator{
	        		tableName='tlc.lc$pd'
	        		skipValidation=true
	        	}
	    	}
	}

	QA { 
		'tlc.lc$lead' {
	        	NullColumnsValidator {
	        		notNullColums = "id, ssn"
	        		timeFilter="modified_d>=" + now()
	        	}
	        }
		}

	ReportCreating {
		
	}

	PostReportCreation {

	}
}