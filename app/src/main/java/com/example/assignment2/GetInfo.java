package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class GetInfo extends AppCompatActivity {

    ImageView back_button;
    TextView age_input, weight_input, height_input, height_txt;
    RelativeLayout age_minus, age_plus, weight_minus,weight_plus;
    Button calculate_button;
    int age_value = 19;
    float weight_value = 50, height_value, BMI;
    String ht;

    Slider slider_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);

        // back button
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // age
        CheckAge();

        // weight
        CheckWeight();

        //height
        CheckHeight();

        // calculate button
        calculate_button = findViewById(R.id.calculate_button);
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height_txt = findViewById(R.id.height_txt);

                // height is required (cannot be empty)
                if (height_input.getText().toString().equals("0")) {
                    height_txt.setError("Height is required!");
                } else {
                    CalculateBMI();
                }
            }
        });
    }

    // set the age value when user click -/+
    private void CheckAge() {
        age_input = findViewById(R.id.age_input);
        age_minus = findViewById(R.id.age_minus);
        age_plus = findViewById(R.id.age_plus);

        age_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age_value++;
                age_input.setText(String.valueOf(age_value));
            }
        });

        age_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age_value--;
                age_input.setText(String.valueOf(age_value));
            }
        });
    }

    // set the weight value when user click -/+
    private void CheckWeight() {
        weight_input = findViewById(R.id.weight_input);
        weight_minus = findViewById(R.id.weight_minus);
        weight_plus = findViewById(R.id.weight_plus);

        weight_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight_value += 0.5;
                weight_input.setText(String.valueOf(weight_value));
            }
        });

        weight_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight_value -= 0.5;
                weight_input.setText(String.valueOf(weight_value));
            }
        });
    }

    // set the height value when user move the slider
    private void CheckHeight() {
        height_input = findViewById(R.id.height_input);
        slider_height = findViewById(R.id.slider_height);

        slider_height.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                ht = String.format("%.1f", value);
                height_input.setText(ht);
                height_value = (value) / 100;
                slider.setTrackHeight(80);
            }
        });
    }

    // calculate bmi
    private void CalculateBMI() {
        BMI = weight_value / (height_value * height_value);

        // go result after calculate
        Intent intent = new Intent(GetInfo.this, Result.class);
        intent.putExtra("BMI", BMI);
        startActivity(intent);
    }
}