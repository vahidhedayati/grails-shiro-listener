import org.apache.shiro.crypto.hash.Sha256Hash

class BootStrap {

    def init = { servletContext ->
		
		def user1 = new myexampleUser(username: "user1", passwordHash: new Sha256Hash("password").toHex())
		user1.addToPermissions("*:*")
		user1.save()
		
		def user2 = new myexampleUser(username: "user2", passwordHash: new Sha256Hash("password").toHex())
		user2.addToPermissions("*:*")
		user2.save()
		
		def user3 = new myexampleUser(username: "user3", passwordHash: new Sha256Hash("password").toHex())
		user3.addToPermissions("*:*")
		user3.save()
		
    }
    def destroy = {
    }
}
