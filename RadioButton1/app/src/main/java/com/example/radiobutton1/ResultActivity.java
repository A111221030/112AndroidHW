package com.example.radiobutton1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txvShow = findViewById(R.id.txvShow);
        Intent intent = getIntent();

        // 获取MainActivity传递过来的用户选择和票价
        String userChoice = intent.getStringExtra("user_choice");
        String ticketPrice = intent.getStringExtra("ticket_price");

        // 将用户选择和票价显示在TextView中
        txvShow.setText("選擇:\n " + userChoice + "\n票價:\n " + ticketPrice);
    }
}
