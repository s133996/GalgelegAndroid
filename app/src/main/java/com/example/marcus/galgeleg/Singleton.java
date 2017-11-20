package com.example.marcus.galgeleg;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;

/**
 * Created by Marcus on 20-11-2017.
 */



    public class Singleton extends Application {
    public static Singleton instans;
    public static SharedPreferences prefs;
    public static Handler forgrundstråd;
    //     public static Netvaerksstatus netværk;

    @Override
    public void onCreate() {
        super.onCreate();
        instans = this;
        //      netværk = new Netvaerksstatus();
        forgrundstråd = new Handler();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

    }
}
