package com.example.marcus.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hovedmenu_akt extends AppCompatActivity implements View.OnClickListener {

    Button knap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hovedmenu_akt);

        knap = (Button) findViewById(R.id.spilknap);

        knap.setOnClickListener(this);


        System.out.println("Hovedmenu er lavet");


    }

    public void onClick(View v) {
        System.out.println("spilknap er trykket");
        Intent i = new Intent(this, Spil_akt.class);
        startActivity(i);
    }
}