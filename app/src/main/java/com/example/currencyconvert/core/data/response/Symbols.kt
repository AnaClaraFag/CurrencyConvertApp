package com.example.currencyconvert.core.data.response

import com.example.currencyconvert.core.data.models.CurrencySymbols

data class Symbols(
    val AED: AED,
    val AFN: AFN,
    val ALL: ALL,
    val AMD: AMD,
    val ANG: ANG,
    val AOA: AOA,
    val ARS: ARS,
    val AUD: AUD,
    val AWG: AWG,
    val AZN: AZN,
    val BAM: BAM,
    val BBD: BBD,
    val BDT: BDT,
    val BGN: BGN,
    val BHD: BHD,
    val BIF: BIF,
    val BMD: BMD,
    val BND: BND,
    val BOB: BOB,
    val BRL: BRL,
    val BSD: BSD,
    val BTC: BTC,
    val BTN: BTN,
    val BWP: BWP,
    val BYN: BYN,
    val BZD: BZD,
    val CAD: CAD,
    val CDF: CDF,
    val CHF: CHF,
    val CLF: CLF,
    val CLP: CLP,
    val CNH: CNH,
    val CNY: CNY,
    val COP: COP,
    val CRC: CRC,
    val CUC: CUC,
    val CUP: CUP,
    val CVE: CVE,
    val CZK: CZK,
    val DJF: DJF,
    val DKK: DKK,
    val DOP: DOP,
    val DZD: DZD,
    val EGP: EGP,
    val ERN: ERN,
    val ETB: ETB,
    val EUR: EUR,
    val FJD: FJD,
    val FKP: FKP,
    val GBP: GBP,
    val GEL: GEL,
    val GGP: GGP,
    val GHS: GHS,
    val GIP: GIP,
    val GMD: GMD,
    val GNF: GNF,
    val GTQ: GTQ,
    val GYD: GYD,
    val HKD: HKD,
    val HNL: HNL,
    val HRK: HRK,
    val HTG: HTG,
    val HUF: HUF,
    val IDR: IDR,
    val ILS: ILS,
    val IMP: IMP,
    val INR: INR,
    val IQD: IQD,
    val IRR: IRR,
    val ISK: ISK,
    val JEP: JEP,
    val JMD: JMD,
    val JOD: JOD,
    val JPY: JPY,
    val KES: KES,
    val KGS: KGS,
    val KHR: KHR,
    val KMF: KMF,
    val KPW: KPW,
    val KRW: KRW,
    val KWD: KWD,
    val KYD: KYD,
    val KZT: KZT,
    val LAK: LAK,
    val LBP: LBP,
    val LKR: LKR,
    val LRD: LRD,
    val LSL: LSL,
    val LYD: LYD,
    val MAD: MAD,
    val MDL: MDL,
    val MGA: MGA,
    val MKD: MKD,
    val MMK: MMK,
    val MNT: MNT,
    val MOP: MOP,
    val MRO: MRO,
    val MRU: MRU,
    val MUR: MUR,
    val MVR: MVR,
    val MWK: MWK,
    val MXN: MXN,
    val MYR: MYR,
    val MZN: MZN,
    val NAD: NAD,
    val NGN: NGN,
    val NIO: NIO,
    val NOK: NOK,
    val NPR: NPR,
    val NZD: NZD,
    val OMR: OMR,
    val PAB: PAB,
    val PEN: PEN,
    val PGK: PGK,
    val PHP: PHP,
    val PKR: PKR,
    val PLN: PLN,
    val PYG: PYG,
    val QAR: QAR,
    val RON: RON,
    val RSD: RSD,
    val RUB: RUB,
    val RWF: RWF,
    val SAR: SAR,
    val SBD: SBD,
    val SCR: SCR,
    val SDG: SDG,
    val SEK: SEK,
    val SGD: SGD,
    val SHP: SHP,
    val SLL: SLL,
    val SOS: SOS,
    val SRD: SRD,
    val SSP: SSP,
    val STD: STD,
    val STN: STN,
    val SVC: SVC,
    val SYP: SYP,
    val SZL: SZL,
    val THB: THB,
    val TJS: TJS,
    val TMT: TMT,
    val TND: TND,
    val TOP: TOP,
    val TRY: TRY,
    val TTD: TTD,
    val TWD: TWD,
    val TZS: TZS,
    val UAH: UAH,
    val UGX: UGX,
    val USD: USD,
    val UYU: UYU,
    val UZS: UZS,
    val VEF: VEF,
    val VES: VES,
    val VND: VND,
    val VUV: VUV,
    val WST: WST,
    val XAF: XAF,
    val XAG: XAG,
    val XAU: XAU,
    val XCD: XCD,
    val XDR: XDR,
    val XOF: XOF,
    val XPD: XPD,
    val XPF: XPF,
    val XPT: XPT,
    val YER: YER,
    val ZAR: ZAR,
    val ZMW: ZMW,
    val ZWL: ZWL
)


