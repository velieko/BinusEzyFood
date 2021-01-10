package com.example.binusezyfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SnackCategoryActivity extends Activity implements View.OnClickListener{
    OrderList ord = OrderList.getinstance();
    int balance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_category);
        Intent i = getIntent();
        balance = i.getIntExtra("balance", 0);
        ArrayAdapter<Snack> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1 , Snack.snacks);
        ListView listsnack = (ListView) findViewById(R.id.list_snacks);
        listsnack.setAdapter(listAdapter);

        //Create the listener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> listsnacks,
                                            View itemView,
                                            int position,
                                            long id) {
                        //Pass the snack the user clicks on to OrderActivity
                        Intent intent = new Intent(SnackCategoryActivity.this, SnackActivity.class);
                        intent.putExtra(SnackActivity.EXTRA_SNACKID, (int) id);
                        intent.putExtra("balance",balance);
                        startActivity(intent);
                    }
                };

        //Assign the listener to the list view
        listsnack.setOnItemClickListener(itemClickListener);

    }

    @Override
    public void onClick(View v) {



        Intent intent = new Intent(SnackCategoryActivity.this, OrderActivity.class);
        intent.putExtra("balance",balance);
        startActivity(intent);
    }
}