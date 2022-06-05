package coursework.contacts.address

data class Address(
    var postcode: String = "",
    var city: String = "",
    var street: String = "",
    var houseNumber: String = ""
) {
    override fun toString(): String {
        return "$postcode $city $street $houseNumber"
    }
}