##### BuildConfig under plugins add: 
```
compile ":shiro:1.2.1"
```


##### Run:
```
shiro-quick-start --prefix=myexample
```


##### scripts/_Events.groovy:
```
import groovy.xml.StreamingMarkupBuilder

eventWebXmlEnd = {String tmpfile ->
    def root = new XmlSlurper().parse(webXmlFile)
    root.appendNode {
       'listener' {
		   'listener-class' (
			   'mydemo.MyHttpSessionListener'
		   )
        }
    }

    webXmlFile.text = new StreamingMarkupBuilder().bind {
        mkp.declareNamespace(
                "": "http://java.sun.com/xml/ns/javaee")
        mkp.yield(root)
    }
}
```

##### Take a look under src/groovy/mydemo: Two files:
```
MyHttpSessionListener 
MyShiroListener.groovy
```

##### Take a look under conf/spring/resources.groovy: you need a bean for your new Listener


import mydemo.MyShiroListener

import org.apache.shiro.authc.pam.ModularRealmAuthenticator

// Place your Spring DSL code here
beans = {
	
	//	
		authListener(MyShiroListener)
		shiroAuthenticator(ModularRealmAuthenticator) {
			authenticationStrategy = ref("shiroAuthenticationStrategy")
			authenticationListeners = [ ref("authListener") ]
		}
	
}





##### Controllers mydemo.TestShiroController:
```
class TestShiroController extends MyHttpSessionListener {
    def index() {
		//This is a list of users that gets loaded by index - it does not automatically update according to new logins:	
		[NonRefreshUsers:getCurrentUserNames()]
	}
	def getOnline() { 
		[activeUsers: getCurrentUserNames()]
	}
}
```


##### A big thank you to Ralph Perlewitz and his guide : http://rewoo.wordpress.com/2012/10/17/maintain-a-user-list-with-grails/ which made all of this possible.



##### A big thank you to Oliver Wahlen  http://owahlen.blogspot.co.uk/2010/12/tracking-session-lifecycle-in-grails.html for helping understand the more modular approach to web.xml and his guide which was working but from a http session point of view 


Other Links and urls used to research what I need but in the end all of it was in the above article :

http://java.dzone.com/articles/exploring-apache-shiro

http://shiro-user.582556.n2.nabble.com/Forced-Logout-on-User-ID-Locked-td7579189.html

http://shiro-user.582556.n2.nabble.com/log-out-all-subjects-td7001172.html

http://shiro-user.582556.n2.nabble.com/Problem-with-sessionDAO-and-WebFilter-td6464439.html

http://www.velocityreviews.com/forums/t605471-obtaining-a-list-of-all-active-sessions-within-a-servlet-container.html






http://rewoo.wordpress.com/2012/10/17/maintain-a-user-list-with-grails/

http://grails.1312388.n4.nabble.com/Shiro-How-to-intercept-logout-td3711739.html

http://grails.1312388.n4.nabble.com/Shiro-plugin-questions-td4628472.html


http://coderberry.me/blog/2012/04/26/grails-authentication-with-shiro/

https://github.com/cavneb/grails-shiro-example


https://github.com/andymccullough/litecollab/tree/master/uk.co.litecollab






