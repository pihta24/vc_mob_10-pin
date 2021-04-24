package com.example.pinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class GenaralActivity extends AppCompatActivity {

    private static final String MY_SETTINGS = "my_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genaral);

        SharedPreferences sp = getSharedPreferences(MY_SETTINGS,
                Context.MODE_PRIVATE);
        boolean hasVisited = sp.getBoolean("hasVisited", false);
        if (!hasVisited) {
            FragmentManager manager = getSupportFragmentManager();
            DialogFragment dialogFragment = new DialogFragment();
            dialogFragment.show(manager, "myDialog");

            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("hasVisited", true);
            e.commit();
        }
        else {
            Intent intent = new Intent(GenaralActivity.this, EnterActivity.class);
            startActivity(intent);
        }
    }
}