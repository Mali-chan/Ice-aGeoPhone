package com.ece.iceageophone.ice_ageophone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText phoneNumberEditText;
    private EditText smsBodyEditText;

    private Button sendSmsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Start application");

        phoneNumberEditText = (EditText) findViewById(R.id.phone_number_edit_text);
        smsBodyEditText = (EditText) findViewById(R.id.sms_body_edit_text);

        sendSmsButton = (Button) findViewById(R.id.send_sms_button);
        sendSmsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsMessage(phoneNumberEditText.getText().toString(), smsBodyEditText.getText().toString());
            }
        });
    }

    /**
     * Sends a text message to a phone number
     * @param phoneNumber
     * @param text
     */
    protected void sendSmsMessage(String phoneNumber, String text) {
        Log.d(TAG, "Sending text message \"" + text + "\" to " + phoneNumber);

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, text, null, null);
    }

}
