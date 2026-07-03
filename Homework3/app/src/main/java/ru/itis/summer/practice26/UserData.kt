package ru.itis.summer.practice26

open class UserData(
    private val arg1: Int = 0,
    open val arg2: String,
    val arg3: Long,
) {
    open fun sumArg1AndArg2(): Int = arg1 + arg2.length
}

class UserDataExtended(arg1: Int, arg2: String) :
    UserData(
        arg2 = arg1.toString(),
        arg3 = arg2.length.toLong()
    ), GeoData {

    override val arg2: String = ""

    override fun sumArg1AndArg2(): Int {
        return 1 + 3
    }

    override fun getLatitude(): Double = 42.2

    override fun getLongitude(): Double = (arg2.length + arg3).toDouble()
}

open class UserDataSample2

//class UserAddressData(
//    val street: String,
//    val phoneNumber: String,
//    val houseNumber: String,
//    val city: String
//)

data class UserAddressData(
    val city: String,
    val street: String,
    val houseNumber: String,
    val phoneNumber: String? = null,
    val postOfficeData: PostOfficeData? = null
)

data class PostOfficeData(
    val index: Int,
    val postPhone: String,
)

interface GeoData {
    fun getLatitude(): Double
    fun getLongitude(): Double
}