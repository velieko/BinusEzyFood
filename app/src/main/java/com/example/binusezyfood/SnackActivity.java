package com.example.binusezyfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SnackActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_SNACKID = "snackId";
    OrderList ord = OrderList.getinstance();
    Order order = new Order();
    int balance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
        Intent i = getIntent();
        balance = i.getIntExtra("balance", 0);
        //Get the snack from the intent
        int fooId = (Integer)getIntent().getExtras().get(EXTRA_SNACKID);
        Snack snack = Snack.snacks[fooId];

        //Populate the snack name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(snack.getName());
        order.setName(snack.getName());

        //Populate the snack description
        TextView description = (TextView)findViewById(R.id.price);
        description.setText(Integer.toString(snack.getPrice()));
        order.setPrice(snack.getPrice());
        //Populate the snack image
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(snack.getImageResourceId());
        photo.setContentDescription(snack.getName());
        order.setImageResourceId(snack.getImageResourceId());
    }

    @Override
    public void onClick(View x) {
        Intent intent = new Intent(SnackActivity.this, OrderActivity.class);
        intent.putExtra("balance",balance);
        startActivity(intent);
    }

    public void onClickBtn(View y){


        EditText txt = (EditText)findViewById(R.id.quantity);
        int qty= Integer.parseInt(txt.getText().toString());
        order.setQuantity(qty);
        order.setTotal(order.getPrice()*order.getQuantity());
        ord.add(order);
        Intent intent = new Intent(SnackActivity.this, SnackCategoryActivity.class);

        intent.putExtra("balance",balance);
        startActivity(intent);
    }
}


