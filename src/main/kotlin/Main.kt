package lab1

fun main() {
    val str = """
            1. 123, Название города 1, ул. Название улицы, д. Номер дома
            2. 124, Название города 2, ул. Название улицы1, д. Номер дома
    """.trimIndent()
    val addressList: MutableList<Address> = parseAddresses(str)
    println("2. ${addressList[1].postcode}, ${addressList[1].city}, ул. ${addressList[1].street}, д. ${addressList[1].houseNumber}")
    var maxPostcode = Int.MIN_VALUE
    var minPostcode = Int.MAX_VALUE
    var longNameStreet = addressList[0].street
    var shortNameStreet = addressList[0].street
    for(i in addressList.indices){
        if(maxPostcode < addressList[i].postcode.toInt())
            maxPostcode = addressList[i].postcode.toInt()
        if(minPostcode > addressList[i].postcode.toInt())
            minPostcode = addressList[i].postcode.toInt()
        if(longNameStreet.length < addressList[i].street.length)
            longNameStreet = addressList[i].street
        if(shortNameStreet.length > addressList[i].street.length)
            shortNameStreet = addressList[i].street
    }
    println("Max postcode: $maxPostcode, min postcode: $minPostcode.")
    println("Shortest street name $shortNameStreet, longest street name $longNameStreet.")
}