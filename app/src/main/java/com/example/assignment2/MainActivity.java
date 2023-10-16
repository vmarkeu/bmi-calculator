package com.example.assignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button get_started_button;
    ImageView info_button;
    AlertDialog dialog;
    AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get started
        get_started_button = findViewById(R.id.get_started_button);
        get_started_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GetInfo.class);
                startActivity(intent);
            }
        });

        // info
        info_button = findViewById(R.id.info_button);
        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupInfo();
            }
        });
    }

    // popup info
    public void popupInfo() {
        // make alert dialog
        dialogBuilder = new AlertDialog.Builder(this, R.style.PopupInfoTheme);
        final View popupInfo = getLayoutInflater().inflate(R.layout.popup_info, null);
        dialogBuilder.setView(popupInfo);
        dialog = dialogBuilder.create();
        dialog.show();
    }
}