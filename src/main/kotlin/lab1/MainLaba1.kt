package lab1

fun main() {
    val str = """
            1. 123, Название города 1, ул. Название улицы, д. Номер дома
                 2. 124, Название города 2, ул. Название улицы1    , д. Номер дома1        
            3. 124, Название города 3, ул. Название улицы22, д. Номер дома2           
    """
    val addressList: List<Address> = parseAddresses(str)
    println("2. ${addressList[2].postcode}, ${addressList[1].city}, ул. ${addressList[1].street}, д. ${addressList[2].houseNumber}.")
    var maxPostcode = addressList[0]
    var minPostcode = addressList[0]
    var longNameStreet = addressList[0]
    var shortNameStreet = addressList[0]
    for (i in addressList.indices) {
        if (maxPostcode.postcode.toInt() < addressList[i].postcode.toInt())
            maxPostcode = addressList[i]
        if (minPostcode.postcode.toInt() > addressList[i].postcode.toInt())
            minPostcode = addressList[i]
        if (longNameStreet.street.length < addressList[i].street.length)
            longNameStreet = addressList[i]
        if (shortNameStreet.street.length > addressList[i].street.length)
            shortNameStreet = addressList[i]
    }
    println("Address with max postcode: ${maxPostcode.postcode}, ${maxPostcode.city}, ул. ${maxPostcode.street}, д. ${maxPostcode.houseNumber}.")
    println("Address with min postcode: ${minPostcode.postcode}, ${minPostcode.city}, ул. ${minPostcode.street}, д. ${minPostcode.houseNumber}.")
    println("Address with shortest street name ${shortNameStreet.postcode}, ${shortNameStreet.city}, ул. ${shortNameStreet.street}, д. ${shortNameStreet.houseNumber}.")
    println("Address with longest street name ${longNameStreet.postcode}, ${longNameStreet.city}, ул. ${longNameStreet.street}, д. ${longNameStreet.houseNumber}.")
}