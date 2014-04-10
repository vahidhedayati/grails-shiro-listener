class myexampleUser {
    String username
    String passwordHash
    
    static hasMany = [ roles: myexampleRole, permissions: String ]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
}
