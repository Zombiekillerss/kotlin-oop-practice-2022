package coursework.contacts.dateofbirth

data class DateBirth(var day: Int = 0, var month: Int = 0, var year: Int = 0) {
    override fun toString(): String {
        return "$day $month $year)"
    }
}