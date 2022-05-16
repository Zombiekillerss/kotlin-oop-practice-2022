package lab6


import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab2.*

class ListFigureSerDes {
    private val json = Json {
        serializersModule = SerializersModule {
            polymorphic(ColoredShape2d::class) {
                subclass(Circle::class)
                subclass(Rectangle::class)
                subclass(Square::class)
                subclass(Triangle::class)
            }
        }
    }

    fun serialization(listFigure: List<ColoredShape2d>): String {
        return json.encodeToString(listFigure)
    }

    fun deserialization(stringToDecoder: String): List<ColoredShape2d> {
        return json.decodeFromString(stringToDecoder)
    }
}