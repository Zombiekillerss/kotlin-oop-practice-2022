package lab1

class Address(val postcode: String, val city: String, val street: String, val houseNumber: String)

fun parseAddresses(addresses: String): List<Address> {
    val addressList: MutableList<Address> = mutableListOf()
    var postcode: String
    var city: String
    var street: String
    var houseNumber: String
    val separator = '\n'
    val stringList = addresses.trimIndent().split(separator)
    for (i in stringList) {
        // i = *. ... , ... , ... , ...
        //postcode = *. (...) ,   ,   ,
        postcode = i.substring(i.indexOf('.') + 1, i.indexOf(','))
        postcode = postcode.trimIndent()
        //city = *.   , (...) ,   ,
        city = i.substring(i.indexOf(',') + 1, i.indexOf(',', i.indexOf(',') + 1))
        city = city.trimIndent()
        //street = *.   ,   , (...) ,
        // i.substring(i.indexOf(',', i.indexOf(',') + 1)) = *.   ,   (,   , )
        // i.substring(i.indexOf(',', i.indexOf(',') + 1))
        //            .substring(1, i.substring(i.indexOf(',', i.indexOf(',') + 1) + 1).indexOf(',')) = *.   ,   ,(   ),
        street = i.substring(i.indexOf(',', i.indexOf(',') + 1))
            .substring(1, i.substring(i.indexOf(',', i.indexOf(',') + 1) + 1).indexOf(','))
        street = street.substring(street.indexOf('.') + 1).trimIndent()
        //houseNumber = *.   ,   ,   , (...)
        houseNumber = i.substring(i.lastIndexOf(',') + 1)
        houseNumber = houseNumber.substring(houseNumber.indexOf('.') + 1).trimIndent()

        addressList.add(Address(postcode, city, street, houseNumber))
    }
    return addressList
}
