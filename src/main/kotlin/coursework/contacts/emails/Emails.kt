package coursework.contacts.emails

class Emails {
    private val listEmails = mutableListOf<String>()

    fun getList(): List<String>{
        return listEmails
    }

    fun addEmail(email: String){
        listEmails.add(email)
    }

    fun addAll(newListEmails: List<String>){
        listEmails.addAll(newListEmails)
    }

    fun remove(email: String){
        listEmails.remove(email)
    }

    fun changeEmail(index: Int, newEmail:String){
        listEmails[index] = newEmail
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Emails

        if (listEmails != other.listEmails) return false

        return true
    }

    override fun hashCode(): Int {
        return listEmails.hashCode()
    }

    override fun toString(): String {
        var str = ""
        for(i in listEmails.indices) {
            str += listEmails[i]
            if(i != listEmails.size - 1)
                str+=","
        }

        return str
    }

    fun clear() {
        listEmails.clear()
    }

}