package lab1.lab2

data class Color(val red: Int = 0, val green: Int = 0, val blue: Int = 0, val transparency: Int = 0)

interface Shape2d {
    fun calcArea(): Double
}

interface ColoredShape2d : Shape2d {
    val borderColor: Color
    val fillColor: Color
}