package lab1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AddressKtTest {
    @Test
    fun stringParserTestWithoutExtraSpaces() {
        val str = """1. 123, Название города 1, ул. Название улицы, д. Номер дома
            2. 124, Название города 2, ул. Название улицы1, д. Номер дома1        
            3. 124, Название города 3, ул. Название улицы22, д. Номер дома2"""
        val addressList: List<Address> = parseAddresses(str)
        val expectedList = listOf(Address("123", "Название города 1", "Название улицы"
            , "Номер дома"), Address("124", "Название города 2", "Название улицы1"
            , "Номер дома1"), Address("124", "Название города 3", "Название улицы22"
            , "Номер дома2"))
        for(i in 0 until 3) {
            assertEquals(expectedList[i].city, addressList[i].city)
            assertEquals(expectedList[i].houseNumber, addressList[i].houseNumber)
            assertEquals(expectedList[i].postcode, addressList[i].postcode)
            assertEquals(expectedList[i].street, addressList[i].street)
        }
    }
    @Test
    fun lineTestWithExtraHyphens() {
        val str = """
            
            
            
            
            
            
            1. 123, Название города 1, ул. Название улицы, д. Номер дома
            
            
            
            
            2. 124, Название города 2, ул. Название улицы1, д. Номер дома1   
                 
                 
                 
                 
                 
                 
            3. 124, Название города 3, ул. Название улицы22, д. Номер дома2
            
            
            
            
            
            """
        val addressList: List<Address> = parseAddresses(str)
        val expectedList = listOf(Address("123", "Название города 1", "Название улицы"
            , "Номер дома"), Address("124", "Название города 2", "Название улицы1"
            , "Номер дома1"), Address("124", "Название города 3", "Название улицы22"
            , "Номер дома2"))
        for(i in 0 until 3) {
            assertEquals(expectedList[i].city, addressList[i].city)
            assertEquals(expectedList[i].houseNumber, addressList[i].houseNumber)
            assertEquals(expectedList[i].postcode, addressList[i].postcode)
            assertEquals(expectedList[i].street, addressList[i].street)
        }
    }
    @Test
    fun testStringsWithExtraSpacesBetweenPunctuationMarks() {
        val str = """
            1.            123       ,             Название города 1           , ул.           Название улицы                , д.         Номер дома
            2.        124      ,             Название города 2                , ул.           Название улицы1       , д.          Номер дома1        
            3.       124          ,            Название города 3             , ул.          Название улицы22              , д.           Номер дома2
            """
        val addressList: List<Address> = parseAddresses(str)
        val expectedList = listOf(Address("123", "Название города 1", "Название улицы"
            , "Номер дома"), Address("124", "Название города 2", "Название улицы1"
            , "Номер дома1"), Address("124", "Название города 3", "Название улицы22"
            , "Номер дома2"))
        for(i in 0 until 3) {
            assertEquals(expectedList[i].city, addressList[i].city)
            assertEquals(expectedList[i].houseNumber, addressList[i].houseNumber)
            assertEquals(expectedList[i].postcode, addressList[i].postcode)
            assertEquals(expectedList[i].street, addressList[i].street)
        }
    }
    @Test
    fun addressSequenceNumberTest() {
        val str = """
                   1      . 123, Название города 1, ул. Название улицы, д. Номер дома
               2    . 124, Название города 2, ул. Название улицы1, д. Номер дома1        
                3534534534534535453534    . 124, Название города 3, ул. Название улицы22, д. Номер дома2
            """
        val addressList: List<Address> = parseAddresses(str)
        val expectedList = listOf(Address("123", "Название города 1", "Название улицы"
            , "Номер дома"), Address("124", "Название города 2", "Название улицы1"
            , "Номер дома1"), Address("124", "Название города 3", "Название улицы22"
            , "Номер дома2"))
        for(i in 0 until 3) {
            assertEquals(expectedList[i].city, addressList[i].city)
            assertEquals(expectedList[i].houseNumber, addressList[i].houseNumber)
            assertEquals(expectedList[i].postcode, addressList[i].postcode)
            assertEquals(expectedList[i].street, addressList[i].street)
        }
    }
}