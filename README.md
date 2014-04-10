BuildConfig under plugins add: 
```
compile ":shiro:1.2.1"
```


Run:
```
shiro-quick-start --prefix=myexample
```


scripts/_Events.groovy:
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

Take a look under src/groovy/mydemo: Two files:
```
MyHttpSessionListener 
MyShiroListener.groovy
```



Controllers mydemo.TestShiroController:
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





