package coursework.contacts.name

data class Name(var firstName:String = "", var secondName:String = "", var lastName: String = "") {
    override fun toString(): String {
        return "$firstName $secondName $lastName"
    }
}