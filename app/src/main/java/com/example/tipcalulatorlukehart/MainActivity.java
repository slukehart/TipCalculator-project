package com.example.tipcalulatorlukehart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText billInput;
    private EditText numberOfPeople;
    private EditText customTip;

    private TextView Header;
    private Button calculateButton;
    private Button resetButton;


    private RadioGroup radioGroup;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

         billInput= findViewById(R.id.amount_input);
         numberOfPeople = findViewById(R.id.custom_field);
         customTip = findViewById(R.id.custom_tip);

         resetButton = findViewById(R.id.reset_button);
         calculateButton = findViewById(R.id.calculate_button);

         Header = findViewById(R.id.Header);

         calculateButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 boolean isValid = true;
                 double tip = 1;

                 if (radioButton.getText().toString().equals("Custom")) {
                     if (customTip.getText().toString().length() != 0) {
                         if (Double.parseDouble(customTip.getText().toString()) > 0) {
                             tip = Double.parseDouble(customTip.getText().toString());
                         } else {
                             isValid = false;
                             Toast.makeText(getApplicationContext(), "Not tipping is illegal", Toast.LENGTH_LONG).show();
                         }


                     } else {
                         isValid = false;
                         Toast.makeText(getApplicationContext(), "Enter a custom tip?", Toast.LENGTH_LONG).show();

                     }

                 } else {
                     tip = Double.valueOf(radioButton.getText().toString());
                 }
                 if (billInput.getText().toString().length() == 0) {
                     isValid = false;
                     Toast.makeText(getApplicationContext(), "How much is the bill?", Toast.LENGTH_LONG).show();
                 }

                 if (numberOfPeople.getText().toString().length() == 0) {
                     isValid = false;
                     Toast.makeText(getApplicationContext(), "How many people are paying?", Toast.LENGTH_LONG).show();
                 }


                 if (isValid) {
                     Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                     String s = "test";
                     i.putExtra("test", s);

                     i.putExtra("amount_input", Double.valueOf(billInput.getText().toString()));
                     i.putExtra("number_of_people", Integer.valueOf(numberOfPeople.getText().toString()));

                     i.putExtra("tip", tip);

                     startActivity(i);
                 }
             }
         });





         resetButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 billInput.setText("");
                 numberOfPeople.setText("");
                 customTip.setText("");
             }
         });



    }
}