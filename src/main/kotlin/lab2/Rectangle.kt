package lab2

class Rectangle(
    private val lengthFirstSide: Double,
    private val lengthSecondSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) :
    Figure {
    init {
        require(lengthFirstSide > 0 && lengthSecondSide > 0) { "Side lengths entered incorrectly!!" }
    }

    private var s: Double = 0.0
    override fun calcArea(): Double {
        s = if (s == 0.0)
            lengthFirstSide * lengthSecondSide
        else s
        return s
    }

    override fun toString(): String {
        return "Rectangle(first side length = $lengthFirstSide, second side length = $lengthSecondSide)"
    }
}
