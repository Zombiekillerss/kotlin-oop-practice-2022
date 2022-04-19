package lab3

class Person(
    val firstName: String,
    val lastName: String
)

sealed class Contact

data class Phone(val number: String, val type: PhoneType) : Contact()

data class Email(val email: String) : Contact()

data class LinkProfile(val name: String, val url: String) : Contact()

data class Address(val postcode: String, val city: String, val street: String, val houseNumber: String) : Contact()

enum class PhoneType {
    MOBILE,
    HOME,
    WORK
}

class Service : ContactsService {
    private val listPersons = mutableMapOf<Person, MutableList<Contact>>()

    override fun addContact(person: Person, contact: Contact) {
        if (!listPersons.containsKey(person))
            listPersons[person] = mutableListOf(contact)
        else listPersons[person]?.add(contact)
    }

    override fun removeContact(person: Person, contact: Contact) {
        if (listPersons[person]?.remove(contact) == null)
            error("lol")
    }

    override fun removePerson(person: Person) {
        if (listPersons.containsKey(person))
            listPersons.remove(person)
        else error("lol")
    }

    override fun addPhone(person: Person, phone: String, phoneType: PhoneType) {
        addContact(person, Phone(phone, phoneType))
    }

    override fun addEmail(person: Person, email: String) {
        addContact(person, Email(email))
    }

    override fun addLink(person: Person, socialNetworkName: String, url: String) {
        addContact(person, LinkProfile(socialNetworkName, url))
    }

    override fun addAddress(person: Person, postcode: String, city: String, street: String, houseNumber: String) {
        addContact(person, Address(postcode, city, street, houseNumber))
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        if(listPersons.containsKey(person))
            return listPersons[person]?.toList() ?: error("lol")
        else error("lol")
    }

    override fun getPersonPhones(person: Person): List<Phone> {
        if(listPersons.containsKey(person))
            return listPersons[person]?.filterIsInstance<Phone>()?.toList()?: error("lol")
        else error("lol")
    }

    override fun getPersonEmails(person: Person): List<Email> {
        if(listPersons.containsKey(person))
            return listPersons[person]?.filterIsInstance<Email>()?.toList()?: error("lol")
        else error("lol")
    }

    override fun getPersonLinks(person: Person): List<LinkProfile> {
        if(listPersons.containsKey(person))
            return listPersons[person]?.filterIsInstance<LinkProfile>()?.toList()?: error("lol")
        else error("lol")
    }

    override fun getPersonAddress(person: Person): List<Address> {
        if(listPersons.containsKey(person))
            return listPersons[person]?.filterIsInstance<Address>()?.toList()?: error("lol")
        else error("lol")
    }

    override fun getAllPersons(): List<Person> {
        if(listPersons.isNotEmpty())
            return listPersons.keys.toList()
        else error("lol")
    }

    override fun getAllContacts(): Map<Person, List<Contact>> {
        if(listPersons.isNotEmpty())
            return listPersons
        else error("lol")
    }

    override fun findPersons(subFirstName: String, subLastName: String): List<Person> {
        TODO("Not yet implemented")
    }
}