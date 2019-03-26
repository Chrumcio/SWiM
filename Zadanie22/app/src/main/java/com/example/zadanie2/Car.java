package com.example.zadanie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Car {
    private String brand;
    private String description;
    private int imageResourceId;

    public static final Car[] cars = {
            new Car("Audi","niemiecki producent samochodów osobowych z siedzibą w Ingolstadt w Bawarii, należący do koncernu Volkswagen AG. Założony w 1909 roku przez Augusta Horcha. Nazwa przedsiębiorstwa wywodzi się z gry słów: Audi to łacińska transkrypcja nazwiska Horch (oznacza „słuchaj!”).",R.drawable.audi),
            new Car("Citroen","francuska marka samochodów osobowych, dostawczych i ciężarowych obecnie wraz z przedsiębiorstwem Peugeot tworząca koncern PSA. Przedsiębiorstwo założył inżynier André Gustave Citroën (5 lutego 1878 – 3 lipca 1935), który w czasie podróży przez Polskę nabył patent na sposób wytwarzania maszyny do obróbki kół zębatych daszkowych. Logo marki przedstawia właśnie zazębienie daszkowe.",R.drawable.citroen),
            new Car("Honda","japońskie przedsiębiorstwo produkujące samochody, motocykle, skutery, samoloty, silniki oraz różnego rodzaju maszyny do celów budowlanych, rolniczych i innych i zarazem największy producent silników na świecie na poziomie ponad 25 milionów rocznie. Przedsiębiorstwo posiada zakłady produkcyjne w ponad 30 różnych krajach. Główna siedziba znajduje się w dzielnicy Minato w Tokio, natomiast siedziba Honda Motor Europe Limited znajduje się w Slough w Wielkiej Brytanii, a Montesa Honda (jednostka zależna Hondy) ma siedzibę w Barcelonie w Hiszpanii.",R.drawable.honda),
            new Car("Kia","południowokoreańskie przedsiębiorstwo motoryzacyjne produkujące samochody osobowe, dostawcze oraz autobusy należące do Hyundai Motor Group.",R.drawable.kia),
            new Car("Mercedes-Benz","marka samochodów produkowanych przez koncern Daimler AG (uprzednio DaimlerChrysler AG, obecnie właścicielem koncernu są w prawie 70% przedsiębiorstwa i inwestorzy poza RFN)[1], zaś wcześniej przez koncern Daimler-Benz, popularnie nazywana Mercedes. Pod marką tą produkowane są samochody osobowe, dostawcze, ciężarowe i autobusy. W kategorii samochodów osobowych, Mercedes-Benz uważany jest za jedną z najstarszych.",R.drawable.mercedes),
            new Car("Nissan","japoński producent samochodów.",R.drawable.nissan),
            new Car("Opel","niemieckie przedsiębiorstwo zajmujące się produkcją pojazdów osobowych i dostawczych, założone 21 stycznia 1862 roku. Od 2017 roku właścicielem przedsiębiorstwa jest francuski koncern Groupe PSA",R.drawable.opel),
            new Car("Peugeot","francuska marka samochodów osobowych i dostawczych, a także rowerów, motocykli i skuterów, powstała w 1810 roku. Firmy Peugeot i Citroën tworzą koncern PSA.",R.drawable.peugeot),
            new Car("Seat","hiszpańskie przedsiębiorstwo z branży motoryzacyjnej produkujące samochody osobowe założone w 1950 roku. Obecnie przedsiębiorstwo jest własnością niemieckiego koncernu motoryzacyjnego Volkswagen AG.",R.drawable.seat),
            new Car("Skoda","czeskie przedsiębiorstwo motoryzacyjne produkujące samochody osobowe założone w 1895 roku. Od 1991 roku należy do Grupy Volkswagena.",R.drawable.skoda),
            new Car("Subaru","japońska marka produkująca samochody osobowe należąca w 16,5 % do koncernu Toyota Motor Corporation założona 15 lipca 1953 roku[1]. Nazwa Subaru oznacza w języku japońskim Plejady, które zostały umieszczone w logo firmy.",R.drawable.subaru),
            new Car("Toyota","japoński koncern motoryzacyjny utworzony w 1937 roku.",R.drawable.toyota),
            new Car("Volvo","szwedzkie przedsiębiorstwo produkujące samochody osobowe, będące częścią firmy Geely Automobile.",R.drawable.volvo)
    };

    public Car(String brand,String description,int imageResourceId){
        this.brand = brand;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getDescription(){
        return this.description;
    }

    public int getImageResourceId(){
        return this.imageResourceId;
    }

    @Override
    public String toString(){
        return this.brand;
    }
}
