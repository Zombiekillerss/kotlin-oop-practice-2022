package lab3

interface ContactsService {
    fun addContact(person: Person, contact: Contact)
    fun removeContact(person: Person, contact: Contact)
    fun removePerson(person: Person)

    fun addPhone(person: Person, phone: String, phoneType: PhoneType)
    fun addEmail(person: Person, phone: String, phoneType: PhoneType)
    fun addLink(person: Person, phone: String, phoneType: PhoneType)
    fun addAddress(person: Person, phone: String, phoneType: PhoneType)

    fun getPersonContacts(person: Person): List<Contact>
    fun getPersonPhones(person: Person): List<Phone>
    fun getPersonEmails(person: Person): List<Phone>
    fun getPersonLinks(person: Person): List<Phone>
    fun getPersonAddress(person: Person): List<Phone>

    fun getAllPersons(): List<Person>
    fun getAllContacts(): Map<Person, List<Contact>>

    fun findPersons(subFirstName: String, subLastName: String): List<Person>

}