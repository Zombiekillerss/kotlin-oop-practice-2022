package coursework.contacts.numbersphone

class NumbersPhone {
    private val listNumbers: MutableList<String> = mutableListOf()

    fun getList(): List<String>{
        return listNumbers
    }

    fun addNumber(number: String){
        listNumbers.add(number)
    }

    fun addAll(newListNumbers: List<String>){
        listNumbers.addAll(newListNumbers)
    }

    fun remove(number: String){
        listNumbers.remove(number)
    }

    fun changeNumber(index: Int, newNumber:String){
        listNumbers[index] = newNumber
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
        return "$listNumbers"
    }
}