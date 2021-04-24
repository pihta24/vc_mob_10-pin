package com.example.pinapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.pinapp.PinActivity.APP_PREFERENCES;
import static com.example.pinapp.PinActivity.APP_PREFERENCES_PIN;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this::onClick);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                    Intent intent = new Intent(MainActivity.this, PinActivity.class);
                    startActivity(intent);
        }
    }
}
