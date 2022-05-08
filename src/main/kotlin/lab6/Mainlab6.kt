package lab6

fun main() {
    val collector = ShapeCollector()
    collector.addFigure(Circle(2.0,Color(),Color()))
    collector.addFigure(Rectangle(2.0,2.0,Color(),Color()))
    val fileColl = CollectorFile()
    fileColl.serializationToFile(collector.getListFigure(), "src/main/kotlin/lab6/save.txt")
    val listFigure = fileColl.deserializationFromFile("src/main/kotlin/lab6/save.txt").toMutableList()
    listFigure += listOf(Triangle(1.2, 2.9, 3.0, Color(), Color()))
    fileColl.serializationToFile(listFigure, "src/main/kotlin/lab6/save.txt")
}