fun Symbols.toCurrencyDataList(): ArrayList<CurrencySymbols> {
    val arrayList = ArrayList<CurrencySymbols>()
    arrayList.add(CurrencySymbols(USD.code, USD.description))
    arrayList.add(CurrencySymbols(AED.code, AED.description))
    arrayList.add(CurrencySymbols(AFN.code, AFN.description))
    arrayList.add(CurrencySymbols(AMD.code, AMD.description))
    arrayList.add(CurrencySymbols(ANG.code, ANG.description))
    arrayList.add(CurrencySymbols(AOA.code, AOA.description))
    arrayList.add(CurrencySymbols(ARS.code, ARS.description))
    arrayList.add(CurrencySymbols(AUD.code, AUD.description))
    arrayList.add(CurrencySymbols(AWG.code, AWG.description))
    arrayList.add(CurrencySymbols(BBD.code, BBD.description))
    arrayList.add(CurrencySymbols(BDT.code, BDT.description))
    arrayList.add(CurrencySymbols(BGN.code, BGN.description))
    arrayList.add(CurrencySymbols(BIF.code, BIF.description))
    arrayList.add(CurrencySymbols(BMD.code, BMD.description))
    arrayList.add(CurrencySymbols(BND.code, BND.description))
    arrayList.add(CurrencySymbols(BOB.code, BOB.description))
    arrayList.add(CurrencySymbols(BRL.code, BRL.description))
    arrayList.add(CurrencySymbols(BSD.code, BSD.description))
    arrayList.add(CurrencySymbols(BTC.code, BTC.description))
    arrayList.add(CurrencySymbols(BTN.code, BTN.description))
    arrayList.add(CurrencySymbols(BYN.code, BYN.description))
    arrayList.add(CurrencySymbols(BZD.code, BZD.description))
    arrayList.add(CurrencySymbols(CAD.code, CAD.description))
    arrayList.add(CurrencySymbols(CDF.code, CDF.description))
    arrayList.add(CurrencySymbols(CHF.code, CHF.description))
    arrayList.add(CurrencySymbols(CLF.code, CLF.description))
    arrayList.add(CurrencySymbols(CLP.code, CLP.description))
    arrayList.add(CurrencySymbols(CUP.code, CUP.description))
    arrayList.add(CurrencySymbols(CUC.code, CUC.description))
    arrayList.add(CurrencySymbols(CRC.code, CRC.description))
    arrayList.add(CurrencySymbols(DOP.code, DOP.description))
    arrayList.add(CurrencySymbols(EGP.code, EGP.description))
    arrayList.add(CurrencySymbols(EUR.code, EUR.description))
    arrayList.add(CurrencySymbols(GBP.code, GBP.description))
    arrayList.add(CurrencySymbols(HKD.code, HKD.description))
    arrayList.add(CurrencySymbols(INR.code, INR.description))
    arrayList.add(CurrencySymbols(IRR.code, IRR.description))
    arrayList.add(CurrencySymbols(JMD.code, JMD.description))
    arrayList.add(CurrencySymbols(JPY.code, JPY.description))
    arrayList.add(CurrencySymbols(KPW.code, KPW.description))
    arrayList.add(CurrencySymbols(MAD.code, MAD.description))
    arrayList.add(CurrencySymbols(MXN.code, MXN.description))
    arrayList.add(CurrencySymbols(NZD.code, NZD.description))
    arrayList.add(CurrencySymbols(PYG.code, PYG.description))
    arrayList.add(CurrencySymbols(RUB.code, RUB.description))
    arrayList.add(CurrencySymbols(SAR.code, SAR.description))
    arrayList.add(CurrencySymbols(UYU.code, UYU.description))
    arrayList.add(CurrencySymbols(VES.code, VES.description))
    arrayList.add(CurrencySymbols(ZAR.code, ZAR.description))

    return arrayList
}



