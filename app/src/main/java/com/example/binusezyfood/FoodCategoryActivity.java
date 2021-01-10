package com.example.binusezyfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodCategoryActivity extends Activity implements View.OnClickListener{
    OrderList ord = OrderList.getinstance();
    int balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);

        Intent i = getIntent();
        balance = i.getIntExtra("balance", 0);
        ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1 , Food.foods);
        ListView listFood = (ListView) findViewById(R.id.list_foods);
        listFood.setAdapter(listAdapter);

        //Create the listener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> listFoods,
                                            View itemView,
                                            int position,
                                            long id) {
                        //Pass the food the user clicks on to OrderActivity
                        Intent intent = new Intent(FoodCategoryActivity.this,
                               FoodActivity.class);
                        intent.putExtra(FoodActivity.EXTRA_FOODID, (int) id);
                        intent.putExtra("balance",balance);
                        startActivity(intent);
                    }
                };

        //Assign the listener to the list view
        listFood.setOnItemClickListener(itemClickListener);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(FoodCategoryActivity.this, OrderActivity.class);
        intent.putExtra("balance",balance);
        startActivity(intent);
    }
}