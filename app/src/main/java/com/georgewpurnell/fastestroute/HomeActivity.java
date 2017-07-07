package com.georgewpurnell.fastestroute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by georgewpurnell on 7/7/17.
 */

public class HomeActivity extends AppCompatActivity {

    Button newRouteBtn, savedRouteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.home_activity);
        final Activity activity = this;
        newRouteBtn = (Button) findViewById(R.id.newRouteBtn);
        savedRouteBtn = (Button) findViewById(R.id.savedRouteBtn);

        newRouteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity,EnterStopsActivity.class));
            }
        });

        //setupWindowAnimations();
        savedRouteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity,UseSavedRouteActivity.class));
            }
        });
    }
}
