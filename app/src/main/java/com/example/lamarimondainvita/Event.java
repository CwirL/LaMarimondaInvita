package com.example.lamarimondainvita;

import android.graphics.drawable.Drawable;

public class Event {
    private String name;
    private String date;
    private String location;
    private String valor;
    private String reto;


    private int thumbnail;



    public Event(String name, String date, String location, int thumbnail, String valor, String reto) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.thumbnail = thumbnail;
        this.valor = valor;
        this.reto = reto;
    }

    public void setReto(String reto) {
        this.reto = reto;
    }

    public String getReto() {
        return reto;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getThumbnail() {
        return thumbnail;
    }
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

