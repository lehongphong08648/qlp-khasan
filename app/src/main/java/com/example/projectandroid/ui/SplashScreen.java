package com.example.projectandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectandroid.R;

public class SplashScreen extends AppCompatActivity {
    TextView tvicon,tvslogan;
    ImageView imgIcon;

//todo anh vượt làm màn hình chào nhé !
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        tvicon = findViewById(R.id.tvicon);
        tvslogan = findViewById(R.id.tvslogan);
        imgIcon = findViewById(R.id.imglogo);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        imgIcon.startAnimation(animation);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.bot_animation);
        tvslogan.startAnimation(animation1);
        tvicon.startAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,Login.class));
                finish();
            }
        },3000);
    }
}
