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
