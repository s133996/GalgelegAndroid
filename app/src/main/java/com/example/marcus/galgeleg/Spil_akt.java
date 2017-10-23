package com.example.marcus.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.marcus.galgeleg.Galgelogik.*;

public class Spil_akt extends AppCompatActivity implements View.OnClickListener  {

    TextView synligtOrd;
    TextView galgeOrdet;
    EditText gaettetBogstav;
    Galgelogik Galgelogik;
    Button gaetKnap;
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




        galgeOrdet = (TextView) findViewById(R.id.ordet);
        galgeOrdet.setText(Galgelogik.getOrdet());

        gaettetBogstav = (EditText) findViewById(R.id.gaetBogstav);





        System.out.println("nyt spil er lavet");




    }
    public void onClick(View v) {
        bogstav = gaettetBogstav.getText().toString();

        if (gaettetBogstav.getText() != null && bogstav.length() == 1)  {
            Galgelogik.gætBogstav(bogstav);
            Log.d("nyt bogstav gættet", bogstav);
        }

        synligtOrd.setText(Galgelogik.getSynligtOrd());

        System.out.println("gaetknap er trykket");

    }
}
