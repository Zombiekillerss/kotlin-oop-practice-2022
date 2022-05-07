package lab5

class FigureComparator : Comparator<ColoredShape2d> {
    override fun compare(figure1: ColoredShape2d, figure2: ColoredShape2d): Int {
        return if (figure1.calcArea() == figure2.calcArea())
            0
        else if (figure1.calcArea() > figure2.calcArea())
            1
        else -1
    }

}