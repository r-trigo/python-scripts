package com.example.recyclercards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MultiCheckBoxChallenge extends AppCompatActivity {
    private FrameLayout fl_seenPeople;
    private FrameLayout fl_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_check_box_challenge);

        //filter seen_people
        fl_seenPeople = (FrameLayout) findViewById(R.id.fl_seenPeople);
        fl_seenPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilterSeenPeopleDialog cd = new FilterSeenPeopleDialog();
                cd.show(getFragmentManager(),"CD");
            }
        });

        //filter age
        fl_age = (FrameLayout) findViewById(R.id.fl_age);
        fl_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilterAgeDialog ad = new FilterAgeDialog();
                ad.show(getFragmentManager(),"AD");
            }
        });
    }
}
