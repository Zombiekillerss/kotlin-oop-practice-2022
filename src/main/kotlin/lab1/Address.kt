package lab1

class Address(val postcode: String, val city: String, val street: String, val houseNumber: String)

fun parseAddresses(addresses: String) : MutableList<Address> {
    val addressList:MutableList<Address> = mutableListOf()
    var postcode: String
    var city: String
    var street: String
    var houseNumber: String
    var isFullStop = true
    var i = 0
    val separator = '\n'
    while(i != addresses.length) {
        if(isFullStop && addresses[i]=='.') {
            isFullStop = false
            i++
            while(addresses[i] == ' ') {
                i++
            }
            continue
        }
        else if(!isFullStop && addresses[i] == separator) {
            isFullStop = true
            i += 1
            continue
        }
        else if(isFullStop){
            i++
            continue
        }
        postcode = addresses.substring(i,addresses.indexOf(',', i))
        i += postcode.length + 1
        postcode = postcode.trimIndent()

        city = addresses.substring(i,addresses.indexOf(',', i))
        i += city.length + 1
        city = city.trimIndent()

        street = addresses.substring(i,addresses.indexOf(',', i))
        i += street.length + 1
        street = street.substring(street.indexOf('.') + 1).trimIndent()

        houseNumber = if(addresses.indexOf(separator,i) != -1)
            addresses.substring(i,addresses.indexOf(separator,i))
        else
            addresses.substring(i)
        i += houseNumber.length

        houseNumber = houseNumber.substring(houseNumber.indexOf('.') + 1).trimIndent()

        addressList.add(Address(postcode,city,street,houseNumber))
    }
    return addressList
}
