package com.example.radiobutton1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        TextView output = findViewById(R.id.lblOutput);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputStr = "";
                RadioButton boy = findViewById(R.id.rdbBoy);
                RadioButton girl = findViewById(R.id.rdbGirl);
                if (boy.isChecked())
                    outputStr += "男生\n";
                else if (girl.isChecked())
                    outputStr += "女生\n";

                RadioGroup type = findViewById(R.id.rgType);
                if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
                    outputStr += "全票\n";
                else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
                    outputStr += "兒童票\n";
                else
                    outputStr += "學生票\n";
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(outputStr);



                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("user_choice", outputStr); // 传递用户的选择
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtTicket = findViewById(R.id.edtText);
                RadioGroup type = findViewById(R.id.rgType);
                String ticket = edtTicket.getText().toString();
                String outputStr = "";

                // 检查输入是否为数字
                try {
                    int ticketValue = Integer.parseInt(ticket);
                    int outTicket = 0;

                    if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
                        outTicket = ticketValue * 500;
                    else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
                        outTicket = ticketValue * 250;
                    else
                        outTicket = ticketValue * 400;

                    outputStr += ticket + "張票\n" + outTicket + "元";

                }
                catch (NumberFormatException e) {
                    outputStr = "請輸入數值!";
                }
                TextView output = findViewById(R.id.lblOutput);
                output.setText(outputStr);

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("ticket_price", outputStr); // 传递计算的票价
                startActivity(intent);



            }
        });
    }
}
