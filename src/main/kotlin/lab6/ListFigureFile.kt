package lab6

import lab2.Figure
import java.io.File

class ListFigureFile {
    fun serializationToFile(listFigure: List<Figure>, pathToFile: String) {
        val collSer = ListFigureSerDes()
        File(pathToFile).writeText(collSer.serialization(listFigure))
    }

    fun deserializationFromFile(pathToFile: String): List<Figure> {
        val file = File(pathToFile)
        val collSer = ListFigureSerDes()
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")
        return collSer.deserialization(file.readText())
    }
}