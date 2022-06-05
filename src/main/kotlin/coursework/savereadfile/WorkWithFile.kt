package coursework.savereadfile

import coursework.contacts.contact.PhoneBook
import java.io.File

class WorkWithFile {
    /*fun getLabyrinth(): List<String> {
        return File("src/main/kotlin/coursework/data.vcf").readLines()
    }*/
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
            writer.write("BDAY:${i.getDate().year}-")
            if(i.getDate().month<10)
                writer.write("0")
            writer.write("${i.getDate().month}-")
            if(i.getDate().day<10)
                writer.write("0")
            writer.write("${i.getDate().day}")
            writer.newLine()
            writer.write("ADR;TYPE=home:;;")
            if(i.getAddresses().houseNumber != "")
                writer.write(i.getAddresses().houseNumber)
            if(i.getAddresses().street != "") {
                if(i.getAddresses().houseNumber != "")
                    writer.write(",")
                writer.write(i.getAddresses().street)
            }
            writer.write(";${i.getAddresses().city};;${i.getAddresses().postcode};")
            if(i.getNumbers().getList().isNotEmpty()) {
                for(index in i.getNumbers().getList().indices){
                    writer.newLine()
                    writer.write("TEL;HOME:${i.getNumbers().getList()[index]}")
                }
            }
            if(i.getEmails().getList().isNotEmpty()) {
                for(index in i.getEmails().getList().indices){
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