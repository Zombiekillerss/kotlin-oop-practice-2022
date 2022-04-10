package lab1.lab2

fun printList(listListFigures: List<List<Figure>>) {
    if (listListFigures.isNotEmpty()) {
        for (i in listListFigures) {
            for (j in i) {
                when (i) {
                    listListFigures[0] -> print("Circle with radius ${j.lengthFirstSide}")
                    listListFigures[1] -> print("Square with sides ${j.lengthFirstSide}, ${j.lengthSecondSide}")
                    listListFigures[2] -> print("Rectangle with sides ${j.lengthFirstSide}, ${j.lengthSecondSide}")
                    listListFigures[3] -> print("Triangle with sides ${j.lengthFirstSide}, ${j.lengthSecondSide}, ${j.lengthThirdSide}")
                }
            }
            if (i.isNotEmpty()) println("")
        }
    }
}

fun printListFigures(listFigures: List<Figure>) {
    for (i in listFigures) {
        println("Sides of the figure ${i.lengthFirstSide}, ${i.lengthSecondSide}, ${i.lengthThirdSide}")
    }
}

fun main() {
    val figures = ShapeCollector()
    figures.addFigure(Figure(Color(2, 2, 2), Color(3, 3), 2.0))
    var listListFigures = figures.getListDifferentFigure()
    printList(listListFigures)
    figures.addFigure(Figure(Color(2, 2, 2), Color(3), 2.0, 2.0))
    figures.addFigure(Figure(Color(2, 2, 2), Color(3, 3), 2.0, 3.0))
    figures.addFigure(Figure(Color(2, 0, 2), Color(3), 2.0, 3.0, 2.0))
    listListFigures = figures.getListDifferentFigure()
    printList(listListFigures)
    println(
        "Sides of the figure with the smallest area ${figures.getFigureSmallest().lengthFirstSide}, " +
                "${figures.getFigureSmallest().lengthSecondSide}, ${figures.getFigureSmallest().lengthThirdSide},"
    )
    println(
        "Sides of the figure with the largest area ${figures.getFigureLargest().lengthFirstSide}, " +
                "${figures.getFigureLargest().lengthSecondSide}, ${figures.getFigureLargest().lengthThirdSide}"
    )
    println("Sum of all areas ${figures.getSumArea()}")
    printListFigures(figures.findBorderColor(Color(2, 2, 0)))
    printListFigures(figures.findBorderColor(Color(2, 2, 2)))
    println("")
    printListFigures(figures.findFillColor(Color(3, 2)))
    printListFigures(figures.findFillColor(Color(3, 3)))
    println("")
    printListFigures(figures.getListFigure())
    println("")
    println("Number of figures ${figures.getCountFigure()}")
    println("")
    figures.getBorderFigure(Color(2, 0, 2))[Color(2, 0, 2)]?.let { printListFigures(it) }
    println("")
    figures.getFillFigure(Color(3, 3))[Color(3, 3)]?.let { printListFigures(it) }
}