package com.example.cc15.anwesha2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    ImageView logo;
    TextView textView;

    //RotateAnimation r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        AnimationSet s1 = new AnimationSet(false);
        //AnimationSet s2 = new AnimationSet(false);
        logo = (ImageView) findViewById(R.id.anwesha_logo);
        textView = (TextView) findViewById(R.id.text_view);
        textView.setText("Think.Dream.Live");
        Animation r1,r2,r3,r4;
        r1= AnimationUtils.loadAnimation(this, R.anim.rotator1);
        r2= AnimationUtils.loadAnimation(this, R.anim.rotator2);
        r3= AnimationUtils.loadAnimation(this, R.anim.rotator3);
        r4= AnimationUtils.loadAnimation(this, R.anim.fadein);
        s1.addAnimation(r1);
        s1.addAnimation(r2);
        s1.addAnimation(r3);
        logo.startAnimation(s1);
        textView.startAnimation(r4);



    }

}
