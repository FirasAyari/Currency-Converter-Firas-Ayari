package com.firasayari.currencyconverter.network;

import com.firasayari.currencyconverter.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitExchangeRatesClient {
    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
