package lab2

import kotlinx.serialization.Serializable

@Serializable
class Rectangle(
    val lengthFirstSide: Double,
    val lengthSecondSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rectangle

        if (lengthFirstSide != other.lengthFirstSide) return false
        if (lengthSecondSide != other.lengthSecondSide) return false
        if (borderColor != other.borderColor) return false
        if (fillColor != other.fillColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lengthFirstSide.hashCode()
        result = 31 * result + lengthSecondSide.hashCode()
        result = 31 * result + borderColor.hashCode()
        result = 31 * result + fillColor.hashCode()
        result = 31 * result + s.hashCode()
        return result
    }
}
