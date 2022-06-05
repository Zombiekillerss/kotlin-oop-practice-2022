package coursework.model

import coursework.contacts.contact.PhoneBook

class Model(listContact: List<PhoneBook> = listOf()) {
    private val _contacts: MutableList<PhoneBook> = initEmptyBoard(listContact)
    val contacts: List<PhoneBook>
        get() = _contacts

    fun addContact(contact: PhoneBook) {
        _contacts.add(contact)
    }

    private fun initEmptyBoard(listContact: List<PhoneBook>): MutableList<PhoneBook> {
        val listContacts = mutableListOf<PhoneBook>()
        listContacts.addAll(listContact)
        val but1 = PhoneBook()
        val but2 = PhoneBook()
        val but3 = PhoneBook()
        but1.changeName("lol1", "kol1", "vol1")
        but2.changeName("lol23", "kol2", "vol2")
        but3.changeName("lol3", "kol3", "vol3")
        but1.changeDate(9, 8, 2002)
        but2.changeDate(10, 11, 2002)
        but3.changeDate(11, 11, 2002)

        listContacts.add(but1)
        listContacts.add(but2)
        listContacts.add(but3)

        return listContacts
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

    fun changeContact(index: Int, contact: PhoneBook) {
        _contacts[index] = contact
    }
}