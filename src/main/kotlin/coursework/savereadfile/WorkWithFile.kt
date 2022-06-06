package coursework.savereadfile

import coursework.contacts.contact.PhoneBook
import java.io.File
import java.time.LocalDateTime

class WorkWithFile {
    fun getListContacts(): List<PhoneBook> {
        val contacts = File("src/main/kotlin/coursework/data.txt").readLines()
        val listContacts = mutableListOf<PhoneBook>()
        val book = PhoneBook()
        for (i in contacts) {
            val contact = i.split(";")
            book.changeName(contact[0], contact[1], contact[2])
            book.changeDate(contact[3].toInt(), contact[4].toInt(), contact[5].toInt())
            book.changeAddress(contact[6], contact[7], contact[8], contact[9])
            val emails = contact[10].split(",").toMutableList()
            if (emails.last() == "")
                emails.removeAt(emails.lastIndex)
            book.addEmails(emails)
            val numbers = contact[11].split(",").toMutableList()
            if (numbers.last() == "")
                numbers.removeAt(numbers.lastIndex)
            book.addNumbers(numbers)
            listContacts.add(book)
        }
        return listContacts
    }

    fun writeToFile(elements: List<PhoneBook>) {
        val writer = File("src/main/kotlin/coursework/data.vcf").bufferedWriter()
        for (i in elements) {
            writer.write("BEGIN:VCARD")
            writer.newLine()
            writer.write("VERSION:2.1")
            writer.newLine()
            writer.write("N:${i.getName().secondName};${i.getName().firstName};${i.getName().lastName};;")
            writer.newLine()
            writer.write("FN:${i.getName().firstName} ${i.getName().lastName} ${i.getName().secondName}")
            writer.newLine()
            if (i.getDate().year in (LocalDateTime.now().year-70)..LocalDateTime.now().year && i.getDate().month in 0..12 && i.getDate().day in 0..31) {
                writer.write("BDAY:${i.getDate().year}-")
                if (i.getDate().month < 10)
                    writer.write("0")
                writer.write("${i.getDate().month}-")
                if (i.getDate().day < 10)
                    writer.write("0")
                writer.write("${i.getDate().day}")
                writer.newLine()
            }
            writer.write("ADR;TYPE=home:;;")
            if (i.getAddresses().houseNumber != "")
                writer.write(i.getAddresses().houseNumber)
            if (i.getAddresses().street != "") {
                if (i.getAddresses().houseNumber != "")
                    writer.write(",")
                writer.write(i.getAddresses().street)
            }
            writer.write(";${i.getAddresses().city};;${i.getAddresses().postcode};")
            if (i.getNumbers().getList().isNotEmpty()) {
                for (index in i.getNumbers().getList().indices) {
                    writer.newLine()
                    writer.write("TEL;HOME:${i.getNumbers().getList()[index]}")
                }
            }
            if (i.getEmails().getList().isNotEmpty()) {
                for (index in i.getEmails().getList().indices) {
                    writer.newLine()
                    writer.write("EMAIL;HOME:${i.getEmails().getList()[index]}")
                }
            }
            writer.newLine()
            writer.write("END:VCARD")
            writer.newLine()
        }
        writer.close()
    }
}