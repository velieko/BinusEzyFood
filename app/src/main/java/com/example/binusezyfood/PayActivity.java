package com.example.binusezyfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PayActivity extends Activity implements View.OnClickListener{
    int balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Intent i = getIntent();
        balance = i.getIntExtra("balance", 0);
        ArrayAdapter<Order> adapt = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, OrderList.getinstance());
        ListView listOrder = (ListView) findViewById(R.id.list_order);
        listOrder.setAdapter(adapt);

        TextView total = (TextView) findViewById(R.id.Total);
        total.setText("Grand Total: " + Integer.toString(OrderList.total()));
    }


    @Override
    public void onClick(View v) {

            balance = balance- OrderList.total();
            OrderList.delete();
            Intent intent = new Intent(PayActivity.this, MenuActivity.class);

            intent.putExtra("balance", balance);
            startActivity(intent);

    }
}