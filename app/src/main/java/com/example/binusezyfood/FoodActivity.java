package com.example.binusezyfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_FOODID = "foodId";
    OrderList ord = OrderList.getinstance();
    Order order = new Order();
    int balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Intent i = getIntent();
        balance = i.getIntExtra("balance", 0);

        //Get the drink from the intent
        int foodId = (Integer)getIntent().getExtras().get(EXTRA_FOODID);
        Food food = Food.foods[foodId];

        //Populate the drink name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(food.getName());
        order.setName(food.getName());

        //Populate the drink description
        TextView description = (TextView)findViewById(R.id.price);
        description.setText(Integer.toString(food.getPrice()));
        order.setPrice(food.getPrice());
        //Populate the drink image
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(food.getImageResourceId());
        photo.setContentDescription(food.getName());
        order.setImageResourceId(food.getImageResourceId());
    }

    @Override
    public void onClick(View x) {
        Intent intent = new Intent(FoodActivity.this, OrderActivity.class);

        intent.putExtra("balance",balance);
        startActivity(intent);
    }

    public void onClickBtn(View y){
        EditText txt = (EditText)findViewById(R.id.quantity);
        int qty= Integer.parseInt(txt.getText().toString());
        order.setQuantity(qty);
        order.setTotal(order.getPrice()*order.getQuantity());
        ord.add(order);
        Intent intent = new Intent(FoodActivity.this, FoodCategoryActivity.class);

        intent.putExtra("balance",balance);
        startActivity(intent);
    }
}


