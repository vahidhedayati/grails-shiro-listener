package mydemo

class TestShiroController extends MyHttpSessionListener {

	
	
    def index() {
		println "----"+getCurrentUserNames()
		//This is a list of users that gets loaded by index - it does not automatically update according to new logins:	
		[NonRefreshUsers:getCurrentUserNames()]
	}
	
	
	def getOnline() { 
		println "---->"+getCurrentUserNames()
		[activeUsers: getCurrentUserNames()]
	}

	
	
}


