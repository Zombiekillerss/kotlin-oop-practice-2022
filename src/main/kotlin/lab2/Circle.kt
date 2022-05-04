package lab2

import kotlin.math.PI
import kotlin.math.pow

class Circle(private val radius: Double, override val borderColor: Color, override val fillColor: Color) :
    Figure {
    init {
        require(radius > 0) { "lol" }
    }

    private var s: Double = 0.0
    override fun calcArea(): Double {
        s = if (s == 0.0)
            PI * radius.pow(2.0)
        else s
        return s
    }
}