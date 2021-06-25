package com.fabricioae.labandroidpokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnVerPokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerPokemons = findViewById(R.id.btnVerPokemons);
        btnVerPokemons.setOnClickListener(v -> {
            Intent intentVerPokemons = new Intent(getApplicationContext(), VerPokemons.class);
            startActivity(intentVerPokemons);

        });
    }
}