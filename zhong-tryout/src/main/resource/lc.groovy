tablesToRunTableLevelValidation = ["tlc.lc_loan", "tlc.lc_pd"]
print "lc_pd count is " + 123455 + '\n'
validation {
	"tlc.lc_loan" {
		groovyScript = "src/main/resource/lc_loan_validation.groovy";
	}
}
