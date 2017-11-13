package com.example.marcus.galgeleg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hovedmenu_akt extends AppCompatActivity implements View.OnClickListener {

    TextView velkomstTekst;
    Button knap;
    Button hjaelpKnap;
    SharedPreferences prefs;
    String fornavn;
    EditText spillerNavn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hovedmenu_akt);

        velkomstTekst = (TextView) findViewById(R.id.velkomsttekst);



        prefs = PreferenceManager.getDefaultSharedPreferences(this);


        fornavn = prefs.getString("fornavn", "skriv dit navn her");

            System.out.println(fornavn);


        velkomstTekst.setText("Hej! " + fornavn + " Velkommen tilbage til Galgeleg! Tryk på Spil");


        spillerNavn = (EditText) findViewById(R.id.spillerNavn);

        spillerNavn.setText(fornavn);




        knap = (Button) findViewById(R.id.spilknap);

        knap.setOnClickListener(this);

        hjaelpKnap = (Button) findViewById(R.id.hjaelpKnap);

        hjaelpKnap.setOnClickListener(this);


        System.out.println("Hovedmenu er lavet");
        System.out.println(fornavn);


    }

    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.spilknap:
                if (spillerNavn.getText() != null) {
                    fornavn = spillerNavn.getText().toString();
                    prefs.edit().putString("fornavn", fornavn).apply();
                }
                System.out.println("fornavn er " + fornavn);
            System.out.println("spilknap er trykket");
            Intent i = new Intent(this, Spil_akt.class);
            startActivity(i);
                break;

            case R.id.hjaelpKnap:
                if (spillerNavn.getText() != null) {
                    fornavn = spillerNavn.getText().toString();
                    prefs.edit().putString("fornavn", fornavn).apply();
                }
                System.out.println("fornavn er " + fornavn);
                System.out.println("hjaelpknap er trykket");
                Intent ih = new Intent(this, Hjaelp_akt.class);
                startActivity(ih);
                break;


        }
    }
}