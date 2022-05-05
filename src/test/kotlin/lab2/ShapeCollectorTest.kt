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
        @Test
        fun getFigureLargestNull() {
            val collector = ShapeCollector()
            val expected = null
            assertEquals(expected, collector.getFigureLargest())
        }

        @Test
        fun getFigureLargest() {
            val collector = ShapeCollector()
            collector.addFigure(Circle(9.0, Color(), Color()))
            collector.addFigure(Circle(10.0, Color(), Color()))
            val expected = Circle(10.0, Color(), Color())
            assertEquals(expected, collector.getFigureLargest())
        }

        getFigureLargest()
        getFigureLargestNull()
    }

    @Test
    fun getSumAreaTest() {
        val figure1 = Circle(10.8, Color(), Color())
        val figure2 = Circle(9.0, Color(), Color())
        val expected = figure1.calcArea() + figure2.calcArea()
        val collector = ShapeCollector()
        try {
            collector.getSumArea()
            assert(false)
        } catch (e: Exception) {
            val exception = "You have not added a figure!"
            assertEquals(exception, e.message)
        }
        collector.addFigure(figure1)
        collector.addFigure(figure2)
        assertEquals(expected, collector.getSumArea())
    }

    @Test
    fun findBorderColorTest() {
        val figure1 = Circle(10.8, Color(1, 2), Color())
        val figure2 = Circle(9.0, Color(), Color())
        val expected = listOf<Figure>(figure1)
        val collector = ShapeCollector()
        collector.addFigure(figure1)
        collector.addFigure(figure2)
        assertEquals(expected, collector.findBorderColor(Color(1, 2)))
    }

    @Test
    fun findFillColorTest() {
        val figure1 = Circle(10.8, Color(), Color(1, 2))
        val figure2 = Circle(9.0, Color(), Color())
        val expected = listOf<Figure>(figure1)
        val collector = ShapeCollector()
        collector.addFigure(figure1)
        collector.addFigure(figure2)
        assertEquals(expected, collector.findFillColor(Color(1, 2)))
    }

    @Test
    fun getBorderFigureTest() {
        val figure1 = Circle(10.8, Color(1, 2), Color())
        val figure2 = Circle(9.0, Color(), Color())
        val expected = mutableMapOf(Color(1,2) to listOf<Figure>(figure1))
        val collector = ShapeCollector()
        collector.addFigure(figure1)
        collector.addFigure(figure2)
        assertEquals(expected, collector.getBorderFigure(Color(1, 2)))
    }

    @Test
    fun getFillFigure() {
    }

    @Test
    fun getListDifferentFigure() {
    }
}