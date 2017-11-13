package com.example.marcus.galgeleg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.id;
import static com.example.marcus.galgeleg.Galgelogik.*;

public class Spil_akt extends AppCompatActivity implements View.OnClickListener  {

    TextView synligtOrd;
    TextView besked;
    TextView galgeOrdet;
    EditText gaettetBogstav;
    ImageView galgen;
    Button gaetKnap;
    Button nytSpilKnap;
    String bogstav;
    Galgelogik Galgelogik = new Galgelogik();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_akt);




        gaetKnap = (Button) findViewById(R.id.gaetKnap);
        gaetKnap.setOnClickListener(this);

        gaettetBogstav = (EditText) findViewById(R.id.gaetBogstav);
        synligtOrd = (TextView) findViewById(R.id.synligtOrd);


            //kilde: vink til AsyncTask fra https://docs.google.com/document/d/1YLo9krF3pdg-IB8Wjw3ZZzr4Xo1le-nBBj7gk158muQ/edit#
            System.out.println("Henter ord fra DRs server....");
            new AsyncTask() {
                @Override
                protected Object doInBackground(Object... arg0) {
                    try {
                        Galgelogik.hentOrdFraDr();
                        return "Ordene blev korrekt hentet fra DR's server";
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "Ordene blev ikke hentet korrekt: "+e;
                    }
                }

                @Override
                protected void onPostExecute(Object resultat) {
                    System.out.println("resultat: \n" + resultat);
                    synligtOrd.setText(Galgelogik.getSynligtOrd());
                    galgeOrdet.setText(Galgelogik.getOrdet());

                }
            }.execute();




        /*  SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String fornavn = prefs.getString("fornavn", "(ukendt)");

        String fornavn = "Søren";
        prefs.edit().putString("fornavn", fornavn).commit(); */




        besked = (TextView) findViewById(R.id.besked);

        galgen = (ImageView) findViewById(R.id.galgen);
        galgen.setImageResource(R.mipmap.galge);

        //galget ordet var så man kunne se det korrekte ord for test
        galgeOrdet = (TextView) findViewById(R.id.ordet);




        nytSpilKnap = (Button) findViewById(R.id.nytSpilKnap);
        nytSpilKnap.setOnClickListener(this);



        System.out.println("nyt spil er lavet");




    }
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.gaetKnap:
                bogstav = gaettetBogstav.getText().toString();

                if (gaettetBogstav.getText() != null && bogstav.length() == 1) {
                    Galgelogik.gætBogstav(bogstav);
                    Log.d("nyt bogstav gættet", bogstav);
                }

                if (Galgelogik.erSpilletVundet()) {
                    besked.setText("Spillet er vundet! " + bogstav + " var korrekt! tryk på Nyt Spil for at spille igen");
                } else if (Galgelogik.erSpilletTabt()) {
                    besked.setText("Spillet er tabt! " + bogstav + " var forkert! tryk på Nyt Spil for at spille igen");
                } else if (Galgelogik.erSidsteBogstavKorrekt()) {
                    besked.setText(bogstav + " var korrekt!");
                } else if (bogstav.length() != 1) {
                    besked.setText("skriv et bogstav");
                } else {
                    besked.setText(bogstav + " var forkert! Du har " + (7 - Galgelogik.getAntalForkerteBogstaver()) + " forsøg tilbage");
                }

                gaettetBogstav.setText("");

                if (Galgelogik.getAntalForkerteBogstaver() == 0) {
                    galgen.setImageResource(R.mipmap.galge);
                } else if (Galgelogik.getAntalForkerteBogstaver() == 1) {
                    galgen.setImageResource(R.mipmap.forkert1);
                } else if (Galgelogik.getAntalForkerteBogstaver() == 2) {
                    galgen.setImageResource(R.mipmap.forkert2);
                } else if (Galgelogik.getAntalForkerteBogstaver() == 3) {
                    galgen.setImageResource(R.mipmap.forkert3);
                } else if (Galgelogik.getAntalForkerteBogstaver() == 4) {
                    galgen.setImageResource(R.mipmap.forkert4);
                } else if (Galgelogik.getAntalForkerteBogstaver() == 5) {
                    galgen.setImageResource(R.mipmap.forkert5);
                } else if (Galgelogik.getAntalForkerteBogstaver() == 6) {
                    galgen.setImageResource(R.mipmap.forkert6);
                }

                if (Galgelogik.erSpilletSlut())
                {
                 if(Galgelogik.erSpilletVundet()){
                     System.out.println("Spillet er vundet");
                     Intent iv = new Intent(this, Vundet_akt.class);
                     iv.putExtra("antalForkerteBogstaver", Galgelogik.getAntalForkerteBogstaver());
                     Galgelogik.nulstil();
                     synligtOrd.setText(Galgelogik.getSynligtOrd());
                     besked.setText("");
                     galgeOrdet.setText(Galgelogik.getOrdet());
                     startActivity(iv);

                  }else if (Galgelogik.erSpilletTabt())
                 {
                     System.out.println("Spillet er vundet");
                     Intent it = new Intent(this, Tabt_akt.class);
                     it.putExtra("ordet", Galgelogik.getOrdet());
                     startActivity(it);
                     Galgelogik.nulstil();
                     synligtOrd.setText(Galgelogik.getSynligtOrd());
                     besked.setText("");
                     galgeOrdet.setText(Galgelogik.getOrdet());
                 }else besked.setText("noget gik galt, spillet er slut men du har hverken tabt eller vundwet");
                }


                synligtOrd.setText(Galgelogik.getSynligtOrd());

                System.out.println("gaetknap er trykket");
                break;



        }
    }
}
