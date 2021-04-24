package com.example.pinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class PinActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysettings";

    public static final String APP_PREFERENCES_PIN = "null"; // pin

    SharedPreferences mSettings;



    EditText newpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this::onClick);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        newpin = findViewById(R.id.editTextNumberPassword2);


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:

                String pin = newpin.getText().toString();
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_PIN, pin);
                editor.apply();

                Intent intent = new Intent(PinActivity.this, CheckPinActivity.class);
                startActivity(intent);
                break;
        }
    }
}