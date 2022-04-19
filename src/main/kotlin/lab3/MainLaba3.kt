package lab3

fun main() {
    val service = Service()
    var person = Person("Ivan", "Vasa")
    service.addContact(person, Phone("90",PhoneType.HOME))
    service.addContact(person, Phone("90",PhoneType.MOBILE))
    person = Person("Alexandr", "Tikhonov")
    service.addContact(person, Phone("90",PhoneType.WORK))
}