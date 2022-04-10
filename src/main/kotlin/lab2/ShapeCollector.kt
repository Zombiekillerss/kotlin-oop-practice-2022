package lab1.lab2

import kotlin.math.*

class Figure(
    override val borderColor: Color,
    override val fillColor: Color,
    val lengthFirstSide: Double = 0.0,
    val lengthSecondSide: Double = 0.0,
    val lengthThirdSide: Double = 0.0
) : ColoredShape2d {
    private var s: Double = 0.0
    override fun calcArea(): Double {
        if (!(borderColor.blue in 0..255 && borderColor.red in 0..255
                    && borderColor.green in 0..255 && fillColor.blue in 0..255
                    && fillColor.red in 0..255 && fillColor.green in 0..255
                    && fillColor.transparency in 0..100 && borderColor.transparency in 0..100)
        )
            error(
                "Wrong color values"
            )
        s = if (s == 0.0) {
            if (lengthFirstSide > 0.0 && lengthSecondSide > 0.0 && lengthThirdSide > 0.0) {
                if (lengthFirstSide + lengthSecondSide > lengthThirdSide
                    && lengthFirstSide + lengthThirdSide > lengthSecondSide
                    && lengthSecondSide + lengthThirdSide > lengthFirstSide
                ) {
                    val perimeter = (lengthFirstSide + lengthSecondSide + lengthThirdSide) / 2
                    sqrt(
                        perimeter * (perimeter - lengthFirstSide) * (perimeter - lengthSecondSide) * (perimeter - lengthThirdSide)
                    )
                } else error(("Invalid triangle sides"))
            } else if (lengthFirstSide > 0.0 && lengthSecondSide > 0.0)
                lengthFirstSide * lengthSecondSide
            else if (lengthFirstSide > 0.0)
                PI * lengthFirstSide.pow(2.0)
            else error("All side values are 0 or some sides are less than 0")
        } else s
        return s
    }

    fun getS(): Double {
        return s
    }
}

class ShapeCollector {
    private var listFigure: MutableList<Figure> = mutableListOf()
    private var maxS: Figure? = null
    private var minS: Figure? = null
    private var sum: Double = 0.0
    fun addFigure(newFigure: Figure) {
        newFigure.calcArea()
        if (maxS == null)
            maxS = newFigure
        else if (maxS!!.getS() < newFigure.getS())
            maxS = newFigure
        if (minS == null)
            minS = newFigure
        else if (minS!!.getS() > newFigure.getS())
            minS = newFigure
        sum += newFigure.getS()
        listFigure.add(newFigure)
    }

    fun getFigureSmallest(): Figure {
        if (minS == null)
            error("You have not added a figure!")
        return minS as Figure
    }

    fun getFigureLargest(): Figure {
        if (maxS == null)
            error("You have not added a figure!")
        return maxS as Figure
    }

    fun getSumArea(): Double {
        if (sum == 0.0)
            error("You have not added a figure!")
        return sum
    }

    fun findBorderColor(borderColor: Color): List<Figure> {
        return listFigure.filter { it.borderColor == borderColor } as MutableList<Figure>
    }

    fun findFillColor(fillColor: Color): List<Figure> {
        return listFigure.filter { it.fillColor == fillColor } as MutableList<Figure>
    }

    fun getListFigure(): List<Figure> {
        return listFigure
    }

    fun getCountFigure(): Int {
        return listFigure.size
    }

    fun getBorderFigure(borderColor: Color): Map<Color, List<Figure>> {
        return mapOf(borderColor to (listFigure.filter { it.borderColor == borderColor }))
    }

    fun getFillFigure(fillColor: Color): Map<Color, List<Figure>> {
        return mapOf(fillColor to (listFigure.filter { it.fillColor == fillColor }))
    }

    fun getListDifferentFigure(): List<List<Figure>> {
        return listFigure.let { figure ->
            listOf(
                figure.filter {
                    it.lengthFirstSide != 0.0 && it.lengthSecondSide == 0.0 && it.lengthThirdSide == 0.0
                },
                figure.filter {
                    it.lengthFirstSide == it.lengthSecondSide && it.lengthSecondSide != 0.0 && it.lengthThirdSide == 0.0
                },
                figure.filter {
                    it.lengthFirstSide != it.lengthSecondSide && it.lengthSecondSide != 0.0
                            && it.lengthThirdSide == 0.0 && it.lengthFirstSide != 0.0
                },
                figure.filter {
                    it.lengthFirstSide != 0.0 && it.lengthSecondSide != 0.0 && it.lengthThirdSide != 0.0
                },
            )
        }
    }
}