package com.example.marcus.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Hjaelp_akt extends AppCompatActivity implements View.OnClickListener{

    Button tilbageKnap;
    TextView hjaelpTekst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hjaelp_akt);

        tilbageKnap = (Button) findViewById(R.id.tilbageKnap);
        tilbageKnap.setOnClickListener(this);

        hjaelpTekst = (TextView) findViewById(R.id.hjaelpTekst);
        hjaelpTekst.setText("Galgespil går ud på at gætte et ord eller en sætning, hvor kun antallet af bogstaver er kendt, lidt i stil med Lykkehjulet. Der gættes på skift et bogstav af gangen, og korrekte bogstaver bliver placeret på de respektive pladser i ordet eller sætningen. For hver gang, der gættes forkert bliver der tegnet en del af en galge med en hængt mand på papiret eller tavlen. Opgaven går ud på gætte hele ordet eller sætningen inden tegningen bliver færdiggjort. Mængden af streger der bliver bliver tegnet for hvert forkert gæt, og tegningen kompleksitet kan varieres for at give spillerne mere eller mindre tid.\n" +
                "\n" +
                "Strategien i spillet går ud på at gætte på de bogstaver, der bruges hyppigst på det respektive sprog, som spillet spilles på. Dvs. at bogstaver som e, s, r og t typisk optræder i danske ord. Personen der bestemmer ordet eller sætningen kan samtidig spekulere i at bruge ord, som har få eller ingen hyppige bogstaver, som f.eks. jazz. - kilde: Wikipedia");
    }
    public void onClick(View v) {
        System.out.println("tilbageKnap er trykket");
        Intent i = new Intent(this, Hovedmenu_akt.class);
        startActivity(i);
    }
}
