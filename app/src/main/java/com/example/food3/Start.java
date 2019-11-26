package com.example.food3;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class Start extends AppCompatActivity {
    private ImageView taste;
    private ImageView bowl;
    private ImageView rice;
    private TextView food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);taste = findViewById(R.id.taste);
        bowl = findViewById(R.id.bowl);
        rice = findViewById(R.id.rice);
        food = findViewById(R.id.food_name);

        ObjectAnimator bowlMove = ObjectAnimator.ofFloat(bowl,"rotation",0f,360f).setDuration(1100);
        bowlMove.start();
        ObjectAnimator riceMove = ObjectAnimator.ofFloat(rice,"translationY",0f,510f).setDuration(1100);
        riceMove.setInterpolator(new AccelerateDecelerateInterpolator());
        riceMove.start();
        taste.setVisibility(View.INVISIBLE);
        food.setVisibility(View.INVISIBLE);
        riceMove.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                taste.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                moveIn();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Start.this,Loggin.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(Start.this).toBundle());
//                overridePendingTransition(R.transition.in_anim,R.transition.out_anim);
//                finish();
//                overridePendingTransition(R.transition.in_anim,R.transition.out_anim);
//                getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

            }
        },4000);

    }
    public void moveIn(){
        AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(2500);
        taste.startAnimation(alphaAnimation);
        food.startAnimation(alphaAnimation);
    }
}
