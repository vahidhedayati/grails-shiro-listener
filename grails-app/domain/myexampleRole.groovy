class myexampleRole {
    String name

    static hasMany = [ users: myexampleUser, permissions: String ]
    static belongsTo = myexampleUser

    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
}
