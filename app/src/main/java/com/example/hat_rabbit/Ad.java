package com.example.hat_rabbit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import static com.example.hat_rabbit.MainActivity.money;

public class Ad extends AppCompatActivity{
    int reward = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
    }

    public void ad1(View view){
        reward = 10;
        VideoView videoView = findViewById(R.id.videoView);
        Uri myVideoUri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ad1);
        videoView.setVideoURI(myVideoUri);
        videoView.bringToFront();
        videoView.setVisibility(View.VISIBLE);
        clearall();
        videoView.start();
        money += reward;
    }

    public void ad2(View view){
        reward = 20;
        VideoView videoView = findViewById(R.id.videoView);
        Uri myVideoUri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ad2);
        videoView.setVideoURI(myVideoUri);
        videoView.bringToFront();
        videoView.setVisibility(View.VISIBLE);
        clearall();
        videoView.start();
        money += reward;
    }
    public void clearall(){
        TextView textView = findViewById(R.id.textView22);
        TextView textView1 = findViewById(R.id.textView23);
        TextView textView2 = findViewById(R.id.textView24);
        TextView textView3 = findViewById(R.id.textView25);
        TextView textView4 = findViewById(R.id.textView30);
        TextView textView5 = findViewById(R.id.textView31);
        TextView textView6 = findViewById(R.id.textView32);
        TextView textView7 = findViewById(R.id.textView33);
        Button button3 = findViewById(R.id.button17);
        EditText editText = findViewById(R.id.promo);
        textView.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
        Button button = findViewById(R.id.ad2);
        button.setVisibility(View.INVISIBLE);
        Button button1 = findViewById(R.id.ad1);
        button1.setVisibility(View.INVISIBLE);
    }
    public void enterpromo(View view) {
        Context c = getApplicationContext();
        EditText promo = findViewById(R.id.promo);
        if (promo.getText().toString().equals("1")) {
            Toast.makeText(c,
                    c.getResources().getString(R.string.this_promo_gives_you_60),
                    Toast.LENGTH_SHORT).show();
            money += 60;
        } else {
            Toast.makeText(c,
                    c.getResources().getString(R.string.there_is_not_this_promocode),
                    Toast.LENGTH_SHORT).show();
        }
    }


    public void back(View view){
        Intent intent = new Intent(Ad.this, SkinsActivity.class);
        startActivity(intent);
    }
}
