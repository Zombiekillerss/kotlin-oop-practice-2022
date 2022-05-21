package coursework.model

import coursework.contacts.contact.PhoneBook

interface ModelChangeListener {
    fun onModelChanged()
}

class Model {
    private val _contacts: MutableList<PhoneBook> = initEmptyBoard()
    val contacts: List<PhoneBook>
        get() = _contacts

    //var state: State = FIRST_MOVE
    //    private set

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
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

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    private fun initEmptyBoard(): MutableList<PhoneBook> {
        return mutableListOf()
    }

    override fun toString(): String {
        return buildString {
            contacts.forEach {
                append(it).appendLine()
            }
        }
    }
}