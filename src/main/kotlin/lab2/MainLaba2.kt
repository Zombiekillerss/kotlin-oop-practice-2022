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

fun main() {
    val figures = ShapeCollector()
    figures.addFigure(Figure(Color(2, 2, 2), Color(3, 3), 2.0))
    var listListFigures = figures.getListDifferentFigure()
    printList(listListFigures)
    figures.addFigure(Figure(Color(2, 2, 2), Color(3, 3), 2.0, 2.0))
    figures.addFigure(Figure(Color(2, 2, 2), Color(3, 3), 2.0, 3.0))
    figures.addFigure(Figure(Color(2, 2, 2), Color(3, 3), 2.0, 3.0, 2.0))
    listListFigures = figures.getListDifferentFigure()
    printList(listListFigures)
}