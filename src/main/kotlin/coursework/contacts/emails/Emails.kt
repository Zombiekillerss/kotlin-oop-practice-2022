package coursework.contacts.emails

class Emails {
    private val listEmails = mutableListOf<String>()

    fun getList(): List<String>{
        return listEmails
    }

    fun addNumber(email: String){
        listEmails.add(email)
    }

    fun addAll(newListEmails: List<String>){
        listEmails.addAll(newListEmails)
    }

    fun remove(email: String){
        listEmails.remove(email)
    }

    fun changeNumber(index: Int, newEmail:String){
        listEmails[index] = newEmail
    }
}