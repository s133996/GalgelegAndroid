package com.example.marcus.galgeleg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hovedmenu_akt extends AppCompatActivity implements View.OnClickListener {

    Button knap;
    Button hjaelpKnap;
    SharedPreferences prefs;
    String fornavn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hovedmenu_akt);



        prefs = PreferenceManager.getDefaultSharedPreferences(this);


        fornavn = prefs.getString("fornavn", "(ukendt)");

        System.out.println(fornavn);

        prefs.edit().putString("fornavn", fornavn).commit();

        fornavn = prefs.getString("fornavn", "(ukendt)");

        System.out.println(fornavn);

        knap = (Button) findViewById(R.id.spilknap);

        knap.setOnClickListener(this);

        hjaelpKnap = (Button) findViewById(R.id.hjaelpKnap);

        hjaelpKnap.setOnClickListener(this);


        System.out.println("Hovedmenu er lavet");


    }

    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.spilknap:
            System.out.println("spilknap er trykket");
            Intent i = new Intent(this, Spil_akt.class);
            startActivity(i);
                break;

            case R.id.hjaelpKnap:
                System.out.println("hjaelpknap er trykket");
                Intent ih = new Intent(this, Hjaelp_akt.class);
                startActivity(ih);
                break;


        }
    }
}