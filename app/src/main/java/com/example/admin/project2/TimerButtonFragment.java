package com.example.admin.project2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TimerButtonFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class TimerButtonFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    Button btnPU, btnPD;
    TimerTask timerTask;
    Timer timer;
    int i;



    public TimerButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer_button, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPU = view.findViewById(R.id.btnPU);
        btnPD = view.findViewById(R.id.btnPD);
        i = 0;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        mListener.onFragmentInteraction(i+=1);
                        Log.d("run", "run: " + i);
                    }
                };
                timer = new Timer();
                timer.scheduleAtFixedRate(timerTask,0 , 10);
            }
        });

        btnPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerTask.cancel();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int i);
    }
}
