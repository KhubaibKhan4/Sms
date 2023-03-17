package com.codespacepro.smssenderreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        Object[] objects = (Object[]) bundle.get("pdus");
        for (Object obj : objects) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
            String msgNo = smsMessage.getDisplayOriginatingAddress();
            String msg = smsMessage.getDisplayMessageBody();
            Log.d("Mobile", "Msg" + msgNo + ",Msg:" + msg);

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+923047373533", null, "Hello", null, null);
        }
    }
}
