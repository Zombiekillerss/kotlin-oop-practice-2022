package lab2

class ShapeCollector {
    private var listFigure: MutableList<Figure> = mutableListOf()
    private var maxS: Figure? = null
    private var minS: Figure? = null
    private var sum: Double = 0.0
    fun addFigure(newFigure: Figure) {
        newFigure.calcArea()
        if (maxS == null)
            maxS = newFigure
        else if (maxS!!.calcArea() < newFigure.calcArea())
            maxS = newFigure
        if (minS == null)
            minS = newFigure
        else if (minS!!.calcArea() > newFigure.calcArea())
            minS = newFigure
        sum += newFigure.calcArea()
        listFigure.add(newFigure)
    }

    fun getFigureSmallest(): Figure {
        return minS as Figure
    }

    fun getFigureLargest(): Figure {
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

    fun getListDifferentFigure(): List<List<Figure>>{
        return listFigure.let { figure ->
            listOf(
                figure.filterIsInstance<Circle>(),
                figure.filterIsInstance<Square>(),
                figure.filterIsInstance<Rectangle>(),
                figure.filterIsInstance<Triangle>(),
            )
        }
    }
}