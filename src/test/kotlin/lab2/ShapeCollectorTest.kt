package lab2

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ShapeCollectorTest {

    @Test
    fun addFigureTests() {
        @Test
        fun addCircleWithException() {
            val collector = ShapeCollector()
            try {
                collector.addFigure(Circle(-9.9, Color(), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "Radius entered incorrectly!!"
                assertEquals(expected, e.message)
            }
        }

        @Test
        fun addSquareWithException() {
            val collector = ShapeCollector()
            try {
                collector.addFigure(Square(-9.9, Color(), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "Side lengths entered incorrectly!!"
                assertEquals(expected, e.message)
            }
        }

        @Test
        fun addRectangleWithException() {
            val collector = ShapeCollector()
            try {
                collector.addFigure(Rectangle(-9.9, -9.9, Color(), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "Side lengths entered incorrectly!!"
                assertEquals(expected, e.message)
            }
        }

        @Test
        fun addTriangleWithException() {
            val collector = ShapeCollector()
            try {
                collector.addFigure(Triangle(-9.9, 0.0, -9.8, Color(), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "Side lengths entered incorrectly!!"
                assertEquals(expected, e.message)
            }
            try {
                collector.addFigure(Triangle(2.0, 2.0, 5.0, Color(), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "You entered an invalid triangle!!!"
                assertEquals(expected, e.message)
            }
        }

        @Test
        fun addFigureWithColorException() {
            val collector = ShapeCollector()
            try {
                collector.addFigure(Circle(1.0, Color(-1), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "Incorrect red value entered"
                assertEquals(expected, e.message)
            }
            try {
                collector.addFigure(Circle(1.0, Color(1, -9), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "Incorrect green value entered"
                assertEquals(expected, e.message)
            }
            try {
                collector.addFigure(Circle(-1.0, Color(1, 1, -9), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "Incorrect blue value entered"
                assertEquals(expected, e.message)
            }
            try {
                collector.addFigure(Circle(-1.0, Color(1, 1, 1, -9), Color()))
                assert(false)
            } catch (e: Exception) {
                val expected = "Incorrect color transparency value entered"
                assertEquals(expected, e.message)
            }
        }

        @Test
        fun addFigures() {
            val collector = ShapeCollector()
            collector.addFigure(Circle(8.0, Color(), Color()))
            collector.addFigure(Circle(10.0, Color(), Color()))
            val list = listOf<Figure>(Circle(8.0, Color(), Color()), Circle(10.0, Color(), Color()))
            assertEquals(list, collector.getListFigure())
        }

        addFigures()
        addFigureWithColorException()
        addTriangleWithException()
        addRectangleWithException()
        addSquareWithException()
        addCircleWithException()
    }

    @Test
    fun getFigureSmallestTest() {
        @Test
        fun getFigureSmallestNull() {
            val collector = ShapeCollector()
            val expected = null
            assertEquals(expected, collector.getFigureSmallest())
        }

        @Test
        fun getFigureSmallest() {
            val collector = ShapeCollector()
            collector.addFigure(Circle(9.0, Color(), Color()))
            collector.addFigure(Circle(10.0, Color(), Color()))
            val expected = Circle(9.0, Color(), Color())
            assertEquals(expected, collector.getFigureSmallest())
        }

        getFigureSmallest()
        getFigureSmallestNull()
    }

    @Test
    fun getFigureLargest() {
    }

    @Test
    fun getSumArea() {
    }

    @Test
    fun findBorderColor() {
    }

    @Test
    fun findFillColor() {
    }

    @Test
    fun getCountFigure() {
    }

    @Test
    fun getBorderFigure() {
    }

    @Test
    fun getFillFigure() {
    }

    @Test
    fun getListDifferentFigure() {
    }
}