package coursework.contacts.contact

import coursework.contacts.address.Address
import coursework.contacts.dateofbirth.DateBirth
import coursework.contacts.emails.Emails
import coursework.contacts.name.Name
import coursework.contacts.numbersphone.NumbersPhone

/*
ФИО
Номера телефонов
Email’ы
Адрес
Дата рождения
*/
class PhoneBook {
    private val name = Name()
    private val numbers = NumbersPhone()
    private val emails = Emails()
    private val address = Address()
    private val date = DateBirth()

    fun getName() = name
    fun getNumbers() = numbers
    fun getEmails() = emails
    fun getAddresses() = address
    fun getDate() = date

    fun addNumbers(numberList: List<String>) {
        numbers.addAll(numberList)
    }


    fun addEmails(emailList: List<String>) {
        emails.addAll(emailList)
    }

    fun changeName(firstName: String, secondName: String, lastName: String) {
        if (firstName != "")
            name.firstName = firstName
        if (secondName != "")
            name.secondName = secondName
        if (lastName != "")
            name.lastName = lastName
    }

    fun changeAddress(postcode: String, city: String, street: String, houseNumber: String) {
        address.city = city
        address.houseNumber = houseNumber
        address.postcode = postcode
        address.street = street
    }

    fun changeDate(day: Int, month: Int, year: Int) {
        date.day = day
        date.month = month
        date.year = year
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PhoneBook

        if (name != other.name) return false
        if (numbers != other.numbers) return false
        if (emails != other.emails) return false
        if (address != other.address) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + numbers.hashCode()
        result = 31 * result + emails.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }

    fun removeAllEmails() {
        emails.clear()
    }

    fun removeAllNumbers() {
        numbers.clear()
    }


}