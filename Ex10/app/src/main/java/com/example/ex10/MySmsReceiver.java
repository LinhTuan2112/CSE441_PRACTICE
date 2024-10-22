package com.example.ex10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        processReceivedSms(context, intent);
    }

    private void processReceivedSms(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String message = "";
        String body = "";
        String address = "";
        if (extras != null) {
            Object[] pdus = (Object[]) extras.get("pdus");
            for (int i = 0; i < pdus.length; i++) {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdus[i]);
                body += sms.getMessageBody();
                address = sms.getOriginatingAddress();
                message +="Có 1 tin nhan từ" + address + "\n" + body +"vừa gọi dến";
            }
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}
