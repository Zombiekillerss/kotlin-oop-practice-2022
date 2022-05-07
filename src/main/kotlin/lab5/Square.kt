package lab5

import kotlin.math.pow

class Square(private val lengthSide: Double, override val borderColor: Color, override val fillColor: Color) :
    ColoredShape2d {
    init {
        require(lengthSide > 0) { "Side lengths entered incorrectly!!" }
    }

    private var s: Double = 0.0
    override fun calcArea(): Double {
        s = if (s == 0.0)
            lengthSide.pow(2.0)
        else s
        return s
    }

    override fun toString(): String {
        return "Square(first side length = $lengthSide, second side length = $lengthSide)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Square

        if (lengthSide != other.lengthSide) return false
        if (borderColor != other.borderColor) return false
        if (fillColor != other.fillColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lengthSide.hashCode()
        result = 31 * result + borderColor.hashCode()
        result = 31 * result + fillColor.hashCode()
        result = 31 * result + s.hashCode()
        return result
    }
}