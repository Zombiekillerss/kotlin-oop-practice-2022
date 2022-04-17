package lab1.lab3

class Person(
    private val name: String,
    private val lastName: String,
    internal var listContact: List<Contact> = mutableListOf()
)

class Contact(val email: String, val phoneNumber: Phone, val link: LinkProfile, val address: Address) {
    data class Phone(val number: Int, val type: PhoneType)
    data class LinkProfile(val name: String, val url: String)
    data class Address(val postcode: String, val city: String, val street: String, val houseNumber: String)
}

enum class PhoneType {
    MOBILE,
    HOME,
    WORK
}

class Service : ContactsService {
    override fun addContact(person: Person, contact: Contact){
        val newListContact = person.listContact
        person.listContact = listOf(contact) + newListContact
    }

    override fun removeContact(person: Person, contact: Contact) {
        TODO("Not yet implemented")
    }

    override fun removePerson(person: Person) {
        TODO("Not yet implemented")
    }

    override fun addPhone(person: Person, phone: String, phoneType: PhoneType) {
        TODO("Not yet implemented")
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        TODO("Not yet implemented")
    }

    override fun getPersonPhones(person: Person): List<Contact.Phone> {
        TODO("Not yet implemented")
    }

    override fun getAllPersons(): List<Person> {
        TODO("Not yet implemented")
    }

    override fun getAllContacts(): Map<Person, List<Contact>> {
        TODO("Not yet implemented")
    }
}