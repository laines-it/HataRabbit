package com.example.hat_rabbit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }
    public void menu(View view){
        Intent intent = new Intent(Rules.this,MainActivity.class);
        startActivity(intent);
    }
}
