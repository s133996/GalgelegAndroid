package com.example.marcus.galgeleg;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tabt_akt extends AppCompatActivity implements View.OnClickListener {

    Button taberKnap;
    TextView taberTekst;
    SharedPreferences prefs;
    String fornavn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabt_akt);

        Bundle b = getIntent().getExtras();
        String GalgeOrdet = b.getString("ordet");

        taberKnap = (Button) findViewById(R.id.taberKnap);
        taberKnap.setOnClickListener(this);

        taberTekst = (TextView) findViewById(R.id.taberTekst);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        fornavn = prefs.getString("fornavn", "skriv dit navn her");
        if (fornavn != "skriv dit navn her") {
            taberTekst.setText("Ærgeligt! " + fornavn + ", du har tabt! Ordet var: " + GalgeOrdet + ". Tryk på Nyt spil for at spille igen");
        } else {
            taberTekst.setText("Ærgeligt, du har tabt! Ordet var: " + GalgeOrdet + ". Tryk på Nyt spil for at spille igen");
        }
    }


    public void onClick(View v) {
        System.out.println("Nyt spil (taber) er trykket");
        finish();
    }
}

