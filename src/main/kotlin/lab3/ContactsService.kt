package lab1.lab3

interface ContactsService {
    fun addContact(person: Person, contact: Contact)
    fun removeContact(person: Person, contact: Contact)
    fun removePerson(person: Person)

    fun addPhone(person: Person, phone: String, phoneType: PhoneType)
    // add email
    // add link
    // add address

    fun getPersonContacts(person: Person) : List<Contact>
    fun getPersonPhones(person: Person) : List<Contact.Phone>
    // get emails
    // get links

    fun getAllPersons(): List<Person>
    fun getAllContacts(): Map<Person, List<Contact>>

    // find

}