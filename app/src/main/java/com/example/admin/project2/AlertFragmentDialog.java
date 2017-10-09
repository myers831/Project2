package com.example.admin.project2;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlertFragmentDialog extends DialogFragment {


    public AlertFragmentDialog() {
        // Required empty public constructor
    }


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder( getActivity() );


        builder.setView(inflater.inflate(R.layout.fragment_alert_fragment_dialog, null))
                // Add action buttons
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })

                .setNegativeButton( "No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AlertFragmentDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();

    }
}
