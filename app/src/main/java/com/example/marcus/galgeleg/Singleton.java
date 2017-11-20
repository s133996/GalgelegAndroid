package com.example.marcus.galgeleg;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

/**
 * Created by Marcus on 20-11-2017.
 */


public class Singleton extends Application {
    // Globale data (kunne godt være gemt i en klassevariabel andetsteds)
    public static SharedPreferences prefs;
    public static Singleton instans;
    Galgelogik Galgelogik = new Galgelogik();
    /**
     * Håndtag til forgrundstråden
     */
    public static Handler forgrundstråd = new Handler();
 /*   private static Programdata data;

    public static Programdata getData() {
        // if (data == null) data = new Programdata(); // klassisk singleon unødvendigt da den oprettes i onCreate()
        return data;
    }*/

    private static Singleton instance = null;

    //a private constructor so no instances can be made outside this class
    private Singleton() {
    }

    //Everytime you need an instance, call this
    //synchronized to make the call thread-safe
    public static synchronized Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }

    //Initialize this or any other variables in probably the Application class
    public void init(Context context) {
    }
}