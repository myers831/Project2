package com.example.admin.project2;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimerDisplayFragment extends Fragment {

    TextView tvP;
    Handler handler = new Handler(Looper.getMainLooper());


    public TimerDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer_display, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvP = view.findViewById(R.id.tvP);
    }

    public void Display(final int i){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(i >= 9000){
                    tvP.setText("IT'S OVER 9000!!!");
                } else {
                    tvP.setText(String.valueOf(i));
                }
            }
        });
    }

}
