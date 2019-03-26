package com.example.zadanie2;

public class Hero {
    private int image;
    private String name,team;

    public Hero(int image,String name,String team){
        this.image = image;
        this.name = name;
        this.team = team;
    }

    public int getImage(){
        return this.image;
    }

    public String getName(){
        return this.name;
    }

    public String getTeam(){
        return this.team;
    }
}
