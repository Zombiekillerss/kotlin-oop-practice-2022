package lab5

class ShapeCollector<Figure : ColoredShape2d> {
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

    fun getFigureSmallest(): Figure? {
        return minS
    }

    fun getFigureLargest(): Figure? {
        return maxS
    }

    fun getSumArea(): Double {
        require(sum != 0.0) { "You have not added a figure!" }
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

    fun addAll(newListFigure: Collection<Figure>) {
        listFigure.addAll(newListFigure)
    }

    fun getSorted(newComparator: Comparator<Figure>): List<Figure> {
        val sortList = listFigure
        sortList.sortWith(newComparator)
        return sortList
    }

    fun getListDifferentFigure(): Map<Class<Any>, List<Figure>> {
        return listFigure.groupBy { it.javaClass }
    }
}