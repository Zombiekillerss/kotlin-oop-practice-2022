package lab6

import lab2.*
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

internal class ListFigureFileTest {

    @Test
    fun serializationToFileTest() {
        val collector = ShapeCollector<ColoredShape2d>()
        collector.addFigure(Circle(2.0, Color(), Color()))
        collector.addFigure(Rectangle(2.0, 2.0, Color(), Color()))
        val fileColl = ListFigureFile()
        collector.addFigure(Triangle(1.2, 2.9, 3.0, Color(), Color()))
        fileColl.serializationToFile(collector.getListFigure(), "src/main/kotlin/lab6/save.txt")
        val expected =
            "[{\"type\":\"lab2.Circle\",\"radius\":2.0,\"borderColor\":{},\"fillColor\":{},\"s\":12.566370614359172},{\"type\":\"lab2.Rectangle\",\"lengthFirstSide\":2.0,\"lengthSecondSide\":2.0,\"borderColor\":{},\"fillColor\":{},\"s\":4.0},{\"type\":\"lab2.Triangle\",\"lengthFirstSide\":1.2,\"lengthSecondSide\":2.9,\"lengthThirdSide\":3.0,\"borderColor\":{},\"fillColor\":{},\"s\":1.7269753182949656}]"
        assertEquals(expected, File("src/main/kotlin/lab6/save.txt").readText())
    }

    @Test
    fun deserializationFromFileTest() {
        val collector = ShapeCollector<ColoredShape2d>()
        collector.addFigure(Circle(2.0, Color(), Color()))
        collector.addFigure(Rectangle(2.0, 2.0, Color(), Color()))
        val fileColl = ListFigureFile()
        collector.addFigure(Triangle(1.2, 2.9, 3.0, Color(), Color()))
        fileColl.serializationToFile(collector.getListFigure(), "src/main/kotlin/lab6/save.txt")
        val expected = mutableListOf<ColoredShape2d>(Circle(2.0, Color(), Color()))
        expected.add(Rectangle(2.0, 2.0, Color(), Color()))
        expected.add(Triangle(1.2, 2.9, 3.0, Color(), Color()))
        assertEquals(expected, fileColl.deserializationFromFile("src/main/kotlin/lab6/save.txt"))
    }
}