package com.example.greathoang.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayoutMayBay = (RelativeLayout) findViewById(R.id.rlMayBay);
        TextView textViewTranslate = (TextView) findViewById(R.id.txtTransition);
        ImageView imageViewRotate = (ImageView) findViewById(R.id.imageRotate);
        ImageView imageViewScaleBlack = (ImageView) findViewById(R.id.imageScaleBlack);
        ImageView imageViewScaleWhite = (ImageView) findViewById(R.id.imageScaleWhite);
        TextView textViewFaceOut = (TextView) findViewById(R.id.txtFaceOut);

        TranslateAnimation translateYAnimation = new TranslateAnimation(0f, 0f, 0f, -2200f);
        translateYAnimation.setDuration(5000l);
        translateYAnimation.setRepeatCount(Animation.INFINITE);
        translateYAnimation.setRepeatMode(Animation.REVERSE);

        TranslateAnimation translateXAnimation = new TranslateAnimation(0f, 1000f, 0f, 0f);
        translateXAnimation.setDuration(2000l);
        translateXAnimation.setRepeatMode(Animation.RESTART);
        translateXAnimation.setRepeatCount(Animation.INFINITE);

        Animation animationRotale = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Animation animationScaleOut = AnimationUtils.loadAnimation(this, R.anim.scale_out);

        Animation animationFaceOut = AnimationUtils.loadAnimation(this, R.anim.face_out);


        relativeLayoutMayBay.startAnimation(translateYAnimation);
        textViewTranslate.startAnimation(translateXAnimation);
        imageViewRotate.startAnimation(animationRotale);
        imageViewScaleBlack.startAnimation(animationScaleOut);
        imageViewScaleWhite.startAnimation(animationScaleOut);
        textViewFaceOut.startAnimation(animationFaceOut);
    }
}
