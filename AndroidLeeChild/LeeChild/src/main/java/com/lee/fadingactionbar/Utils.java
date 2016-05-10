package com.lee.fadingactionbar;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by liwei on 16/4/22.
 */
public class Utils {
    public static int getDisplayHeight(Context context){
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        int displayHeight = wm.getDefaultDisplay().getHeight();
        return displayHeight;
    }
}
