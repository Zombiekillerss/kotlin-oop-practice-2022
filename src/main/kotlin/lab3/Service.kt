package lab3

class Person(
    val firstName: String,
    val lastName: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }
}

sealed class Contact

data class Phone(val number: String, val type: PhoneType) : Contact() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Phone

        if (number != other.number) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = number.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}

data class Email(val email: String) : Contact() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Email

        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        return email.hashCode()
    }
}

data class LinkProfile(val name: String, val url: String) : Contact() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LinkProfile

        if (name != other.name) return false
        if (url != other.url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + url.hashCode()
        return result
    }
}

data class Address(val postcode: String, val city: String, val street: String, val houseNumber: String) : Contact() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (postcode != other.postcode) return false
        if (city != other.city) return false
        if (street != other.street) return false
        if (houseNumber != other.houseNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = postcode.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + houseNumber.hashCode()
        return result
    }
}

enum class PhoneType {
    MOBILE,
    HOME,
    WORK;
}

class Service : ContactsService {
    private val listPersons = mutableMapOf<Person, MutableList<Contact>>()

    override fun addContact(person: Person, contact: Contact) {
        if (!listPersons.containsKey(person))
            listPersons[person] = mutableListOf(contact)
        else listPersons[person]?.add(contact)
    }

    override fun removeContact(person: Person, contact: Contact) {
        if (listPersons.containsKey(person)) {
            if (listPersons[person]?.remove(contact) == false)
                error("No such value!!!")
        } else error("There is no person with that firstname or lastname!")
    }

    override fun removePerson(person: Person) {
        if (listPersons.containsKey(person))
            listPersons.remove(person)
        else error("There is no such person!")
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
        if (listPersons.isNotEmpty() && listPersons.containsKey(person))
            return listPersons[person]?.toList() ?: listOf()
        else error("This person is not!!")
    }

    override fun getPersonPhones(person: Person): List<Phone> {
        if (listPersons.containsKey(person))
            return listPersons[person]?.filterIsInstance<Phone>()?.toList() ?: listOf()
        else error("This person is not!!")
    }

    override fun getPersonEmails(person: Person): List<Email> {
        if (listPersons.containsKey(person))
            return listPersons[person]?.filterIsInstance<Email>()?.toList() ?: listOf()
        else error("This person is not!!")
    }

    override fun getPersonLinks(person: Person): List<LinkProfile> {
        if (listPersons.containsKey(person))
            return listPersons[person]?.filterIsInstance<LinkProfile>()?.toList() ?: listOf()
        else error("This person is not!!")
    }

    override fun getPersonAddress(person: Person): List<Address> {
        if (listPersons.containsKey(person))
            return listPersons[person]?.filterIsInstance<Address>()?.toList() ?: listOf()
        else error("This person is not!!")
    }

    override fun getAllPersons(): List<Person> {
        return listPersons.keys.toList()
    }

    override fun getAllContacts(): Map<Person, List<Contact>> {
        return listPersons
    }

    override fun findPersons(subFirstName: String, subLastName: String): List<Person> {
        if (listPersons.isNotEmpty()) {
            return listPersons.filter {
                it.key.firstName.indexOf(subFirstName) == 0 && it.key.lastName.indexOf(
                    subLastName
                ) == 0
            }.keys.toList()
        } else error("There are no people in the service!")
    }
}