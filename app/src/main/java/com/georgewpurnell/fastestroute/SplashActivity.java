package com.georgewpurnell.fastestroute;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class SplashActivity extends AppCompatActivity {


    private ViewGroup mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.splash_activity);
        final Transition explode = new Explode();
        explode.setDuration(1000);
        getWindow().setExitTransition(explode);
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.big);
        final View bigGText = (View) findViewById(R.id.bigGText);
        final View cursiveGText = (View) findViewById(R.id.cursiveGText);
        final View bigPText = (View) findViewById(R.id.bigPText);
        final View cursivePText = (View) findViewById(R.id.cursivePText);
        //setupWindowAnimations();
        final Activity activity = this;
        final Intent intent = new Intent(this,HomeActivity.class);
        getWindow().getExitTransition().addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                // put your code here
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionManager.beginDelayedTransition(viewGroup,explode);
                toggle(bigGText,cursiveGText,bigPText,cursivePText);
                //startActivity(intent,
                  //      ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
            }
        }, 1000 );
        //startActivity(intent);
    }

    private void setupWindowAnimations() {

        //explode.setDuration(5000);
        //getWindow().setExitTransition(explode);
    }
    public void toggle(View... views){
        for (View current : views) {
            if (current.getVisibility() == View.VISIBLE){
                current.setVisibility(View.INVISIBLE);
            }
        }
    }
}
