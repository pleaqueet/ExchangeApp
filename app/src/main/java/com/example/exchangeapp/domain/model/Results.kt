package com.example.exchangeapp.domain.model

import com.google.gson.annotations.SerializedName

class Results {
    private fun initCurrencies(): MutableList<Currency> {
        val currencies = mutableListOf<Currency>()
        val declaredFields = javaClass.declaredFields
        for (property in declaredFields) {
            try {
                val currencyCode = property.name
                val exchangeRate = property.get(this) as Double
                currencies.add(Currency(currencyCode, exchangeRate.toString()))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return currencies
    }
    var currencies: List<Currency> = initCurrencies()
        get() = initCurrencies()

    @SerializedName("AED")
    var AED: Double = 0.0

    @SerializedName("AFN")
    var AFN = 0.0

    @SerializedName("ALL")
    var ALL = 0.0

    @SerializedName("AMD")
    var AMD = 0.0

    @SerializedName("ANG")
    var ANG = 0.0

    @SerializedName("AOA")
    var AOA = 0.0

    @SerializedName("ARS")
    var ARS = 0.0

    @SerializedName("AUD")
    var AUD = 0.0

    @SerializedName("AWG")
    var AWG = 0.0

    @SerializedName("AZN")
    var AZN = 0.0

    @SerializedName("BAM")
    var BAM = 0.0

    @SerializedName("BBD")
    var BBD = 0.0

    @SerializedName("BDT")
    var BDT = 0.0

    @SerializedName("BGN")
    var BGN = 0.0

    @SerializedName("BHD")
    var BHD = 0.0

    @SerializedName("BIF")
    var BIF = 0.0

    @SerializedName("BMD")
    var BMD = 0.0

    @SerializedName("BND")
    var BND = 0.0

    @SerializedName("BOB")
    var BOB = 0.0

    @SerializedName("BRL")
    var BRL = 0.0

    @SerializedName("BSD")
    var BSD = 0.0

    @SerializedName("BTN")
    var BTN = 0.0

    @SerializedName("BWP")
    var BWP = 0.0

    @SerializedName("BZD")
    var BZD = 0.0

    @SerializedName("CAD")
    var CAD = 0.0

    @SerializedName("CDF")
    var CDF = 0.0

    @SerializedName("CHF")
    var CHF = 0.0

    @SerializedName("CLP")
    var CLP = 0.0

    @SerializedName("CNY")
    var CNY = 0.0

    @SerializedName("COP")
    var COP = 0.0

    @SerializedName("CUP")
    var CUP = 0.0

    @SerializedName("CVE")
    var CVE = 0.0

    @SerializedName("CZK")
    var CZK = 0.0

    @SerializedName("DJF")
    var DJF = 0.0

    @SerializedName("DKK")
    var DKK = 0.0

    @SerializedName("DOP")
    var DOP = 0.0

    @SerializedName("DZD")
    var DZD = 0.0

    @SerializedName("EGP")
    var EGP = 0.0

    @SerializedName("ERN")
    var ERN = 0.0

    @SerializedName("ETB")
    var ETB = 0.0

    @SerializedName("EUR")
    var EUR = 0.0

    @SerializedName("FJD")
    var FJD = 0.0

    @SerializedName("FKP")
    var FKP = 0.0

    @SerializedName("GBP")
    var GBP = 0.0

    @SerializedName("GEL")
    var GEL = 0.0

    @SerializedName("GHS")
    var GHS = 0.0

    @SerializedName("GIP")
    var GIP = 0.0

    @SerializedName("GMD")
    var GMD = 0.0

    @SerializedName("GNF")
    var GNF = 0.0

    @SerializedName("GTQ")
    var GTQ = 0.0

    @SerializedName("GYD")
    var GYD = 0.0

    @SerializedName("HKD")
    var HKD = 0.0

    @SerializedName("HNL")
    var HNL = 0.0

    @SerializedName("HRK")
    var HRK = 0.0

    @SerializedName("HTG")
    var HTG = 0.0

    @SerializedName("HUF")
    var HUF = 0.0

    @SerializedName("IDR")
    var IDR = 0.0

    @SerializedName("ILS")
    var ILS = 0.0

    @SerializedName("INR")
    var INR = 0.0

    @SerializedName("IQD")
    var IQD = 0.0

    @SerializedName("IRR")
    var IRR = 0.0

    @SerializedName("ISK")
    var ISK = 0.0

    @SerializedName("JMD")
    var JMD = 0.0

    @SerializedName("JOD")
    var JOD = 0.0

    @SerializedName("JPY")
    var JPY = 0.0

    @SerializedName("KES")
    var KES = 0.0

    @SerializedName("KGS")
    var KGS = 0.0

    @SerializedName("KHR")
    var KHR = 0.0

    @SerializedName("KMF")
    var KMF = 0.0

    @SerializedName("KPW")
    var KPW = 0.0

    @SerializedName("KRW")
    var KRW = 0.0

    @SerializedName("KWD")
    var KWD = 0.0

    @SerializedName("KYD")
    var KYD = 0.0

    @SerializedName("KZT")
    var KZT = 0.0

    @SerializedName("LAK")
    var LAK = 0.0

    @SerializedName("LBP")
    var LBP = 0.0

    @SerializedName("LKR")
    var LKR = 0.0

    @SerializedName("LRD")
    var LRD = 0.0

    @SerializedName("LSL")
    var LSL = 0.0

    @SerializedName("LYD")
    var LYD = 0.0

    @SerializedName("MAD")
    var MAD = 0.0

    @SerializedName("MDL")
    var MDL = 0.0

    @SerializedName("MGA")
    var MGA = 0.0

    @SerializedName("MKD")
    var MKD = 0.0

    @SerializedName("MMK")
    var MMK = 0.0

    @SerializedName("MNT")
    var MNT = 0.0

    @SerializedName("MOP")
    var MOP = 0.0

    @SerializedName("MUR")
    var MUR = 0.0

    @SerializedName("MVR")
    var MVR = 0.0

    @SerializedName("MWK")
    var MWK = 0.0

    @SerializedName("MXN")
    var MXN = 0.0

    @SerializedName("MYR")
    var MYR = 0.0

    @SerializedName("MZN")
    var MZN = 0.0

    @SerializedName("NAD")
    var NAD = 0.0

    @SerializedName("NGN")
    var NGN = 0.0

    @SerializedName("NOK")
    var NOK = 0.0

    @SerializedName("NPR")
    var NPR = 0.0

    @SerializedName("NZD")
    var NZD = 0.0

    @SerializedName("OMR")
    var OMR = 0.0

    @SerializedName("PAB")
    var PAB = 0.0

    @SerializedName("PEN")
    var PEN = 0.0

    @SerializedName("PGK")
    var PGK = 0.0

    @SerializedName("PHP")
    var PHP = 0.0

    @SerializedName("PKR")
    var PKR = 0.0

    @SerializedName("PLN")
    var PLN = 0.0

    @SerializedName("PYG")
    var PYG = 0.0

    @SerializedName("QAR")
    var QAR = 0.0

    @SerializedName("RON")
    var RON = 0.0

    @SerializedName("RSD")
    var RSD = 0.0

    @SerializedName("RUB")
    var RUB = 0.0

    @SerializedName("RWF")
    var RWF = 0.0

    @SerializedName("SAR")
    var SAR = 0.0

    @SerializedName("SCR")
    var SCR = 0.0

    @SerializedName("SDG")
    var SDG = 0.0

    @SerializedName("SEK")
    var SEK = 0.0

    @SerializedName("SGD")
    var SGD = 0.0

    @SerializedName("SHP")
    var SHP = 0.0

    @SerializedName("SLL")
    var SLL = 0.0

    @SerializedName("SOS")
    var SOS = 0.0

    @SerializedName("SRD")
    var SRD = 0.0

    @SerializedName("SYP")
    var SYP = 0.0

    @SerializedName("SZL")
    var SZL = 0.0

    @SerializedName("THB")
    var THB = 0.0

    @SerializedName("TJS")
    var TJS = 0.0

    @SerializedName("TMT")
    var TMT = 0.0

    @SerializedName("TND")
    var TND = 0.0

    @SerializedName("TOP")
    var TOP = 0.0

    @SerializedName("TRY")
    var TRY = 0.0

    @SerializedName("TTD")
    var TTD = 0.0

    @SerializedName("TWD")
    var TWD = 0.0

    @SerializedName("TZS")
    var TZS = 0.0

    @SerializedName("UAH")
    var UAH = 0.0

    @SerializedName("UGX")
    var UGX = 0.0

    @SerializedName("USD")
    var USD = 0.0

    @SerializedName("UYU")
    var UYU = 0.0

    @SerializedName("UZS")
    var UZS = 0.0

    @SerializedName("VND")
    var VND = 0.0

    @SerializedName("VUV")
    var VUV = 0.0

    @SerializedName("WST")
    var WST = 0.0

    @SerializedName("XAF")
    var XAF = 0.0

    @SerializedName("XCD")
    var XCD = 0.0

    @SerializedName("XOF")
    var XOF = 0.0

    @SerializedName("XPF")
    var XPF = 0.0

    @SerializedName("YER")
    var YER = 0.0

    @SerializedName("ZAR")
    var ZAR = 0.0

    @SerializedName("ZMW")
    var ZMW = 0.0
}