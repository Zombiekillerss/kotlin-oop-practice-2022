package lab6

import lab2.ColoredShape2d
import java.io.File

class ListFigureFile {
    fun serializationToFile(listFigure: List<ColoredShape2d>, pathToFile: String) {
        val collSer = ListFigureSerDes()
        File(pathToFile).writeText(collSer.serialization(listFigure))
    }

    fun deserializationFromFile(pathToFile: String): List<ColoredShape2d> {
        val file = File(pathToFile)
        val collSer = ListFigureSerDes()
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")
        return collSer.deserialization(file.readText())
    }
}