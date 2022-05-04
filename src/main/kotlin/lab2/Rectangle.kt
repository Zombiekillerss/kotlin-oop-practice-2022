package lab2

class Rectangle(
    private val lengthFirstSide: Double,
    private val lengthSecondSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) :
    Figure {
    init {
        require(lengthFirstSide > 0 && lengthSecondSide > 0) { "lkj" }
    }

    private var s: Double = 0.0
    override fun calcArea(): Double {
        s = if (s == 0.0)
            lengthFirstSide * lengthSecondSide
        else s
        return s
    }
}
