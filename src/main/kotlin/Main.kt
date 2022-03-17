package lab1

fun main() {
    var str:String = """
            1. Индекс1, Название города 1, ул. Название улицы, д. Номер дома
            2. Индекс2, Название города 2, ул. Название улицы, д. Номер дома
    """.trimIndent()
    var addressList:MutableList<Address> = mutableListOf()
    addressList = parseAddresses(str)
    println("OK")
}