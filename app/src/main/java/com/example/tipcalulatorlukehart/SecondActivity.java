package com.example.tipcalulatorlukehart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button returnButton;
    private TextView tipBox;
    private TextView totalBox;
    private TextView amountPeopleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        tipBox = findViewById(R.id.Tip);
        totalBox = findViewById(R.id.total);
        amountPeopleView = findViewById(R.id.amount_input_of_people);


        Intent i = getIntent();
        Double billInput = i.getExtras().getDouble("billInput");
        Integer numberOfPeople = i.getExtras().getInt("numberOfPeople");
        Double tip = i.getExtras().getDouble("tip");

        Double tipCalculated = (tip / 100)* billInput;
        tipBox.setText(tipBox.getText() + " " + String.valueOf(tipCalculated));
        Double total = tipCalculated + billInput;

        totalBox.setText(totalBox.getText() + " " + String.valueOf(total));

        amountPeopleView.setText(amountPeopleView.getText() + " " + String.valueOf(total/numberOfPeople));


        returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





    }
}
