package com.example.currencyconvert.core.data.response


data class Rates(
    val AED: Any,
    val AFN: Any,
    val ALL: Any,
    val AMD: Any,
    val ANG: Any,
    val AOA: Any,
    val ARS: Any,
    val AUD: Any,
    val AWG: Any,
    val AZN: Any,
    val BAM: Any,
    val BBD: Any,
    val BDT: Any,
    val BGN: Any,
    val BHD: Any,
    val BIF: Any,
    val BMD: Any,
    val BND: Any,
    val BOB: Any,
    val BRL: Any,
    val BSD: Any,
    val BTC: Any,
    val BTN: Any,
    val BWP: Any,
    val BYN: Any,
    val BZD: Any,
    val CAD: Any,
    val CDF: Any,
    val CHF: Any,
    val CLF: Any,
    val CLP: Any,
    val CNH: Any,
    val CNY: Any,
    val COP: Any,
    val CRC: Any,
    val CUC: Any,
    val CUP: Any,
    val CVE: Any,
    val CZK: Any,
    val DJF: Any,
    val DKK: Any,
    val DOP: Any,
    val DZD: Any,
    val EGP: Any,
    val ERN: Any,
    val ETB: Any,
    val EUR: Any,
    val FJD: Any,
    val FKP: Any,
    val GBP: Any,
    val GEL: Any,
    val GGP: Any,
    val GHS: Any,
    val GIP: Any,
    val GMD: Any,
    val GNF: Any,
    val GTQ: Any,
    val GYD: Any,
    val HKD: Any,
    val HNL: Any,
    val HRK: Any,
    val HTG: Any,
    val HUF: Any,
    val IDR: Any,
    val ILS: Any,
    val IMP: Any,
    val INR: Any,
    val IQD: Any,
    val IRR: Any,
    val ISK: Any,
    val JEP: Any,
    val JMD: Any,
    val JOD: Any,
    val JPY: Any,
    val KES: Any,
    val KGS: Any,
    val KHR: Any,
    val KMF: Any,
    val KPW: Any,
    val KRW: Any,
    val KWD: Any,
    val KYD: Any,
    val KZT: Any,
    val LAK: Any,
    val LBP: Any,
    val LKR: Any,
    val LRD: Any,
    val LSL: Any,
    val LYD: Any,
    val MAD: Any,
    val MDL: Any,
    val MGA: Any,
    val MKD: Any,
    val MMK: Any,
    val MNT: Any,
    val MOP: Any,
    val MRU: Any,
    val MUR: Any,
    val MVR: Any,
    val MWK: Any,
    val MXN: Any,
    val MYR: Any,
    val MZN: Any,
    val NAD: Any,
    val NGN: Any,
    val NIO: Any,
    val NOK: Any,
    val NPR: Any,
    val NZD: Any,
    val OMR: Any,
    val PAB: Any,
    val PEN: Any,
    val PGK: Any,
    val PHP: Any,
    val PKR: Any,
    val PLN: Any,
    val PYG: Any,
    val QAR: Any,
    val RON: Any,
    val RSD: Any,
    val RUB: Any,
    val RWF: Any,
    val SAR: Any,
    val SBD: Any,
    val SCR: Any,
    val SDG: Any,
    val SEK: Any,
    val SGD: Any,
    val SHP: Any,
    val SLL: Any,
    val SOS: Any,
    val SRD: Any,
    val SSP: Any,
    val STD: Any,
    val STN: Any,
    val SVC: Any,
    val SYP: Any,
    val SZL: Any,
    val THB: Any,
    val TJS: Any,
    val TMT: Any,
    val TND: Any,
    val TOP: Any,
    val TRY: Any,
    val TTD: Any,
    val TWD: Any,
    val TZS: Any,
    val UAH: Any,
    val UGX: Any,
    val USD: Any,
    val UYU: Any,
    val UZS: Any,
    val VES: Any,
    val VND: Any,
    val VUV: Any,
    val WST: Any,
    val XAF: Any,
    val XAG: Any,
    val XAU: Any,
    val XCD: Any,
    val XDR: Any,
    val XOF: Any,
    val XPD: Any,
    val XPF: Any,
    val XPT: Any,
    val YER: Any,
    val ZAR: Any,
    val ZMW: Any,
    val ZWL: Any
)

