package com.example.marcus.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.marcus.galgeleg.Galgelogik.*;

public class Spil_akt extends AppCompatActivity implements View.OnClickListener  {

    TextView synligtOrd;
    TextView besked;
    TextView galgeOrdet;
    EditText gaettetBogstav;
    Galgelogik Galgelogik;
    ImageView galgen;
    Button gaetKnap;
    Button nytSpilKnap;
    String bogstav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil_akt);


        Galgelogik = new Galgelogik();
        Galgelogik.nulstil();

        gaetKnap = (Button) findViewById(R.id.gaetKnap);
        gaetKnap.setOnClickListener(this);

        synligtOrd = (TextView) findViewById(R.id.synligtOrd);
        synligtOrd.setText(Galgelogik.getSynligtOrd());

        besked = (TextView) findViewById(R.id.besked);

        galgen = (ImageView) findViewById(R.id.galgen);
        galgen.setImageResource(R.mipmap.galge);

        galgeOrdet = (TextView) findViewById(R.id.ordet);
        galgeOrdet.setText(Galgelogik.getOrdet());

        gaettetBogstav = (EditText) findViewById(R.id.gaetBogstav);

        nytSpilKnap = (Button) findViewById(R.id.nytSpilKnap);



        System.out.println("nyt spil er lavet");




    }
    public void onClick(View v) {
        bogstav = gaettetBogstav.getText().toString();

        if (gaettetBogstav.getText() != null && bogstav.length() == 1)  {
            Galgelogik.gætBogstav(bogstav);
            Log.d("nyt bogstav gættet", bogstav);
        }

        if(Galgelogik.erSpilletVundet()){
            besked.setText("Spillet er vundet! " + bogstav + " var korrekt! tryk på Nyt Spil for at spille igen");
        }else if (Galgelogik.erSpilletTabt()) {
            besked.setText("Spillet er tabt! " + bogstav + " var forkert! tryk på Nyt Spil for at spille igen");
        }else if(Galgelogik.erSidsteBogstavKorrekt()){
            besked.setText(bogstav + " var korrekt!");
        }else if(bogstav.length() != 1){
                besked.setText("skriv et bogstav");
        }else{
            besked.setText(bogstav + " var forkert! Du har " + (7-Galgelogik.getAntalForkerteBogstaver()) + " forsøg tilbage");
        }

        gaettetBogstav.setText("");

        if (Galgelogik.getAntalForkerteBogstaver()==0){
            galgen.setImageResource(R.mipmap.galge);
        }else if (Galgelogik.getAntalForkerteBogstaver()==1) {
            galgen.setImageResource(R.mipmap.forkert1);
        }else if (Galgelogik.getAntalForkerteBogstaver()==2) {
            galgen.setImageResource(R.mipmap.forkert2);
        }else if (Galgelogik.getAntalForkerteBogstaver()==3) {
            galgen.setImageResource(R.mipmap.forkert3);
        }else if (Galgelogik.getAntalForkerteBogstaver()==4) {
            galgen.setImageResource(R.mipmap.forkert4);
        }else if (Galgelogik.getAntalForkerteBogstaver()==5) {
            galgen.setImageResource(R.mipmap.forkert5);
        }else if (Galgelogik.getAntalForkerteBogstaver()==6) {
            galgen.setImageResource(R.mipmap.forkert6);
        }

        if(Galgelogik.erSpilletSlut()) nytSpilKnap.setVisibility(View.VISIBLE);

        synligtOrd.setText(Galgelogik.getSynligtOrd());

        System.out.println("gaetknap er trykket");

    }
}
