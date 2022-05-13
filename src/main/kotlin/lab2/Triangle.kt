package lab2

import kotlinx.serialization.Serializable
import kotlin.math.sqrt

@Serializable
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Triangle

        if (lengthFirstSide != other.lengthFirstSide) return false
        if (lengthSecondSide != other.lengthSecondSide) return false
        if (lengthThirdSide != other.lengthThirdSide) return false
        if (borderColor != other.borderColor) return false
        if (fillColor != other.fillColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lengthFirstSide.hashCode()
        result = 31 * result + lengthSecondSide.hashCode()
        result = 31 * result + lengthThirdSide.hashCode()
        result = 31 * result + borderColor.hashCode()
        result = 31 * result + fillColor.hashCode()
        result = 31 * result + s.hashCode()
        return result
    }
}