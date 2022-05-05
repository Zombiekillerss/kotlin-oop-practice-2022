package lab2

fun printList(listListFigures: List<List<Figure>>) {
    if (listListFigures.isNotEmpty()) {
        for (i in listListFigures) {
            for (j in i) {
                when (i) {
                    listListFigures[0] -> print(j)
                    listListFigures[1] -> print(j)
                    listListFigures[2] -> print(j)
                    listListFigures[3] -> print(j)
                }
            }
            if (i.isNotEmpty()) println("")
        }
    }
}

fun printListFigures(listFigures: List<Figure>) {
    for (i in listFigures) {
        println(i)
    }
}

fun main() {
    val figures = ShapeCollector()
    figures.addFigure(Circle(2.0, Color(2, 2, 2), Color(3, 3)))
    var listListFigures = figures.getListDifferentFigure()
    printList(listListFigures)
    figures.addFigure(Square(2.0, Color(2, 2, 2), Color(3)))
    figures.addFigure(Rectangle(2.0, 3.0,Color(2, 2, 2), Color(3, 3)))
    figures.addFigure(Triangle(2.0, 3.0, 2.0, Color(2, 0, 2), Color(3)))
    listListFigures = figures.getListDifferentFigure()
    printList(listListFigures)
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
}