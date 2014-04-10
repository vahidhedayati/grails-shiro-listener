package mydemo

import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationListener
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.subject.PrincipalCollection

class MyShiroListener implements AuthenticationListener {
	
	private static Collection activeUsers = Collections.synchronizedList(new ArrayList());
	
	@Override
	public void onSuccess(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
		MyHttpSessionListener.userLoggedIn((String) authenticationInfo.getPrincipals().getPrimaryPrincipal());
	}
 
	@Override
	public void onFailure(AuthenticationToken authenticationToken, AuthenticationException e) { }
 
	@Override
	public void onLogout(PrincipalCollection principalCollection) {
	
		MyHttpSessionListener.userLoggedOut((String) principalCollection.getPrimaryPrincipal());
	}
	
    public static Collection getActiveUsers() {
        return Collections.unmodifiableList(activeUsers);
    }
   
}