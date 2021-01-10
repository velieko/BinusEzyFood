package com.example.binusezyfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends Activity implements View.OnClickListener{
    OrderList ord = OrderList.getinstance();
    int balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        Intent i = getIntent();
        balance = i.getIntExtra("balance", 0);
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1 , Drink.drinks);
        ListView listDrinks = (ListView) findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);

        //Create the listener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> listDrinks,
                                            View itemView,
                                            int position,
                                            long id) {
                        //Pass the drink the user clicks on to OrderActivity
                        Intent intent = new Intent(DrinkCategoryActivity.this,
                                DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
                        intent.putExtra("balance",balance);
                        startActivity(intent);
                    }
                };

        //Assign the listener to the list view
        listDrinks.setOnItemClickListener(itemClickListener);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(DrinkCategoryActivity.this, OrderActivity.class);
        intent.putExtra("balance",balance);
        startActivity(intent);
    }
}