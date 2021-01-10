package com.example.binusezyfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends Activity implements View.OnClickListener {
    OrderList ord = OrderList.getinstance();
    int balance;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView txtBalance;
        txtBalance=findViewById(R.id.balance);

        Intent i = getIntent();
        balance = i.getIntExtra("balance", 0);
        txtBalance.setText("Balance " + balance);
        i.putExtra("balance", balance);
//Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> listView,
                                            View itemView,
                                            int position,
                                            long id) {
                        if (position == 0) {
                            Intent intent = new Intent(MenuActivity.this,
                                    DrinkCategoryActivity.class);
                            intent.putExtra("balance", balance);
                            startActivity(intent);
                        }
                        if (position == 1) {
                            Intent intent = new Intent(MenuActivity.this,
                                    FoodCategoryActivity.class);
                            intent.putExtra("balance", balance);
                            startActivity(intent);
                        }
                        if (position == 2) {
                            Intent intent = new Intent(MenuActivity.this,
                                    SnackCategoryActivity.class);
                            intent.putExtra("balance", balance);
                            startActivity(intent);
                        }
                        if (position == 3) {
                            Intent intent = new Intent(MenuActivity.this,
                                    TopUpActivity.class);
                            intent.putExtra("balance", balance);
                            startActivity(intent);
                        }
                        if (position == 4) {
                            Intent intent = new Intent(MenuActivity.this,
                                    MapsActivity.class);
                            intent.putExtra("balance", balance);
                            startActivity(intent);
                        }
                    }
                };
        //Add the listener to the list view
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onClick(View x) {
        Intent intent = new Intent(MenuActivity.this, OrderActivity.class);
        intent.putExtra("balance", balance);
        startActivity(intent);

    }
}
