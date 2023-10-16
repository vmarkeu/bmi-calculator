package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    float BMI;
    String bmi;
    TextView your_bmi, your_category, your_condition;
    String category, condition;
    ImageView home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        // bmi round off to 2 decimal places
        bmi = String.format("%.2f", (intent.getFloatExtra("BMI", 0)));
        BMI = Float.parseFloat(bmi);

        // bmi
        your_bmi = findViewById(R.id.your_bmi);
        your_bmi.setText(String.valueOf(BMI));

        // condition
        your_category = findViewById(R.id.your_category);
        Category();

        // condition
        your_condition = findViewById(R.id.your_condition);
        Condition();

        // back button
        home_button = findViewById(R.id.home_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // set category
    public void Category(){
        if (BMI < 16) {
            category = "Severe Thinness";
        } else if (BMI >= 16 && BMI <= 17) {
            category = "Moderate Thinness";
        } else if (BMI > 17 && BMI <= 18.5) {
            category = "Mild Thinness";
        } else if (BMI > 18.5 && BMI <= 25) {
            category = "Normal";
        } else if (BMI > 25 && BMI <= 30) {
            category = "Overweight";
        } else if (BMI > 30 && BMI <= 35) {
            category = "Obese Class I";
        } else if (BMI > 35 && BMI <= 40) {
            category = "Obese Class II";
        } else {
            category ="Obese Class III";
        }

        your_category.setText(category);

        // set colour for each category text
        if (your_category.getText().toString().equals("Severe Thinness") || your_category.getText().toString().equals("Moderate Thinness") || your_category.getText().toString().equals("Mild Thinness")) {
            your_category.setTextColor(0xFF01BAEF);
        } else if (your_category.getText().toString().equals("Normal")) {
            your_category.setTextColor(0xFF20BF55);
        } else if (your_category.getText().toString().equals("Overweight")) {
            your_category.setTextColor(0xFFEEC643);
        } else if (your_category.getText().toString().equals("Obese Class I") || your_category.getText().toString().equals("Obese Class II")) {
            your_category.setTextColor(0xFFFF6700);
        } else {
            your_category.setTextColor(0xFFFF0000);
        }
    }

    // set condition
    public void Condition(){
        if (BMI < 16) {
            condition = "Very Severely Underweight";
        } else if (BMI >= 16 && BMI <= 17) {
            condition = "Severely underweight";
        } else if (BMI > 17 && BMI <= 18.5) {
            condition = "Underweight";
        } else if (BMI > 18.5 && BMI <= 25) {
            condition = "Normal (Healthy Weight)";
        } else if (BMI > 25 && BMI <= 30) {
            condition = "Overweight";
        } else if (BMI > 30 && BMI <= 35) {
            condition = "Moderately Obese";
        } else if (BMI > 35 && BMI <= 40) {
            condition = "Severely Obese";
        } else {
            condition ="Very Severely Obese";
        }

        your_condition.setText(condition);
    }
}