package coursework.savereadfile

import lab4.model.Cell
import java.io.File

class WorkWithFile {
    fun getLabyrinth(): List<String> {
        return File("src/main/kotlin/coursework/data.vcf").readLines()
    }
    fun writeToFile(elements: List<List<Cell>>){
        val writer = File("src/main/kotlin/coursework/data.vcf").bufferedWriter()
        for (i in elements) {
            for (j in i) {
                writer.write(j.toString())
            }
            writer.newLine()
        }
        writer.close()
    }
}