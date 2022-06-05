package coursework.model

import coursework.contacts.contact.PhoneBook

class Model {
    private val _contacts: MutableList<PhoneBook> = initEmptyBoard()
    val contacts: List<PhoneBook>
        get() = _contacts

    //var state: State = FIRST_MOVE
    //    private set

    fun addContact(contact: PhoneBook){
        _contacts.add(contact)
    }

    fun addNumber(contact: PhoneBook, number: String) {
        contact.addNumber(number)
    }

    fun addNumbers(contact: PhoneBook, numberList: List<String>) {
        contact.addNumbers(numberList)
    }

    fun removeNumber(contact: PhoneBook, number: String) {
        contact.removeNumber(number)
    }

    fun changeNumber(contact: PhoneBook, index: Int, newNumber: String) {
        contact.changeNumber(index, newNumber)
    }

    fun addEmail(contact: PhoneBook, email: String) {
        contact.addEmail(email)
    }

    fun addEmails(contact: PhoneBook, emailList: List<String>) {
        contact.addEmails(emailList)
    }

    fun removeEmail(contact: PhoneBook, email: String) {
        contact.removeEmail(email)
    }

    fun changeEmail(contact: PhoneBook, index: Int, newEmail: String) {
        contact.changeEmail(index, newEmail)
    }

    fun changeName(contact: PhoneBook, firstName: String, secondName: String, lastName: String) {
        contact.changeName(firstName,secondName,lastName)
    }

    fun changeAddress(contact: PhoneBook, city: String, houseNumber: String, postcode: String, street: String) {
        contact.changeAddress(city,houseNumber,postcode, street)
    }

    fun changeDate(contact: PhoneBook, day: Int, month: Int, year: Int) {
        contact.changeDate(day,month,year)
    }

    fun doMove() {
    }

    /*private fun saveGame() {
        val writer = File("src/main/kotlin/lab4/labyrinth.txt").bufferedWriter()
        for (i in contacts) {
            for (j in i) {
                writer.write(j.toString())
                writer.write(" ")
            }
            writer.newLine()
        }
        writer.close()
    }*/

    private fun initEmptyBoard(): MutableList<PhoneBook> {
        val demoContacts = mutableListOf<PhoneBook>()
        val but1 = PhoneBook()
        val but2 = PhoneBook()
        val but3 = PhoneBook()
        but1.changeName("lol1", "kol1", "vol1")
        but2.changeName("lol23", "kol2", "vol2")
        but3.changeName("lol3", "kol3", "vol3")
        but1.changeDate(9,8,2002)
        but2.changeDate(10, 11, 2002)
        but3.changeDate(11, 11, 2002)

        demoContacts.add(but1)
        demoContacts.add(but2)
        demoContacts.add(but3)

        return demoContacts
    }

    override fun toString(): String {
        return buildString {
            contacts.forEach {
                append(it).appendLine()
            }
        }
    }

    fun removeProfile(index: Int) {
        _contacts.removeAt(index)
    }

    fun changeContact(index: Int,contact: PhoneBook) {
        _contacts[index] = contact
    }
}