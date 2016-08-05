package com.example.recyclercards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MultiCheckBoxChallenge extends AppCompatActivity {
    private FrameLayout fl_seenPeople;
    private boolean[] previousChecked;

    /*@Override
    public void onSelectedData(boolean[] previousChecked) {
        this.previousChecked = previousChecked;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_check_box_challenge);

        //previousChecked = new boolean[]{true, true, true, true, true, true, true};
        //filter seen_people
        fl_seenPeople = (FrameLayout) findViewById(R.id.fl_seenPeople);
        fl_seenPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChecksDialog cd = new ChecksDialog();
                cd.show(getFragmentManager(),"CD");
            }
        });
    }
}
