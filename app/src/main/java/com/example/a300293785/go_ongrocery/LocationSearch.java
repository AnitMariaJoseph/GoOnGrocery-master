package com.example.a300293785.go_ongrocery;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class LocationSearch extends AppCompatActivity {

    String selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_search);

        Toolbar appbar = (Toolbar) findViewById(R.id.app_bar);


        setSupportActionBar(appbar);
        ActionBar loc = getSupportActionBar();
        loc.setDisplayHomeAsUpEnabled(true);

        final Spinner spZipcode =findViewById(R.id.spinner);
        Button btnZip=findViewById(R.id.btnZip);


        spZipcode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                selection = spZipcode.getItemAtPosition(i).toString();

            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

           }
        });

        btnZip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selection.toString().equals("Zip Code")){
                    Toast.makeText(LocationSearch.this, "Please select a valid Zip Code", Toast.LENGTH_SHORT).show();
                } else if(selection.toString().equals("V5H 4N2")) {
                    startActivity(new Intent(LocationSearch.this, StoreList.class));
                } else if (selection.toString().equals("V3R 7C1")) {
                    startActivity(new Intent(LocationSearch.this, StrorList1.class));
                } else if (selection.toString().equals("V3T 2W1")) {
                    startActivity(new Intent(LocationSearch.this, StoreList2.class));
                }
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.settings:
                Intent settings = new Intent (this,Settings.class);
                startActivity(settings);
                //settings
                break;
            case R.id.cart:
                Intent cart = new Intent (this,Cart.class);
                startActivity(cart);
                //cart
                break;
            case R.id.location:
                Intent location = new Intent (this,LocationSearch.class);
                startActivity(location);
                //location
                break;
            case R.id.feedback:
                Intent feedback = new Intent (this,Feedback.class);
                startActivity(feedback);
                //feedback
                break;
            case R.id.orderHistory:
                Intent history = new Intent (this,OrderHistory.class);
                startActivity(history);
                //settings
                break;
            default:
                //unknown error
        }
        return super.onOptionsItemSelected(item);

    }
}
