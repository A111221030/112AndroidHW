package com.example.Menu_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Spinner spinner;
    private TextView txtMenu;
    private String[] side, courses, drink;
    private String selectedMainCourse = "", selectedSide = "", selectedDrink = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        side = getResources().getStringArray(R.array.side);
        courses = getResources().getStringArray(R.array.courses);
        drink = getResources().getStringArray(R.array.drink);


        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        txtMenu = findViewById(R.id.txtMenu);

        ArrayAdapter<CharSequence> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                new String[]{"主餐", "附餐", "飲料"});
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        updateListView(spinner.getSelectedItemPosition());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateListView(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                txtMenu.setText("請選擇菜單種類");
                listView.setAdapter(null);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateSelectedMenu(spinner.getSelectedItemPosition(), position);
                updateTextView();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ToClear) {
            // 如果需要处理“菜單選擇”项的点击事件
            txtMenu.setText("");
            return true;
        } else if (id == R.id.ToSend) {
            // 获取TextView的内容并启动新的Activity
            String menuText = txtMenu.getText().toString();
            Intent intent = new Intent(MainActivity.this, MenuResult.class);
            intent.putExtra("menuText", menuText);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void updateTextView() {
        String menuText = "主餐: " + selectedMainCourse + "\n\n" +
                "附餐: " + selectedSide + "\n\n" +
                "飲料: " + selectedDrink;
        txtMenu.setText(menuText);
    }

    private void updateSelectedMenu(int spinnerPosition, int listViewPosition) {
        if (spinnerPosition == 0) {
            selectedMainCourse = courses[listViewPosition];
        } else if (spinnerPosition == 1) {
            selectedSide = side[listViewPosition];
        } else if (spinnerPosition == 2) {
            selectedDrink = drink[listViewPosition];
        }
    }

    private void updateListView(int position) {
        ArrayAdapter<String> listViewAdapter;

        if (position == 0) {
            listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        } else if (position == 1) {
            listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, side);
        } else if (position == 2) {
            listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, drink);
        } else {
            listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        }

        listView.setAdapter(listViewAdapter);
    }
}