package lab2

import kotlinx.serialization.Serializable

@Serializable
data class Color(val red: Int = 0, val green: Int = 0, val blue: Int = 0, val transparency: Int = 0) {
    init {
        require(red in 0 until 256) { "Incorrect red value entered" }
        require(green in 0 until 256) { "Incorrect green value entered" }
        require(blue in 0 until 256) { "Incorrect blue value entered" }
        require(transparency in 0 until 101) { "Incorrect color transparency value entered" }
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