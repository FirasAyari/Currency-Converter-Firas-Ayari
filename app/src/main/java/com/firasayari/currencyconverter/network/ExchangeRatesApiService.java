package com.firasayari.currencyconverter.network;


import com.firasayari.currencyconverter.model.ExchangeRatesWrapperObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ExchangeRatesApiService {
    @GET("/latest")
    Call<ExchangeRatesWrapperObject> getExchangeRates(@Query("base") String base, @Query("symbols") String symbols);


}
