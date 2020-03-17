package com.firasayari.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.firasayari.currencyconverter.database.DatabaseHelper;
import com.firasayari.currencyconverter.model.ExchangeRatesWrapperObject;
import com.firasayari.currencyconverter.network.ExchangeRatesApiService;
import com.firasayari.currencyconverter.network.RetrofitExchangeRatesClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.anoop.awesomeedittext.AwesomeEditText;

public class MainActivity extends AppCompatActivity {
    ExchangeRatesApiService service;
    Button btnConvert;
    AwesomeEditText etEnterAmount;
    Spinner spFromCurrency;
    Spinner spToCurrency;
    TextView tvConvertedAmount;
    private DatabaseHelper db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DatabaseHelper(this);
        service = RetrofitExchangeRatesClient
                .getClient().create(ExchangeRatesApiService.class);

        etEnterAmount = findViewById(R.id.et_enter_amount);
        spFromCurrency = findViewById(R.id.spinner_from_currency);
        spToCurrency = findViewById(R.id.spinner_to_currency);
        tvConvertedAmount = findViewById(R.id.tv_converted_amount_label);
        btnConvert = findViewById(R.id.btn_convert);






        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromCurrency = spFromCurrency.getSelectedItem().toString();
                String toCurrency = spToCurrency.getSelectedItem().toString();

                if(fromCurrency.equals(toCurrency)) {
                    Toast.makeText(MainActivity.this,
                            "No need for conversion.", Toast.LENGTH_SHORT).show();
                    return;
                }

                double amount;
                try {
                    amount = Double.parseDouble(etEnterAmount.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,
                            "Wrong amount input.", Toast.LENGTH_SHORT).show();
                    return;
                }

                convertAmount(fromCurrency, toCurrency, amount);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
                    case R.id.conversion:
                startActivity(new Intent(MainActivity.this, ReadSqliteDataActivity.class));
                break;
        }
        return true;
    }

    private void convertAmount(final String fromCurrency, final String toCurrency, final double amount) {

        service.getExchangeRates(fromCurrency, toCurrency).enqueue(new Callback<ExchangeRatesWrapperObject>() {
            @Override
            public void onResponse(Call<ExchangeRatesWrapperObject> call, Response<ExchangeRatesWrapperObject> response) {
                ExchangeRatesWrapperObject obj = response.body();
                double exchangeRate = obj.getRates().getRateFor(toCurrency);
                double convertedAmount = amount*exchangeRate;
                String msg = amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency;
                tvConvertedAmount.setText(msg);
                db.insertOperation(msg);
            }

            @Override
            public void onFailure(Call<ExchangeRatesWrapperObject> call, Throwable t) {
                Toast.makeText(MainActivity.this, "check your internet connection!", Toast.LENGTH_SHORT).show();
            }
        });
    }








}
