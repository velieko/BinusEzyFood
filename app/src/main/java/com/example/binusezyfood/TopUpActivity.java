package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TopUpActivity extends AppCompatActivity {
    TextView balance;
    int current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        current = i.getIntExtra("balance", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        balance = findViewById(R.id.balanceTxt);
        balance.setText("Your Balance: " + balance);


    }

    public void onClickBtn(View view) {
        int topup = Integer.parseInt(balance.getText().toString());
        if(topup>2000000){
            TextView txtView = (TextView)findViewById(R.id.error);
            //Toggle
            if (txtView.getVisibility() == View.INVISIBLE)
                txtView.setVisibility(View.VISIBLE);
            else
                txtView.setVisibility(View.INVISIBLE);
        }else{
            topup=topup+current;
            Intent i = new Intent(TopUpActivity.this, MenuActivity.class);
            i.putExtra("balance", topup);
            startActivity(i);
        }

    }
}