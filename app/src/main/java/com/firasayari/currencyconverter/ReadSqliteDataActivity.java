package com.firasayari.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.firasayari.currencyconverter.R;
import com.firasayari.currencyconverter.database.DatabaseHelper;
import com.firasayari.currencyconverter.database.Operations;
import com.firasayari.currencyconverter.view.OperationsAdapter;

import java.util.List;

public class ReadSqliteDataActivity extends AppCompatActivity {

    private static final String TAG = ReadSqliteDataActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    private OperationsAdapter operationsAdapter;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_sqlite_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarc);
        setSupportActionBar(toolbar);
        setTitle("My conversions");

        //set up recyclerview
        recyclerView = (RecyclerView)findViewById(R.id.list_content);
        setUpRecyclerView();

        //create instance of database and return dictionary data
        databaseHelper = new DatabaseHelper(this);
        List<Operations> operationsModels = databaseHelper.getAllOp();

        //populate list
        populateRecyclerViewFromSqliteDatabase(operationsModels);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conversion, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ichome:
                startActivity(new Intent(ReadSqliteDataActivity.this, MainActivity.class));
                break;
        }
        return true;
    }


    private void setUpRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private void populateRecyclerViewFromSqliteDatabase(List<Operations> operationsModels){
        operationsAdapter = new OperationsAdapter(operationsModels);
        recyclerView.setAdapter(operationsAdapter);
    }
}
