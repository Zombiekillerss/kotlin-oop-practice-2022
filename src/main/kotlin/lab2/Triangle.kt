package lab2

import kotlin.math.sqrt

class Triangle(
    private val lengthFirstSide: Double = 0.0,
    private val lengthSecondSide: Double = 0.0,
    private val lengthThirdSide: Double = 0.0,
    override val borderColor: Color,
    override val fillColor: Color
) :
    Figure {
    init {
        require(lengthFirstSide > 0.0 && lengthSecondSide > 0.0 && lengthThirdSide > 0.0) { "Side lengths entered incorrectly!!" }
        require(
            lengthFirstSide + lengthSecondSide > lengthThirdSide
                    && lengthFirstSide + lengthThirdSide > lengthSecondSide
                    && lengthSecondSide + lengthThirdSide > lengthFirstSide
        ) { "You entered an invalid triangle!!!" }
    }

    private var s: Double = 0.0
    override fun calcArea(): Double {
        s = if (s == 0.0) {
            val perimeter = (lengthFirstSide + lengthSecondSide + lengthThirdSide) / 2
            sqrt(
                perimeter * (perimeter - lengthFirstSide) * (perimeter - lengthSecondSide) * (perimeter - lengthThirdSide)
            )
        } else s
        return s
    }

    override fun toString(): String {
        return "Triangle(first side length = $lengthFirstSide, second side length = $lengthSecondSide, third side length = $lengthThirdSide)"
    }
}