package com.lcs.pokemonsqlite;

public class Pokemon {
    private String name;
    private String url;
    private String descripcion;

    public Pokemon(String nombre, String url, String descripcion) {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
}
