package com.example.hat_rabbit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    public static int money = 0;
    public static int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first_screen);
        TextView showmoney = findViewById(R.id.money);
        showmoney.setText("$"+ money);

    }
    public void start(View view){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }
    public void skinsact(View view){
        Intent intent = new Intent(MainActivity.this, SkinsActivity.class);
        startActivity(intent);
    }
    public void rules(View view){
        Intent intent = new Intent(MainActivity.this, Rules.class);
        startActivity(intent);
    }
    public void exit(View view){

        onDestroy();
    }

}
