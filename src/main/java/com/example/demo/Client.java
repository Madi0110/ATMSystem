package com.example.demo;

public class Client {
    private String name;
    private String surName;
    private String card;
    private String pin;
    private Double cash;

    public Client(String name, String surName, String card,String pin,Double cash) {
        this.name = name;
        this.surName = surName;
        this.card = card;
        this.pin = pin;
        this.cash = cash;

    }


    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }
    public String getName() {
        return name;
    }
}
