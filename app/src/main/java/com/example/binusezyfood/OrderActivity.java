package com.example.binusezyfood;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



public class OrderActivity extends Activity implements View.OnClickListener {

    int balance;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView txtBalance;
        txtBalance=findViewById(R.id.balance);
        Intent i = getIntent();
        balance = i.getIntExtra("balance", 0);
        txtBalance.setText("Balance " + balance);

        ArrayAdapter<Order> adapt = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, OrderList.getinstance());
        ListView listOrder = (ListView) findViewById(R.id.list_order);
        listOrder.setAdapter(adapt);

        TextView total = (TextView) findViewById(R.id.Total);
        total.setText("Grand Total: " + Integer.toString(OrderList.total()));
    }

    @Override
    public void onClick(View v) {
        if (balance < OrderList.total()) {
            TextView txtView = (TextView) findViewById(R.id.notenough);
            //Toggle
            if (txtView.getVisibility() == View.INVISIBLE)
                txtView.setVisibility(View.VISIBLE);
            else
                txtView.setVisibility(View.INVISIBLE);
        } else {
            Intent intent = new Intent(OrderActivity.this, PayActivity.class);
            intent.putExtra("balance",balance);
            startActivity(intent);

        }
    }
}