fun Rates.toCurrencyData(): HashMap<String, Any> {
    val hashMap = HashMap<String, Any>()
    hashMap["AFN"] = AFN
    hashMap["ALL"] = ALL
    hashMap["AMD"] = AMD
    hashMap["ANG"] = ANG
   /* hashMap["AOA"] = AOA
    hashMap["ARS"] = ARS
    hashMap["AUD"] = AUD
    hashMap["AWG"] = AWG
    hashMap["AZN"] = AZN
    hashMap["BAM"] = BAM
    hashMap["BBD"] = BBD
    hashMap["BDT"] = BDT
    hashMap["BGN"] = BGN
    hashMap["BHD"] = BHD
    hashMap["BIF"] = BIF
    hashMap["BMD"] = BMD*/
    hashMap["BND"] = BND
    hashMap["BOB"] = BOB
    hashMap["BRL"] = BRL
    hashMap["BSD"] = BSD
    hashMap["BTC"] = BTC
    /* hashMap["BTN"] = BTN
     hashMap["BWP"] = BWP
     hashMap["BYN"] = BYN
     hashMap["BZD"] = BZD*/
    hashMap["CAD"] = CAD
    /*hashMap["CDF"] = CDF
    hashMap["CHF"] = CHF
    hashMap["CLF"] = CLF
    hashMap["CLP"] = CLP*/
   /* hashMap["CNH"] = CNH
    hashMap["CNY"] = CNY*/
/*    hashMap["COP"] = COP
    hashMap["CRC"] = CRC
    hashMap["CUC"] = CUC
    hashMap["CUP"] = CUP
    hashMap["CVE"] = CVE
    hashMap["CZK"] = CZK
    hashMap["DJF"] = DJF
    hashMap["DKK"] = DKK
    hashMap["DOP"] = DOP
    hashMap["DZD"] = DZD
    hashMap["EGP"] = EGP
    hashMap["ERN"] = ERN*/
    hashMap["ETB"] = ETB
    hashMap["EUR"] = EUR
    /*  hashMap["FJD"] = FJD
      hashMap["FKP"] = FKP
      hashMap["GBP"] = GBP
      hashMap["GEL"] = GEL
      hashMap["GGP"] = GGP
      hashMap["GHS"] = GHS
      hashMap["GIP"] = GIP
      hashMap["GMD"] = GMD
      hashMap["GNF"] = GNF
      hashMap["GTQ"] = GTQ
      hashMap["GYD"] = GYD
      hashMap["HKD"] = HKD
      hashMap["HNL"] = HNL
      hashMap["HRK"] = HRK
      hashMap["HTG"] = HTG
      hashMap["HUF"] = HUF
      hashMap["IDR"] = IDR
      hashMap["ILS"] = ILS
      hashMap["IMP"] = IMP
      hashMap["INR"] = INR
      hashMap["IQD"] = IQD*/
    /* hashMap["IRR"] = IRR
     hashMap["ISK"] = ISK
     hashMap["JEP"] = JEP
     hashMap["JMD"] = JMD
     hashMap["JOD"] = JOD
     hashMap["JPY"] = JPY
     hashMap["KES"] = KES
     hashMap["KGS"] = KGS
     hashMap["KHR"] = KHR
     hashMap["KMF"] = KMF
     hashMap["KPW"] = KPW
     hashMap["KRW"] = KRW
     hashMap["KWD"] = KWD
     hashMap["KYD"] = KYD
     hashMap["KZT"] = KZT
     hashMap["LAK"] = LAK
     hashMap["LBP"] = LBP
     hashMap["LKR"] = LKR
     hashMap["LRD"] = LRD
     hashMap["LSL"] = LSL
     hashMap["LYD"] = LYD
     hashMap["MAD"] = MAD
     hashMap["MDL"] = MDL
     hashMap["MGA"] = MGA
     hashMap["MKD"] = MKD
     hashMap["MMK"] = MMK
     hashMap["MNT"] = MNT
     hashMap["MOP"] = MOP
     hashMap["MRU"] = MRU
     hashMap["MUR"] = MUR
     hashMap["MVR"] = MVR
     hashMap["MWK"] = MWK
     hashMap["MXN"] = MXN
     hashMap["MYR"] = MYR
     hashMap["MZN"] = MZN
     hashMap["NAD"] = NAD
     hashMap["NGN"] = NGN
     hashMap["NIO"] = NIO
     hashMap["NOK"] = NOK
     hashMap["NPR"] = NPR
     hashMap["NZD"] = NZD
     hashMap["OMR"] = OMR
     hashMap["PAB"] = PAB
     hashMap["PEN"] = PEN
     hashMap["PGK"] = PGK
     hashMap["PHP"] = PHP
     hashMap["PKR"] = PKR
     hashMap["PLN"] = PLN
     hashMap["PYG"] = PYG
     hashMap["QAR"] = QAR
     hashMap["RON"] = RON
     hashMap["RSD"] = RSD
     hashMap["RUB"] = RUB
     hashMap["RWF"] = RWF
     hashMap["SAR"] = SAR
     hashMap["SBD"] = SBD
     hashMap["SCR"] = SCR
     hashMap["SDG"] = SDG
     hashMap["SEK"] = SEK
     hashMap["SGD"] = SGD
     hashMap["SHP"] = SHP
     hashMap["SLL"] = SLL
     hashMap["SOS"] = SOS
     hashMap["SRD"] = SRD
     hashMap["SSP"] = SSP
     hashMap["STD"] = STD
     hashMap["STN"] = STN
     hashMap["SVC"] = SVC
     hashMap["SYP"] = SYP
     hashMap["SZL"] = SZL
     hashMap["THB"] = THB
     hashMap["TJS"] = TJS
     hashMap["TMT"] = TMT
     hashMap["TND"] = TND
     hashMap["TOP"] = TOP
     hashMap["TRY"] = TRY
     hashMap["TTD"] = TTD
     hashMap["TWD"] = TWD
     hashMap["TZS"] = TZS
     hashMap["UAH"] = UAH
     hashMap["UGX"] = UGX*/
    hashMap["USD"] = USD
    /*   hashMap["UYU"] = UYU
       hashMap["UZS"] = UZS
       hashMap["VES"] = VES
       hashMap["VND"] = VND
       hashMap["VUV"] = VUV
       hashMap["WST"] = WST
       hashMap["XAF"] = XAF
       hashMap["XAG"] = XAG
       hashMap["XAU"] = XAU
       hashMap["XCD"] = XCD
       hashMap["XDR"] = XDR
       hashMap["XOF"] = XOF
       hashMap["XPD"] = XPD
       hashMap["XPF"] = XPF
       hashMap["XPT"] = XPT
       hashMap["YER"] = YER
       hashMap["ZAR"] = ZAR
       hashMap["ZMW"] = ZMW
       hashMap["ZWL"] = ZWL*/

    return hashMap
}