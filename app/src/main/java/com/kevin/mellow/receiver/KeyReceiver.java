package com.kevin.mellow.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/18.
 * <h3>
 * Describe:
 * <h3/>
 */
public class KeyReceiver extends BroadcastReceiver{
    static public final String SYSTEM_DIALOG_REASON_KEY = "reason";
    static public final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
    static public final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    static public final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    static public final String SYSTEM_DIALOG_REASON_ASSIST = "assist";

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        String action = arg1.getAction();
        //按下Home键会发送ACTION_CLOSE_SYSTEM_DIALOGS的广播
        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {

            String reason = arg1.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
            if (reason != null) {
                if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                    // 短按home键
                    Toast.makeText(arg0, "短按Home键", Toast.LENGTH_SHORT).show();
                } else if (reason.equals(SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                    // RECENT_APPS键
                    Toast.makeText(arg0, "RECENT_APPS", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
