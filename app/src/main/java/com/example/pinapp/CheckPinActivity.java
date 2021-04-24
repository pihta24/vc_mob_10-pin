package com.example.pinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.pinapp.PinActivity.APP_PREFERENCES;
import static com.example.pinapp.PinActivity.APP_PREFERENCES_PIN;

public class CheckPinActivity extends AppCompatActivity {

    SharedPreferences mSettings;
    EditText newpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_pin);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this::onClick);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        newpin = findViewById(R.id.editTextNumberPassword2);


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                if (mSettings.getString(APP_PREFERENCES_PIN, "").equals(newpin.getText().toString())){
                    Intent intent = new Intent(CheckPinActivity.this, MainActivity.class);
                    startActivity(intent); }
                else{
                    Toast.makeText(CheckPinActivity.this, "PIN не совпадают", Toast.LENGTH_SHORT).show();
                }
        }
    }
}