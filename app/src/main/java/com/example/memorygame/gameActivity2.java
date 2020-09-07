package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class gameActivity2 extends AppCompatActivity {

    TextView tvp1,tvp2;
    ImageView iv_00,iv_01,iv_02,iv_03,iv_10,iv_11,iv_12,iv_13,iv_20,iv_21,iv_22,iv_23;
    Integer[] cardArray = {11,12,13,14,15,16,21,22,23,24,25,26};
    int im11,im12,im13,im14,im15,im16,im21,im22,im23,im24,im25,im26;

    int firstCard,secondCard;
    int clickedFirst,clickedSecond;
    int cardNumber=1, turn =1;
    int playerPoints=0,cpuPoints=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        tvp1 = (TextView)findViewById(R.id.tv_p1);
        tvp2 = (TextView)findViewById(R.id.tv_p2);

        iv_00 = (ImageView)findViewById(R.id.iv_00);
        iv_01 = (ImageView)findViewById(R.id.iv_01);
        iv_02 = (ImageView)findViewById(R.id.iv_02);
        iv_03 = (ImageView)findViewById(R.id.iv_03);
        iv_10 = (ImageView)findViewById(R.id.iv_10);
        iv_11 = (ImageView)findViewById(R.id.iv_11);
        iv_12 = (ImageView)findViewById(R.id.iv_12);
        iv_13 = (ImageView)findViewById(R.id.iv_13);
        iv_20 = (ImageView)findViewById(R.id.iv_20);
        iv_21 = (ImageView)findViewById(R.id.iv_21);
        iv_22 = (ImageView)findViewById(R.id.iv_22);
        iv_23 = (ImageView)findViewById(R.id.iv_23);

        iv_00.setTag("0");
        iv_01.setTag("1");
        iv_02.setTag("2");
        iv_03.setTag("3");
        iv_10.setTag("4");
        iv_11.setTag("5");
        iv_12.setTag("6");
        iv_13.setTag("7");
        iv_20.setTag("8");
        iv_21.setTag("9");
        iv_22.setTag("10");
        iv_23.setTag("11");

        frontOfCardResources();

        Collections.shuffle(Arrays.asList(cardArray));

        tvp2.setTextColor(Color.GRAY);

        iv_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_00,theCard);
            }
        });
        iv_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_01,theCard);
            }
        });
        iv_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_02,theCard);
            }
        });iv_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_03,theCard);
            }
        });
        iv_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_10,theCard);
            }
        });
        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_11,theCard);
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_12,theCard);
            }
        });iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_13,theCard);
            }
        });
        iv_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_20,theCard);
            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_21,theCard);
            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_22,theCard);
            }
        });iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(iv_23,theCard);
            }
        });



    }

    private void doStuff(ImageView iv,int card) {

        if (cardArray[card] == 11)
            iv.setImageResource(im11);
        else if (cardArray[card] == 12)
            iv.setImageResource(im12);
        else if (cardArray[card] == 13)
            iv.setImageResource(im13);
        else if (cardArray[card] == 14)
            iv.setImageResource(im14);
        else if (cardArray[card] == 15)
            iv.setImageResource(im15);
        else if (cardArray[card] == 16)
            iv.setImageResource(im16);
        else if (cardArray[card] == 21)
            iv.setImageResource(im21);
        else if (cardArray[card] == 22)
            iv.setImageResource(im22);
        else if (cardArray[card] == 23)
            iv.setImageResource(im23);
        else if (cardArray[card] == 24)
            iv.setImageResource(im24);
        else if (cardArray[card] == 25)
            iv.setImageResource(im25);
        else if (cardArray[card] == 26)
            iv.setImageResource(im26);

        if (cardNumber == 1) {
            firstCard = cardArray[card];
            if (firstCard > 20)
                firstCard = firstCard - 10;
            cardNumber = 2;
            clickedFirst = card;
            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardArray[card];
            if (secondCard > 20)
                secondCard = secondCard - 10;
            cardNumber = 1;
            clickedSecond = card;
            iv_00.setEnabled(false);
            iv_01.setEnabled(false);
            iv_02.setEnabled(false);
            iv_03.setEnabled(false);
            iv_10.setEnabled(false);
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_20.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    calculate();
                }
            }, 1000);

        }

    }

    private void calculate(){
        if(firstCard==secondCard){
            if(clickedFirst==0)
                iv_00.setVisibility(View.INVISIBLE);
            else if(clickedFirst==1)
                iv_01.setVisibility(View.INVISIBLE);
            else if(clickedFirst==2)
                iv_02.setVisibility(View.INVISIBLE);
            else if(clickedFirst==3)
                iv_03.setVisibility(View.INVISIBLE);
            else if(clickedFirst==4)
                iv_10.setVisibility(View.INVISIBLE);
            else if(clickedFirst==5)
                iv_11.setVisibility(View.INVISIBLE);
            else if(clickedFirst==6)
                iv_12.setVisibility(View.INVISIBLE);
            else if(clickedFirst==7)
                iv_13.setVisibility(View.INVISIBLE);
            else if(clickedFirst==8)
                iv_20.setVisibility(View.INVISIBLE);
            else if(clickedFirst==9)
                iv_21.setVisibility(View.INVISIBLE);
            else if(clickedFirst==10)
                iv_22.setVisibility(View.INVISIBLE);
            else if(clickedFirst==11)
                iv_23.setVisibility(View.INVISIBLE);

            if(clickedSecond==0)
                iv_00.setVisibility(View.INVISIBLE);
            else if(clickedSecond==1)
                iv_01.setVisibility(View.INVISIBLE);
            else if(clickedSecond==2)
                iv_02.setVisibility(View.INVISIBLE);
            else if(clickedSecond==3)
                iv_03.setVisibility(View.INVISIBLE);
            else if(clickedSecond==4)
                iv_10.setVisibility(View.INVISIBLE);
            else if(clickedSecond==5)
                iv_11.setVisibility(View.INVISIBLE);
            else if(clickedSecond==6)
                iv_12.setVisibility(View.INVISIBLE);
            else if(clickedSecond==7)
                iv_13.setVisibility(View.INVISIBLE);
            else if(clickedSecond==8)
                iv_20.setVisibility(View.INVISIBLE);
            else if(clickedSecond==9)
                iv_21.setVisibility(View.INVISIBLE);
            else if(clickedSecond==10)
                iv_22.setVisibility(View.INVISIBLE);
            else if(clickedSecond==11)
                iv_23.setVisibility(View.INVISIBLE);

            if(turn == 1){
                playerPoints++;
                tvp1.setText("P1 : "+playerPoints);
            }
            else if(turn ==2){
                cpuPoints++;
                tvp2.setText(("P2 : "+cpuPoints));
            }
        }
        else {
            iv_00.setImageResource(R.drawable.back);
            iv_01.setImageResource(R.drawable.back);
            iv_02.setImageResource(R.drawable.back);
            iv_03.setImageResource(R.drawable.back);
            iv_10.setImageResource(R.drawable.back);
            iv_11.setImageResource(R.drawable.back);
            iv_12.setImageResource(R.drawable.back);
            iv_13.setImageResource(R.drawable.back);
            iv_20.setImageResource(R.drawable.back);
            iv_21.setImageResource(R.drawable.back);
            iv_22.setImageResource(R.drawable.back);
            iv_23.setImageResource(R.drawable.back);

            if(turn == 1){
                turn = 2;
                tvp1.setTextColor(Color.GRAY);
                tvp2.setTextColor(Color.BLACK);
            }
            else if(turn == 2){
                turn = 1;
                tvp2.setTextColor(Color.GRAY);
                tvp1.setTextColor(Color.BLACK);
            }
        }

        iv_00.setEnabled(true);
        iv_01.setEnabled(true);
        iv_02.setEnabled(true);
        iv_03.setEnabled(true);
        iv_10.setEnabled(true);
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_20.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);

        checkEnd();
    }

    private void checkEnd(){
        if(iv_00.getVisibility()==View.INVISIBLE &&
                iv_01.getVisibility()==View.INVISIBLE &&
                iv_02.getVisibility()==View.INVISIBLE &&
                iv_03.getVisibility()==View.INVISIBLE &&
                iv_10.getVisibility()==View.INVISIBLE &&
                iv_11.getVisibility()==View.INVISIBLE &&
                iv_12.getVisibility()==View.INVISIBLE &&
                iv_13.getVisibility()==View.INVISIBLE &&
                iv_20.getVisibility()==View.INVISIBLE &&
                iv_21.getVisibility()==View.INVISIBLE &&
                iv_22.getVisibility()==View.INVISIBLE &&
                iv_23.getVisibility()==View.INVISIBLE ){

            AlertDialog.Builder alertDiaglogBuilder = new AlertDialog.Builder(gameActivity2.this);
            alertDiaglogBuilder
                    .setMessage("GAME OVER !!! \n P1 : "+playerPoints+"\n P2 : "+cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent =new Intent(getApplicationContext(),gameActivity2.class);
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

    private void frontOfCardResources(){
        im11=R.drawable.iv11;
        im12=R.drawable.iv12;
        im13=R.drawable.iv13;
        im14=R.drawable.iv14;
        im15=R.drawable.iv15;
        im16=R.drawable.iv16;
        im21=R.drawable.iv21;
        im22=R.drawable.iv22;
        im23=R.drawable.iv23;
        im24=R.drawable.iv24;
        im25=R.drawable.iv25;
        im26=R.drawable.iv26;
    }
}
