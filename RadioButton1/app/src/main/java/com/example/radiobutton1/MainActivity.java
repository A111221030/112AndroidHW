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
//1030
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.button2);
        TextView output = findViewById(R.id.lblOutput);

        RadioButton boy = findViewById(R.id.rdbBoy);
        RadioButton girl = findViewById(R.id.rdbGirl);
        RadioGroup type = findViewById(R.id.rgType);

        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("男生\n" + getTicketType());

            }
        });

        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("女生\n" + getTicketType());
            }
        });

        type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                output.setText(getGender() + "\n" + getTicketType());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtTicket = findViewById(R.id.edtText);
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
                    TextView output = findViewById(R.id.lblOutput);
                    output.setText(outputStr);

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("ticket_price", outputStr); // 传递计算的票价
                    intent.putExtra("gender", getGender());
                    intent.putExtra("ticketType", getTicketType());
                    startActivity(intent);
                }catch (NumberFormatException e) {
                    outputStr = "請輸入數值!";
                }
                TextView output = findViewById(R.id.lblOutput);
               output.setText(outputStr);

            }


        });
    }

    private String getGender() {
        RadioButton boy = findViewById(R.id.rdbBoy);
        RadioButton girl = findViewById(R.id.rdbGirl);
        if (boy.isChecked()) {
            return "男生";
        } else if (girl.isChecked()) {
            return "女生";
        }
        return "";
    }

    private String getTicketType() {
        RadioGroup type = findViewById(R.id.rgType);
        if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
            return "全票";
        else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
            return "兒童票";
        else
            return "學生票";
    }
}
