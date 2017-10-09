package com.example.admin.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMS extends AppCompatActivity {

    private EditText etMsg;
    private EditText etNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        etMsg = (EditText) findViewById(R.id.etMsg);
        etNum = (EditText) findViewById(R.id.etNum);
    }

    public void sendSMS(View view) {
        //"3473373686"
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(etNum.getText().toString(), null, etMsg.getText().toString(), null, null);
        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }
}
