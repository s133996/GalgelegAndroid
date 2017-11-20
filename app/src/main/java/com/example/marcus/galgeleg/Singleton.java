package com.example.marcus.galgeleg;

/**
 * Created by Marcus on 20-11-2017.
 */

public class Singleton {
    private static final Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
