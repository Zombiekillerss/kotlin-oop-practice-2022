package coursework.contacts.numbersphone

class NumbersPhone {
    private val listNumbers: MutableList<String> = mutableListOf()

    fun getList(): List<String> {
        return listNumbers
    }

    fun addAll(newListNumbers: List<String>) {
        listNumbers.addAll(newListNumbers)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NumbersPhone

        if (listNumbers != other.listNumbers) return false

        return true
    }

    override fun hashCode(): Int {
        return listNumbers.hashCode()
    }

    override fun toString(): String {
        var str = ""
        for (i in listNumbers.indices) {
            str += listNumbers[i]
            if (i != listNumbers.size - 1)
                str += ","
        }
        return str
    }

    fun clear() {
        listNumbers.clear()
    }
}