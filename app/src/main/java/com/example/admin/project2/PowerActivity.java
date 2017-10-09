package com.example.admin.project2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PowerActivity extends AppCompatActivity implements TimerButtonFragment.OnFragmentInteractionListener{

    private TimerButtonFragment timerButtonFragment;
    private TimerDisplayFragment timerDisplayFragment;


    public static final String BUTTON_FRAG_TAG = "buttonFragmentTag";
    public static final String DISPLAY_FRAG_TAG = "displayFragmentTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);

        timerButtonFragment = new TimerButtonFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.flTB, timerButtonFragment, BUTTON_FRAG_TAG).addToBackStack(BUTTON_FRAG_TAG).commit();

        timerDisplayFragment = new TimerDisplayFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.flDT, timerDisplayFragment, DISPLAY_FRAG_TAG).addToBackStack(DISPLAY_FRAG_TAG).commit();


    }

    @Override
    public void onFragmentInteraction(int i) {
            timerDisplayFragment.Display(i);
    }
}
