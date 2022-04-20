package lab3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ServiceTest {

    @Test
    fun addContactTestsTests() {
        @Test
        fun testAddTheFirstPersonWithContacts() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.addContact(person, Phone("90", PhoneType.MOBILE))
            val rightPerson = mutableMapOf<Person, List<Contact>>()
            rightPerson[person] = listOf<Contact>(Phone("90", PhoneType.HOME), Phone("90", PhoneType.MOBILE))
            assertEquals(rightPerson, service.getAllContacts())
        }

        @Test
        fun testAddTwoOrMorePeopleWithContacts() {
            val service = Service()
            var person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.addContact(person, Phone("90", PhoneType.MOBILE))
            val rightPerson = mutableMapOf<Person, List<Contact>>()
            rightPerson[person] = listOf<Contact>(Phone("90", PhoneType.HOME), Phone("90", PhoneType.MOBILE))
            person = Person("Vasya", "Pupkin")
            service.addContact(person, Email("vasya.100@mail.ru"))
            service.addContact(person, LinkProfile("test", "https://vk.com"))
            service.addContact(person, Address("89798", "Санкт-Петербург", "Улица", "897"))
            rightPerson[person] = listOf(
                Email("vasya.100@mail.ru"),
                LinkProfile("test", "https://vk.com"),
                Address("89798", "Санкт-Петербург", "Улица", "897")
            )
            person = Person("test", "test")
            service.addContact(person, Phone("90", PhoneType.HOME))
            rightPerson[person] = listOf(Phone("90", PhoneType.HOME))
            assertEquals(rightPerson, service.getAllContacts())
        }

        @Test
        fun testAddTwoPeopleWithTheSameName() {
            val service = Service()
            var person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            val rightPerson = mutableMapOf<Person, List<Contact>>()
            rightPerson[person] = listOf<Contact>(Phone("90", PhoneType.HOME))
            person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            rightPerson[person] = listOf<Contact>(Phone("90", PhoneType.HOME), Phone("90", PhoneType.HOME))
            assertEquals(rightPerson, service.getAllContacts())
            assert(service.getAllContacts().size == 1)
        }
        testAddTheFirstPersonWithContacts()
        testAddTwoOrMorePeopleWithContacts()
        testAddTwoPeopleWithTheSameName()
    }

    @Test
    fun removeContactTests() {
        @Test
        fun testAddOnePersonContactAndRemoveIt() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.removeContact(person, Phone("90", PhoneType.HOME))
            assert(service.getAllContacts()[person]?.isEmpty() == true)
        }

        @Test
        fun testDeleteContactsFromTwoPeople() {
            val service = Service()
            var person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            person = Person("Alex", "Vasa")
            service.addContact(person, Phone("909", PhoneType.HOME))
            service.removeContact(person, Phone("909", PhoneType.HOME))
            service.removeContact(Person("Ivan", "Vasa"), Phone("90", PhoneType.HOME))
            assert(service.getAllContacts()[person]?.isEmpty() == true)
        }

        @Test
        fun testErrorNoContact() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            try {
                service.removeContact(person, Phone("90", PhoneType.MOBILE))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("No such value!!!", e.message)
            }
        }

        @Test
        fun testErrorNoPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            try {
                service.removeContact(Person("Alex", "Vasa"), Phone("90", PhoneType.MOBILE))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("There is no person with that firstname or lastname!", e.message)
            }
        }
        testAddOnePersonContactAndRemoveIt()
        testErrorNoContact()
        testDeleteContactsFromTwoPeople()
        testErrorNoPerson()
    }

    @Test
    fun removePersonTests() {
        @Test
        fun testRemoveOnePerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.removePerson(person)
            assert(service.getAllContacts().isEmpty())
        }

        @Test
        fun testRemoveTwoPerson() {
            val service = Service()
            var person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            person = Person("Alex", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.removePerson(Person("Ivan", "Vasa"))
            assert(service.getAllPersons().size == 1)
            service.removePerson(person)
            assert(service.getAllContacts().isEmpty())
        }

        @Test
        fun testErrorNoPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            try {
                service.removePerson(Person("test", "test"))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("There is no such person!", e.message)
            }
            assert(service.getAllPersons().size == 1)
            service.removePerson(Person("Ivan", "Vasa"))
            try {
                service.removePerson(Person("test", "test"))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("There is no such person!", e.message)
            }
        }
        testErrorNoPerson()
        testRemoveTwoPerson()
        testRemoveOnePerson()
    }

    @Test
    fun getPersonContactsTests() {
        @Test
        fun testErrorNoPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            try {
                service.getPersonContacts(person)
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
            service.addContact(person, Phone("90", PhoneType.HOME))
            try {
                service.getPersonContacts(Person("Alex", "Vasa"))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
        }

        @Test
        fun testGetContactsPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.addContact(person, Phone("909", PhoneType.HOME))
            service.addContact(person, Phone("908", PhoneType.HOME))
            service.addContact(person, Phone("907", PhoneType.HOME))
            val listContact = listOf<Contact>(
                Phone("90", PhoneType.HOME),
                Phone("909", PhoneType.HOME),
                Phone("908", PhoneType.HOME),
                Phone("907", PhoneType.HOME)
            )
            assertEquals(listContact,service.getPersonContacts(person))
        }
        testErrorNoPerson()
        testGetContactsPerson()
    }

    @Test
    fun getPersonPhonesTests() {
        @Test
        fun testErrorNoPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            try {
                service.getPersonPhones(person)
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
            service.addContact(person, Phone("90", PhoneType.HOME))
            try {
                service.getPersonContacts(Person("Alex", "Vasa"))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
        }

        @Test
        fun testGetPhonesPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.addContact(person, Email("vasya.100@mail.ru"))
            service.addContact(person, LinkProfile("test", "https://vk.com"))
            service.addContact(person, Address("89798", "Санкт-Петербург", "Улица", "897"))
            val listContact = listOf<Contact>(
                Phone("90", PhoneType.HOME)
            )
            assertEquals(listContact,service.getPersonPhones(person))
        }
        testErrorNoPerson()
        testGetPhonesPerson()
    }

    @Test
    fun getPersonEmailsTests() {
        @Test
        fun testErrorNoPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            try {
                service.getPersonPhones(person)
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
            service.addContact(person, Phone("90", PhoneType.HOME))
            try {
                service.getPersonContacts(Person("Alex", "Vasa"))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
        }

        @Test
        fun testGetEmailsPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.addContact(person, Email("vasya.100@mail.ru"))
            service.addContact(person, LinkProfile("test", "https://vk.com"))
            service.addContact(person, Address("89798", "Санкт-Петербург", "Улица", "897"))
            val listContact = listOf<Contact>(
                Email("vasya.100@mail.ru")
            )
            assertEquals(listContact,service.getPersonEmails(person))
        }
        testErrorNoPerson()
        testGetEmailsPerson()
    }

    @Test
    fun getPersonLinksTests() {
        @Test
        fun testErrorNoPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            try {
                service.getPersonPhones(person)
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
            service.addContact(person, Phone("90", PhoneType.HOME))
            try {
                service.getPersonContacts(Person("Alex", "Vasa"))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
        }

        @Test
        fun testGetLinksPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.addContact(person, Email("vasya.100@mail.ru"))
            service.addContact(person, LinkProfile("test", "https://vk.com"))
            service.addContact(person, Address("89798", "Санкт-Петербург", "Улица", "897"))
            val listContact = listOf<Contact>(
                LinkProfile("test", "https://vk.com")
            )
            assertEquals(listContact,service.getPersonLinks(person))
        }
        testErrorNoPerson()
        testGetLinksPerson()
    }

    @Test
    fun getPersonAddressTests() {
        @Test
        fun testErrorNoPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            try {
                service.getPersonPhones(person)
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
            service.addContact(person, Phone("90", PhoneType.HOME))
            try {
                service.getPersonContacts(Person("Alex", "Vasa"))
                assert(false)
            } catch (e: IllegalStateException) {
                assertEquals("This person is not!!", e.message)
            }
        }

        @Test
        fun testGetAddressPerson() {
            val service = Service()
            val person = Person("Ivan", "Vasa")
            service.addContact(person, Phone("90", PhoneType.HOME))
            service.addContact(person, Email("vasya.100@mail.ru"))
            service.addContact(person, LinkProfile("test", "https://vk.com"))
            service.addContact(person, Address("89798", "Санкт-Петербург", "Улица", "897"))
            val listContact = listOf<Contact>(
                Address("89798", "Санкт-Петербург", "Улица", "897")
            )
            assertEquals(listContact,service.getPersonAddress(person))
        }
        testErrorNoPerson()
        testGetAddressPerson()
    }

    @Test
    fun findPersonsTests() {

        @Test
        fun testErrorNoPerson(){
            val service = Service()
            try{
                service.findPersons("test", ",k")
                assert(false)
            }catch (e: IllegalStateException){
                assertEquals("There are no people in the service!", e.message)
            }
        }

        @Test
        fun testFindPerson(){
            val service = Service()
            var person = Person("Test", "Alexandr")
            service.addContact(person, Phone("90",PhoneType.MOBILE))
            person = Person("Test1", "Alexandr1")
            service.addContact(person, Phone("90",PhoneType.MOBILE))
            person = Person("Fest1", "Alexandr1")
            service.addContact(person, Phone("90",PhoneType.MOBILE))
            val listPerson = listOf(
                Person("Test", "Alexandr"),
                Person("Test1", "Alexandr1")
            )
            assertEquals(listPerson, service.findPersons("Tes","Alex"))
        }
        testErrorNoPerson()
        testFindPerson()
    }
}