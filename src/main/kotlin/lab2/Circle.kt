package lab2

import kotlinx.serialization.Serializable
import kotlin.math.PI
import kotlin.math.pow

@Serializable
class Circle(val radius: Double, override val borderColor: Color, override val fillColor: Color) :
    ColoredShape2d {
    init {
        require(radius > 0) { "Radius entered incorrectly!!" }
    }

    private var s: Double = 0.0
    override fun calcArea(): Double {
        s = if (s == 0.0)
            PI * radius.pow(2.0)
        else s
        return s
    }

    override fun toString(): String {
        return "Circle(radius = $radius)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Circle

        if (radius != other.radius) return false
        if (borderColor != other.borderColor) return false
        if (fillColor != other.fillColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = radius.hashCode()
        result = 31 * result + borderColor.hashCode()
        result = 31 * result + fillColor.hashCode()
        result = 31 * result + s.hashCode()
        return result
    }
}