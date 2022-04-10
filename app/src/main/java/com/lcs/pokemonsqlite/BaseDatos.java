package com.lcs.pokemonsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="Pokemon.db";

    public BaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BasedeDatos (Nombre TEXT NOT NULL, Url TEXT, Descripcion TEXT)");
        Pokemon bulbasaur= new Pokemon("Bulbasaur", "bulbasaur.png", "Es Bulbasaur!!");
        this.guardar(bulbasaur, db);
        Pokemon charizar= new Pokemon("Charizar", "charizard.png", "Es Charizar!!");
        this.guardar(charizar, db);
        Pokemon emboar= new Pokemon("Emboar", "emboar.png", "Es Emboar!!");
        this.guardar(emboar, db);
        Pokemon toxtri= new Pokemon("Toxticitry", "toxtricity.png", "Es Toxticitry!!");
        this.guardar(toxtri, db);
        Pokemon inteleon= new Pokemon("Inteleon", "inteleon.png", "Es Inteleon!!");
        this.guardar(inteleon, db);

    }
    private void guardar(Pokemon pokemon, SQLiteDatabase db){

        if(db == null)
            db = getWritableDatabase();

        db.execSQL("INSERT INTO BasedeDatos (Nombre, Url, Descripcion) VALUES("+pokemon.getName()+","+pokemon.getUrl()+","+pokemon.getDescripcion()+")");
    }
    public Pokemon buscarpokemon(String nombre){
        Pokemon pokemon=new Pokemon("","","");
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM BasedeDatos WHERE Nombre LIKE ?", new String[]{nombre});
        pokemon.setName(cursor.getColumnName(1));
        pokemon.setUrl(cursor.getColumnName(2));
        pokemon.setDescripcion(cursor.getColumnName(3));
        return pokemon;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
