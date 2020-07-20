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
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

       /* Toolbar appbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(appbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);*/
        String[] stores = {"item 1", "item 2", "item 3", "item 4", "item 5"};


        int[] images = new int[]{R.drawable.walmart, R.drawable.tandt, R.drawable.saveon, R.drawable.canadian, R.drawable.shopper};

        List<HashMap<String, String>> itemList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt",  stores[i]);
            hm.put("images", Integer.toString(images[i]));
            itemList.add(hm);

            String[] from = {"images", "txt"};
            int[] to = {R.id.imvwItem, R.id.txtimageItem};

            SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), itemList, R.layout.itemlist_layout, from, to);
            ListView listView = (ListView) findViewById(R.id.itemList);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && position < 5) {
                        startActivity(new Intent(ItemList.this, Cart.class));

                    }
                }
            });
        }
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
