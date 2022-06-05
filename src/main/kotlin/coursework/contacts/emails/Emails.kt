package coursework.contacts.emails

class Emails {
    private val listEmails = mutableListOf<String>()

    fun getList(): List<String> {
        return listEmails
    }

    fun addAll(newListEmails: List<String>) {
        listEmails.addAll(newListEmails)
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
        for (i in listEmails.indices) {
            str += listEmails[i]
            if (i != listEmails.size - 1)
                str += ","
        }

        return str
    }

    fun clear() {
        listEmails.clear()
    }

}