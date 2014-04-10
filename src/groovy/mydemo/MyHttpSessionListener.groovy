package mydemo

import javax.servlet.http.HttpSessionEvent
import javax.servlet.http.HttpSessionListener

import org.apache.shiro.subject.PrincipalCollection
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext

class MyHttpSessionListener implements HttpSessionListener {
    private static List activeUsers = Collections.synchronizedList(new ArrayList());
    @Override
    public void sessionCreated(HttpSessionEvent event) { }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        String userName = getCurrentUserName(event)
        if (userName == null) {
            return
        }
        MyHttpSessionListener.userLoggedOut(userName)
    }
 
    public static void userLoggedIn(String userName) {
		if (!activeUsers.contains(userName)) {
			activeUsers.add(userName)
		}
    }
 
    public static void userLoggedOut(String userName) {
        activeUsers.remove(userName)
    }
 
    public static List getCurrentUserNames() {
        return Collections.unmodifiableList(activeUsers);
    }
 
    private String getCurrentUserName(HttpSessionEvent event) {
        PrincipalCollection currentUser = (PrincipalCollection) event.getSession().getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        if (currentUser == null) {
            return null
        }
        return (String) currentUser.getPrimaryPrincipal();
    }
}
