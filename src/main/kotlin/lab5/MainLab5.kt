package lab5

fun printList(listListFigures: Collection<List<ColoredShape2d>>) {
    if (listListFigures.isNotEmpty()) {
        for (i in listListFigures) {
            println(i)
        }
        println("")
    }
}

fun printListFigures(listFigures: List<ColoredShape2d>) {
    for (i in listFigures) {
        println(i)
    }
}

fun main() {
    val figures = ShapeCollector<ColoredShape2d>()
    figures.addFigure(Circle(2.0, Color(2, 2, 2), Color(3, 3)))
    var listListFigures = figures.getListDifferentFigure()
    printList(listListFigures.values)
    print(listListFigures.keys)
    figures.addFigure(Square(2.0, Color(2, 2, 2), Color(3)))
    figures.addFigure(Rectangle(2.0, 3.0, Color(2, 2, 2), Color(3, 3)))
    figures.addFigure(Triangle(2.0, 3.0, 2.0, Color(2, 0, 2), Color(3)))
    listListFigures = figures.getListDifferentFigure()
    printList(listListFigures.values)
    println(listListFigures.keys)
    println(figures.getFigureSmallest())
    println(figures.getFigureLargest())
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
    println("")
    println(figures.getSorted(FigureComparator()))
    println("")
    figures.addAll(listOf(Circle(1.0, Color(), Color())))
    println(figures.getListFigure())
}