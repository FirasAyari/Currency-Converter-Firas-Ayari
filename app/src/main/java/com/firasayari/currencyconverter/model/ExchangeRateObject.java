package com.firasayari.currencyconverter.model;

import com.google.gson.annotations.SerializedName;

public class ExchangeRateObject {

    @SerializedName("CAD")
    private double CAD;
    @SerializedName("HKD")
    private double HKD;
    @SerializedName("ISK")
    private double ISK;
    @SerializedName("PHP")
    private double PHP;
    @SerializedName("DKK")
    private double DKK;
    @SerializedName("HUF")
    private double HUF;
    @SerializedName("CZK")
    private double CZK;
    @SerializedName("AUD")
    private double AUD;
    @SerializedName("RON")
    private double RON;
    @SerializedName("SEK")
    private double SEK;
    @SerializedName("IDR")
    private double IDR;
    @SerializedName("INR")
    private double INR;
    @SerializedName("BRL")
    private double BRL;
    @SerializedName("RUB")
    private double RUB;
    @SerializedName("HRK")
    private double HRK;
    @SerializedName("JPY")
    private double JPY;
    @SerializedName("THB")
    private double THB;
    @SerializedName("CHF")
    private double CHF;
    @SerializedName("SGD")
    private double SGD;
    @SerializedName("PLN")
    private double PLN;
    @SerializedName("BGN")
    private double BGN;
    @SerializedName("TRY")
    private double TRY;
    @SerializedName("CNY")
    private double CNY;
    @SerializedName("NOK")
    private double NOK;
    @SerializedName("NZD")
    private double NZD;
    @SerializedName("ZAR")
    private double ZAR;
    @SerializedName("USD")
    private double USD;
    @SerializedName("MXN")
    private double MXN;
    @SerializedName("ILS")
    private double ILS;
    @SerializedName("GBP")
    private double GBP;
    @SerializedName("KRW")
    private double KRW;
    @SerializedName("MYR")
    private double MYR;
    @SerializedName("EUR")
    private double EUR;

    public double getRateFor(String currency) {
        if(currency.equals("EUR")) return EUR;
        if(currency.equals("MYR")) return MYR;
        if(currency.equals("KRW")) return KRW;
        if(currency.equals("GBP")) return GBP;
        if(currency.equals("ILS")) return ILS;
        if(currency.equals("MXN")) return MXN;
        if(currency.equals("USD")) return USD;
        if(currency.equals("ZAR")) return ZAR;
        if(currency.equals("NZD")) return NZD;
        if(currency.equals("NOK")) return NOK;
        if(currency.equals("CNY")) return CNY;
        if(currency.equals("TRY")) return TRY;
        if(currency.equals("BGN")) return BGN;
        if(currency.equals("PLN")) return PLN;
        if(currency.equals("SGD")) return SGD;
        if(currency.equals("CHF")) return CHF;
        if(currency.equals("THB")) return THB;
        if(currency.equals("JPY")) return JPY;
        if(currency.equals("HRK")) return HRK;
        if(currency.equals("RUB")) return RUB;
        if(currency.equals("BRL")) return BRL;
        if(currency.equals("INR")) return INR;
        if(currency.equals("IDR")) return IDR;
        if(currency.equals("SEK")) return SEK;
        if(currency.equals("RON")) return RON;
        if(currency.equals("AUD")) return AUD;
        if(currency.equals("CZK")) return CZK;
        if(currency.equals("HUF")) return HUF;
        if(currency.equals("DKK")) return DKK;
        if(currency.equals("PHP")) return PHP;
        if(currency.equals("ISK")) return ISK;
        if(currency.equals("HKD")) return HKD;
        if(currency.equals("CAD")) return CAD;
        return 1;
    }
}
