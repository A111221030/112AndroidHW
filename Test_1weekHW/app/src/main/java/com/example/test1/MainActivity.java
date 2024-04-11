package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_Click(View view){
        EditText edtName = (EditText) findViewById(R.id.editName);
        EditText txtPassWord =(EditText) findViewById(R.id.TxtPassword);
        TextView txvShow  =(TextView) findViewById(R.id.textShow);

        String name = edtName.getText().toString();
        String password = txtPassWord.getText().toString();
        if(name.equals("A111221030") && password.equals("OO171459") )
        {
            txvShow.setText("密碼輸入正確!\n你的學號是:" + name);
        }
        else
        {
            txvShow.setText("輸入錯誤!\n帳號:A111221030\n密碼:001459" );
        }

    }
}