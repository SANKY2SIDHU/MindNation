package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class gameActivity extends AppCompatActivity {

    TextView tv_level,tv_number;
    EditText et_number;
    Button b_comfirm;
    Random r;

    String generatedNumber;

    int currentLevel=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tv_level=findViewById(R.id.tv_level);
        tv_number=findViewById(R.id.tv_number);

        et_number=findViewById(R.id.et_number);

        b_comfirm=findViewById(R.id.b_confirm);

        r = new Random();



        tv_level.setText("Level : " + currentLevel); //display current level

        generatedNumber=generateNumber(currentLevel);
        tv_number.setText(generatedNumber);  //display random number according to level

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                et_number.setVisibility(View.VISIBLE);
                b_comfirm.setVisibility(View.VISIBLE);
                tv_number.setVisibility(View.GONE);

                et_number.requestFocus();
            }
        },2000);

        b_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(generatedNumber.equals(et_number.getText().toString())) {

                    et_number.setVisibility(View.GONE); // hide input & button
                    b_comfirm.setVisibility(View.GONE);
                    tv_number.setVisibility(View.VISIBLE);

                    et_number.setText("");

                    currentLevel++; //increase the level
                    tv_level.setText("Level : " + currentLevel); //display current level

                    generatedNumber = generateNumber(currentLevel);
                    tv_number.setText(generatedNumber);  //display random number according to level

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            et_number.setVisibility(View.VISIBLE);
                            b_comfirm.setVisibility(View.VISIBLE);
                            tv_number.setVisibility(View.GONE);

                            et_number.requestFocus();
                        }
                    },2000);
                }else {
                    currentLevel-=1;
                    tv_level.setText("");
                    tv_number.setText("");
                    tv_number.setVisibility(View.VISIBLE);
                    et_number.setVisibility(View.GONE);
                    b_comfirm.setEnabled(false);
                    AlertDialog.Builder alertDiaglogBuilder = new AlertDialog.Builder(gameActivity.this);
                    alertDiaglogBuilder
                            .setMessage("GAME OVER!! The Number Was "+generatedNumber+"\n SCORE : "+currentLevel)
                            .setCancelable(false)
                            .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent =new Intent(getApplicationContext(),gameActivity.class);
                                    startActivity(intent);
                                    finish();

                                }
                            })
                            .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                    AlertDialog alertDialog = alertDiaglogBuilder.create();
                    alertDialog.show();
                }
            }
        });

    }
    private String generateNumber(int digits){
        String output="";
        for(int i=0;i<digits;i++){
            int randomDigit = r.nextInt(10);
            output=output+""+randomDigit;
        }
        return output;


    }
}
