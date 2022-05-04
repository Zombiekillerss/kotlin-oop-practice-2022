package lab2

import kotlin.math.pow

class Square(private val lengthSide: Double, override val borderColor: Color, override val fillColor: Color) :
    Figure {
    init {
        require(lengthSide > 0) { ";pl" }
    }

    private var s: Double = 0.0
    override fun calcArea(): Double {
        s = if (s == 0.0)
            lengthSide.pow(2.0)
        else s
        return s
    }
}