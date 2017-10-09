package com.example.admin.project2;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void buttonPress(View view) {
        switch (view.getId()){
            case R.id.btnAM:

                Intent intent = new Intent(HomeActivity.this, PDFViewer.class);
                startActivity(intent);

                break;
            case R.id.btnAL:
                FragmentManager fragmentManager = getSupportFragmentManager();

                final PictureDialogFragment pictureDialogFragment = new PictureDialogFragment();
                pictureDialogFragment.show(fragmentManager, "");

                final Handler handler = new Handler();
                final Runnable runnable = new Runnable() {

                    @Override
                    public void run() {
                        if (pictureDialogFragment.getShowsDialog()) {
                            pictureDialogFragment.dismiss();
                        }
                    }
                };

                fragmentManager.executePendingTransactions();
                pictureDialogFragment.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {

                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        handler.removeCallbacks(runnable);
                    }
                });

                handler.postDelayed(runnable, 3000);
                break;

            case R.id.btnA1:

                AlertDialog.Builder builder;
                //*

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(this);
                }//*/

                builder.setTitle("Naruto")
                        .setMessage("A Shinobi's life is not measured by how they lived but rather what they managed to accomplish before their death.")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })

                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }

                        }).setIcon(android.R.drawable.ic_dialog_alert).show();
                break;

            case R.id.btnA2:

                AlertFragmentDialog alertFragmentDialog = new AlertFragmentDialog();

                alertFragmentDialog.show(getSupportFragmentManager(), "dialog");
                break;

            case R.id.btnA3:

                AlertDialog.Builder builder3 = new AlertDialog.Builder( this );
                builder3.setTitle( "Favorite Anime List" )
                        .setMultiChoiceItems(R.array.Anime_List, null,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    }
                                })

                        .setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })

                        .setNegativeButton( android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })
                        .show();

                break;
            case R.id.btnAN:

                String CHANNEL_ID = "my_channel_01";
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)

                                .setSmallIcon(R.mipmap.ic_launcher)

                                .setContentTitle("Anime App Notification")

                                .setContentText("Believe it!!").setChannel(CHANNEL_ID);

                Intent resultIntent = new Intent(this, PDFViewer.class);

                PendingIntent resultPendingIntent = PendingIntent.getActivity( this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                mBuilder.setContentIntent(resultPendingIntent);

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                mNotificationManager.notify( 666, mBuilder.build());

                Toast.makeText(HomeActivity.this, "Notification in Dropdown Drawer", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnAST:

                Intent intent2 = new Intent(HomeActivity.this, SendSMS.class);
                startActivity(intent2);

                break;

            case R.id.btnT:

                Intent intent3 = new Intent(HomeActivity.this, PowerActivity.class);
                startActivity(intent3);

                break;
        }
    }
}
