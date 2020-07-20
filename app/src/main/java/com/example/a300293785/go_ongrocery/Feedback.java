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
import android.widget.Button;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Toolbar appbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(appbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Button btnFeedback=findViewById(R.id.btnFeedback);
        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Feedback.this,feedbackThankyou.class));
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
