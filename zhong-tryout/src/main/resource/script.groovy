def init() {
	println "initing..."
}

def swapValues(str1, str2) {
	return [str2, str1] as String[];
}

def getRowCount(tableName) {
	println "rowcount"
	f = ctx.getRowCount(ctx.getStats(tableName).getTableName(), 10);
	return f
}

def getNullColumns (Object[] strs) {
	def ret=[];
	for (Object str: strs) {
		if (!ctx.NotNullColumn(str))
			ret.add(str)
	}
	return ret as String[];
}

def statsObj(tableName) {
	k = ctx.getStats(tableName);
	println k.getTableName();
	return k;
}



