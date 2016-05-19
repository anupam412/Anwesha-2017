package com.example.cc15.anwesha2017;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import com.example.cc15.anwesha2017.activities.RegistrationActivity;


public class WelcomeScreen extends AppCompatActivity {

    ImageView logo;
    TextView textView;
    public int count=0;
    int tempInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count = readSharedPreferenceInt("cntSP","cntKey");
        if(count==0){
            Intent intent = new Intent();
            intent.setClass(WelcomeScreen.this, RegistrationActivity.class);
            startActivity(intent);
            count++;
            writeSharedPreference(count, "cntSP", "cntKey");
        }

        else {
        setContentView(R.layout.activity_welcome_screen);

        AnimationSet s1 = new AnimationSet(false);

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


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    finish();
                    Intent i3 = new Intent(WelcomeScreen.this, Home.class);
                    startActivity(i3);
                }
            }, 6000);
        }
    }

    //Read from Shared Preferance
    public int readSharedPreferenceInt(String spName,String key){
        SharedPreferences sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
        return tempInt = sharedPreferences.getInt(key, 0);
    }

    //write shared preferences in integer
    public void writeSharedPreference(int ammount,String spName,String key ){

        SharedPreferences sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(key, ammount);
        editor.commit();
    }
}
