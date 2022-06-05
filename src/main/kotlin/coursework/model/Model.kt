package coursework.model

import coursework.contacts.contact.PhoneBook

class Model(listContact: List<PhoneBook> = listOf()) {
    private val _contacts: MutableList<PhoneBook> = listContact.toMutableList()
    val contacts: List<PhoneBook>
        get() = _contacts

    fun addContact(contact: PhoneBook) {
        _contacts.add(contact)
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