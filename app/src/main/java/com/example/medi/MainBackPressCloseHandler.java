package com.example.medi;

import android.app.Activity;
import android.widget.Toast;

public class MainBackPressCloseHandler {
    private long backKeyPressedTime = 0;
    private Toast toast;

    private Activity activity;

    public MainBackPressCloseHandler(Activity context) {
        this.activity = context;
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            android.os.Process.killProcess(android.os.Process.myPid());
            toast.cancel();
        }
    }

    public void showGuide() {
        toast = Toast.makeText(activity, "종료하시려면 \'뒤로\' 버튼을 한번 더 누르세요.",
                Toast.LENGTH_SHORT);
        toast.show();
    }

}