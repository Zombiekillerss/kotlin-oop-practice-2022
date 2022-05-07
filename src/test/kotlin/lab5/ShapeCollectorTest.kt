package lab5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ShapeCollectorTest {

    @Test
    fun addAllTest() {
        val figures = ShapeCollector<ColoredShape2d>()
        figures.addFigure(Circle(2.0, Color(2, 2, 2), Color(3, 3)))
        figures.addFigure(Square(2.0, Color(2, 2, 2), Color(3)))
        figures.addFigure(Rectangle(2.0, 3.0, Color(2, 2, 2), Color(3, 3)))
        figures.addFigure(Triangle(2.0, 3.0, 2.0, Color(2, 0, 2), Color(3)))
        val newList = listOf(Circle(1.0, Color(), Color()), Circle(2.3, Color(), Color()))
        figures.addAll(newList)
        val expected = listOf(
            Circle(2.0, Color(2, 2, 2), Color(3, 3)),
            Square(2.0, Color(2, 2, 2), Color(3)),
            Rectangle(2.0, 3.0, Color(2, 2, 2), Color(3, 3)),
            Triangle(2.0, 3.0, 2.0, Color(2, 0, 2), Color(3))
        ) + newList
        assertEquals(expected, figures.getListFigure())
    }

    @Test
    fun getSorted() {
    }
}