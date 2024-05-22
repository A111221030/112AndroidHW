package com.example.Menu_hw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuResult extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_result);

        // 获取传递过来的数据
        String menuText = getIntent().getStringExtra("menuText");

        // 显示数据
        TextView resultTextView = findViewById(R.id.TxtResult);
        resultTextView.setText(menuText);
    }
}
