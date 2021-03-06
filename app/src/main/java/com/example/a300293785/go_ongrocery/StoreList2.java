package com.example.a300293785.go_ongrocery;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoreList2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list2);

        /*Toolbar appbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(appbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);*/

        String[] stores = {"Wal-Mart", "T&T Market", "Save-On-Foods", "Real Canadian Superstore", "Shoppers"};


        int[] images = new int[]{R.drawable.walmart, R.drawable.tandt, R.drawable.saveon, R.drawable.canadian, R.drawable.shopper};

        List<HashMap<String, String>> storeList2 = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt", stores[i]);
            hm.put("images", Integer.toString(images[i]));
            storeList2.add(hm);

            String[] from = {"images", "txt"};
            int[] to = {R.id.imvwstore2, R.id.txtimage2};

            SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), storeList2, R.layout.storelist2_layout, from, to);
            ListView listView = (ListView) findViewById(R.id.storeList2);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0 && position < 5) {
                        startActivity(new Intent(StoreList2.this, Department.class));

                    }
                }
            });
        }
    }
}
