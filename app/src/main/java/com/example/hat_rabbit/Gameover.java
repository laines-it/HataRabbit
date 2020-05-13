package com.example.hat_rabbit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.hat_rabbit.MainActivity.money;
import static com.example.hat_rabbit.MainActivity.points;

public class Gameover extends AppCompatActivity {
     public int addmoney;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_gameover);
         addmoney = points / 10;
         money += addmoney;
         TextView textresult2 = findViewById(R.id.textView21);
         textresult2.setText(String.valueOf(points));
         TextView textresultmoney = findViewById(R.id.textView2);
         textresultmoney.setText("$" + money);
     }
     public void restart(View view){
         Intent intent = new Intent(Gameover.this, GameActivity.class);
         startActivity(intent);
     }
     public void skins(View view){
         Intent intent = new Intent(Gameover.this, SkinsActivity.class);
         startActivity(intent);
     }

     public void menu(View view){
         Intent intent = new Intent(Gameover.this, MainActivity.class);
         startActivity(intent);
     }
 }