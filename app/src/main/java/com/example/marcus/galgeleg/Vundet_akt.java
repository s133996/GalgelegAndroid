package com.example.marcus.galgeleg;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.marcus.galgeleg.R.id.besked;
import static com.example.marcus.galgeleg.R.id.synligtOrd;

public class Vundet_akt extends AppCompatActivity implements View.OnClickListener {

    Button vinderKnap;
    TextView vinderTekst;
    SharedPreferences prefs;
    String fornavn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vundet_akt);

        Bundle b = getIntent().getExtras();
        int antalForkerteBogstaver = b.getInt("antalForkerteBogstaver");

        vinderKnap = (Button) findViewById(R.id.vinderKnap);
        vinderKnap.setOnClickListener(this);

        vinderTekst = (TextView) findViewById(R.id.vinderTekst);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        fornavn = prefs.getString("fornavn", "skriv dit navn her");
        if (fornavn != "skriv dit navn her") {
            vinderTekst.setText("Tillykke " + fornavn + ", du har vundet! Du havde" + (7 - antalForkerteBogstaver) + "forsøg tilbage. tryk på Nyt spil for at spille igen");
        } else {
            vinderTekst.setText("Tillykke, du har vundet! Du havde" + (7 - antalForkerteBogstaver) + "forsøg tilbage. tryk på Nyt spil for at spille igen");
        }
    }


    public void onClick(View v) {
        System.out.println("Nyt spil (vinder) er trykket");
                finish();
    }
    }

