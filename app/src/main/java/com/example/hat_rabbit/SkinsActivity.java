package com.example.hat_rabbit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.hat_rabbit.MainActivity.money;

public class SkinsActivity extends AppCompatActivity {
    public static String selected_skin = "Default";
    public boolean buyblue = true;
    public boolean buypink = true;
    public boolean buynoir = true;
    public boolean buyleprechaun = true;
    public boolean buymafia = true;
    public boolean buychoco = true;
    TextView textmoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skins);
        select(selected_skin);
        textmoney = findViewById(R.id.moneyskins);
        textmoney.setText("$" + money);

    }
    public void select(String selected_skin) {
        ImageView imageView1 = findViewById(R.id.selectedblue);
        imageView1.setVisibility(View.INVISIBLE);
        ImageView imageView2 = findViewById(R.id.selectedpink);
        imageView2.setVisibility(View.INVISIBLE);
        ImageView imageView3 = findViewById(R.id.selectednoir);
        imageView3.setVisibility(View.INVISIBLE);
        ImageView imageView4 = findViewById(R.id.selectedleprechaun);
        imageView4.setVisibility(View.INVISIBLE);
        ImageView imageView5 = findViewById(R.id.selectedmafia);
        imageView5.setVisibility(View.INVISIBLE);
        ImageView imageView6 = findViewById(R.id.selectedchoco);
        imageView6.setVisibility(View.INVISIBLE);
        switch (selected_skin) {
            case "Blue":
                imageView1.setVisibility(View.VISIBLE);
                break;
            case "Pink":
                imageView2.setVisibility(View.VISIBLE);
                break;
            case "Noir":
                imageView3.setVisibility(View.VISIBLE);
                break;
            case "Leprechaun":
                imageView4.setVisibility(View.VISIBLE);
                break;
            case "Mafia":
                imageView5.setVisibility(View.VISIBLE);
                break;
            case "Choco":
                imageView6.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
    public void buy_blue(View view){
        if(buyblue && money>=5){
            selected_skin = "Blue";
            select(selected_skin);
        money -= 5;
        textmoney.setText("$" + money);
            buyblue = false;
        }
    }
    public void buy_pink(View view){
        if(buypink && money>=5){selected_skin = "Pink";select(selected_skin);
            money -= 5;
            textmoney.setText("$" + money);
            buypink = false;
        }
    }
    public void buy_noir(View view){
        if(buynoir && money>=10){selected_skin = "Noir";select(selected_skin);
            money -= 10;
            textmoney.setText("$" + money);
            buynoir = false;
        }
    }
    public void buy_leprechaun(View view){
        if(buyleprechaun && money>=15){selected_skin = "Leprechaun";select(selected_skin);
            money -= 15;
            textmoney.setText("$" + money);
            buyleprechaun = false;
        }
    }
    public void buy_mafia(View view){
        if(buymafia && money>=15){selected_skin = "Mafia";select(selected_skin);
            money -= 15;
            textmoney.setText("$" + money);
            buymafia = false;
        }
    }
    public void buy_choco(View view){
        if(buychoco && money>=15){selected_skin = "Choco";select(selected_skin);
            money -= 15;
            textmoney.setText("$" + money);
            buychoco = false;
        }
    }
    public void menu(View view){
        Intent intent = new Intent(SkinsActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void select_blue(View view){
        if(!buyblue){
            selected_skin = "Blue";
            select(selected_skin);
        }
    }
    public void select_pink(View view){
        if(!buypink){
            selected_skin = "Pink";
            select(selected_skin);
        }
    }
    public void select_noir(View view){
        if(!buynoir){
            selected_skin = "Noir";
            select(selected_skin);
        }
    }
    public void select_leprechaun(View view){
        if(!buyleprechaun){
            selected_skin = "Leprechaun";
            select(selected_skin);
        }
    }
    public void select_mafia(View view){
        if(!buymafia){
            selected_skin = "Mafia";
            select(selected_skin);
        }
    }
    public void select_choco(View view){
        if(!buychoco){
            selected_skin = "Choco";
            select(selected_skin);
        }
    }
    public void addmoney(View view){
        Intent intent = new Intent(SkinsActivity.this, Ad.class);
        startActivity(intent);
    }
}
