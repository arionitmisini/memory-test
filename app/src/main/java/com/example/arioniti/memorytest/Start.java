package com.example.arioniti.memorytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Start extends Activity {
    Button button;
    RadioButton easy,medium,hard;
    RadioGroup radioGroup;
    String selectedRadioButtonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        showSelectedRadioButton();

        easy = (RadioButton)findViewById(R.id.easy);
        medium = (RadioButton)findViewById(R.id.medium);
        hard = (RadioButton)findViewById(R.id.hard);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedRadioButtonText.toString().equals("Easy")){
                    Intent i = new Intent(Start.this,MainActivity.class);
                    startActivity(i);
                }
                else if(selectedRadioButtonText.toString().equals("Medium")){
                    Intent i = new Intent(Start.this,SecondActivity.class);
                    startActivity(i);
                }
                else if(selectedRadioButtonText.toString().equals("Hard")){
                    Intent i = new Intent(Start.this,ThirdActivity.class);
                    startActivity(i);
                }
            }
        });
    }
    public void showSelectedRadioButton(){
        radioGroup = (RadioGroup) findViewById(R.id.radioGrup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                selectedRadioButtonText = rb.getText().toString();
            }
        });
    }
}
