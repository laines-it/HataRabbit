package com.example.hat_rabbit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

import static com.example.hat_rabbit.MainActivity.points;
import static com.example.hat_rabbit.SkinsActivity.selected_skin;

public class GameActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }

    class GameView extends View {
        private final int timerInterval = 30;
        private Sprite rabbit;
        private Sprite player;
        private int viewWidth, viewHeight;
        private int rabbitcount = 0;
        public GameView(Context context) {

            super(context);
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.player);
            //Создал Шляпу
            if(selected_skin.equals("Blue")){
                b = BitmapFactory.decodeResource(getResources(), R.drawable.player_bluem);
            }
            if(selected_skin.equals("Pink")){
                b = BitmapFactory.decodeResource(getResources(), R.drawable.player_pinkm);
            }
            if(selected_skin.equals("Noir")){
                b = BitmapFactory.decodeResource(getResources(), R.drawable.player_nuar);
            }
            if(selected_skin.equals("Leprechaun")){
                 b = BitmapFactory.decodeResource(getResources(), R.drawable.player_leprikon);
            }
            if(selected_skin.equals("Mafia")){
                 b = BitmapFactory.decodeResource(getResources(), R.drawable.player_mafiozi);
            }
            if(selected_skin.equals("Choco")){
                 b = BitmapFactory.decodeResource(getResources(), R.drawable.player_choco);
            }
            int w = b.getWidth() / 5;
            int h = b.getHeight() / 3;

            Rect firstFrame = new Rect(0, 0, w, h);

            player = new Sprite(0, 1100, 170, 0, firstFrame, b);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i == 2 && j == 3) {
                        continue;
                    }
                    player.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
                }
            }
            //Создал Кролика
            b = BitmapFactory.decodeResource(getResources(), R.drawable.rabbit);
            w = b.getWidth() / 5;
            h = b.getHeight() / 3;

            firstFrame = new Rect(4 * w, 0, 5 * w, h);

            rabbit = new Sprite(10, 0, 0, 500, firstFrame, b);

            for (int i = 0; i < 3; i++) {
                for (int j = 4; j >= 0; j--) {
                    if (i == 0 && j == 4) {
                        continue;
                    }
                    if (i == 2 && j == 0) {
                        continue;
                    }
                    rabbit.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
                }
            }
            points = 0;
            Timer t = new Timer();
            t.start();
        }


        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            viewWidth = w;
            viewHeight = h;
        }

        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawARGB(250, 255, 255, 255);
            Paint p = new Paint();
            p.setAntiAlias(true);
            p.setTextSize(55.0f);
            p.setColor(Color.BLACK);
            canvas.drawText(points + "", viewWidth - 100, 70, p);
            p.setTextSize(55.0f);
            p.setColor(Color.BLACK);
            canvas.drawText(rabbitcount + "", viewWidth - 500, 70, p);
            player.draw(canvas);
            rabbit.draw(canvas);
        }

        protected void update() {

                player.update(timerInterval);
                rabbit.update(timerInterval);
                if (rabbit.getY() > player.getY()) {
                    teleportEnemy();
                    rabbitcount += 1;
                    points -= 10;
                }
                // Проверка столкновений
                if (rabbit.intersect(player)) {
                    teleportEnemy();
                    rabbitcount += 1;
                    points += 10;
                }

                invalidate();
            }


        public void Gameover() {
            Intent intent = new Intent(GameActivity.this, Gameover.class);
            startActivity(intent);

        }



        class Timer extends CountDownTimer {
            private Timer() {
                super(Integer.MAX_VALUE,timerInterval);
            }

            @Override
            public void onTick(long millisUntilFinished) {
                if(rabbitcount == 10){
                    Gameover();
                    cancel();
                }
                update();
            }

            @Override
            public void onFinish() {
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            int eventAction = event.getAction();

            if (eventAction == MotionEvent.ACTION_DOWN) {
                if (event.getX() < player.getBoundingBoxRect().right) {
                    player.setVx(-100);
                    points--;
                } else if (event.getX() > (player.getBoundingBoxRect().left)) {
                    player.setVx(100);
                    points--;
                }
            }
            if (player.getX() + player.getFrameWidth() > viewWidth) {
                player.setX(viewWidth - player.getFrameWidth());
                player.setVx(-player.getVx());
                points--;
            } else if (player.getX() < 0) {
                player.setX(0);
                player.setVx(-player.getVx());
                points--;
            }
            return true;
        }

        private void teleportEnemy() {
            rabbit.setY(-200);
            rabbit.setX(Math.random() * (viewWidth - rabbit.getFrameWidth()));
        }


    }
}

