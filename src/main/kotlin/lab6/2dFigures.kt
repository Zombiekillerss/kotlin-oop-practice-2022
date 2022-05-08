package lab6

import kotlinx.serialization.Serializable

@Serializable
data class Color(val red: Int = 0, val green: Int = 0, val blue: Int = 0, val transparency: Int = 0) {
    init {
        require(red in 0 until 256) { "Incorrect red value entered" }
        require(green in 0 until 256) { "Incorrect green value entered" }
        require(blue in 0 until 256) { "Incorrect blue value entered" }
        require(transparency in 0 until 101) { "Incorrect color transparency value entered" }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Color

        if (red != other.red) return false
        if (green != other.green) return false
        if (blue != other.blue) return false
        if (transparency != other.transparency) return false

        return true
    }

    override fun hashCode(): Int {
        var result = red
        result = 31 * result + green
        result = 31 * result + blue
        result = 31 * result + transparency
        return result
    }
}

interface Shape2d {
    fun calcArea(): Double
}

interface ColoredShape2d : Shape2d {
    val borderColor: Color
    val fillColor: Color
}

interface Figure : ColoredShape2d