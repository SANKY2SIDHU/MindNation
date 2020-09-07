package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void numGame(View view) {
        Intent myintent = new Intent(this, gameActivity.class);
        startActivity(myintent);
    }

    public void picGame(View view) {
        Intent myintent = new Intent(this, gameActivity2.class);
        startActivity(myintent);
    }
    public void exGame(View view) {
        finish();
    }

}
