package com.lcs.pokemonsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView listapokemon;
    List<Pokemon> pokemones;
    BaseDatos db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listapokemon=findViewById(R.id.RecyclerView);
        pokemones= new ArrayList<>();
        pokemones.add(db.buscarpokemon("Bulbasaur"));
        pokemones.add(db.buscarpokemon("Charizard"));
        pokemones.add(db.buscarpokemon("Emboar"));
        pokemones.add(db.buscarpokemon("Toxtricity"));
        pokemones.add(db.buscarpokemon("Inteleon"));

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        listapokemon.setLayoutManager(linearLayoutManager);

    }
}