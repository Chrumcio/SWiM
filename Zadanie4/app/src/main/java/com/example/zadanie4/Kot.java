package com.example.zadanie4;

public class Kot {
    private String rasa;
    private String wiek;
    private String imie;

    public Kot(String rasa,String  wiek,String imie){
        this.rasa = rasa;
        this.wiek = wiek;
        this.imie = imie;
    }

    public String getWiek() {
        return wiek;
    }

    public String getImie() {
        return imie;
    }

    public String getRasa() {
        return rasa;
    }

    @Override
    public String toString() {
        return this.rasa+" "+this.imie+" "+this.wiek;
    }
}
