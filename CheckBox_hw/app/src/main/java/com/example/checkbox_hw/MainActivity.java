package com.example.checkbox_hw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox burger, Frenchfry, Softdrink, Coffee;
    private ImageView image1, image2, image3, image4;
    private TextView output;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        burger = findViewById(R.id.chk1);
        Frenchfry = findViewById(R.id.chk2);
        Softdrink = findViewById(R.id.chk3);
        Coffee = findViewById(R.id.chk4);
        output = findViewById(R.id.showOrder);

        burger.setOnCheckedChangeListener(this);
        Frenchfry.setOnCheckedChangeListener(this);
        Softdrink.setOnCheckedChangeListener(this);
        Coffee.setOnCheckedChangeListener(this);

        image1 = findViewById(R.id.output1);
        image2 = findViewById(R.id.output2);
        image3 = findViewById(R.id.output3);
        image4 = findViewById(R.id.output4);

        hideAllImages();

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == burger) {
            if (isChecked) {
                image1.setVisibility(View.VISIBLE);
            } else {
                image1.setVisibility(View.GONE);
            }
        } else if (buttonView == Frenchfry) {
            if (isChecked) {
                image2.setVisibility(View.VISIBLE);
            } else {
                image2.setVisibility(View.GONE);
            }
        } else if (buttonView == Softdrink) {
            if (isChecked) {
                image3.setVisibility(View.VISIBLE);
            } else {
                image3.setVisibility(View.GONE);
            }
        } else if (buttonView == Coffee) {
            if (isChecked) {
                image4.setVisibility(View.VISIBLE);
            } else {
                image4.setVisibility(View.GONE);
            }
        }

        updateOutputText();

    }
    private void updateOutputText() {
        StringBuilder str = new StringBuilder();
        if (burger.isChecked()) {
            str.append(burger.getText()).append("\n");
        }
        if (Frenchfry.isChecked()) {
            str.append(Frenchfry.getText()).append("\n");
        }
        if (Softdrink.isChecked()) {
            str.append(Softdrink.getText()).append("\n");
        }
        if (Coffee.isChecked()) {
            str.append(Coffee.getText()).append("\n");
        }
        output.setText(str.toString());
    }

    private void hideAllImages() {
        image1.setVisibility(View.GONE);
        image2.setVisibility(View.GONE);
        image3.setVisibility(View.GONE);
        image4.setVisibility(View.GONE);
    }
}