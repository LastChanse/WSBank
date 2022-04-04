package com.example.kr1;

public class Сurrency {

    private String name; // наименовение валюты
    private String purchase;  // покупка
    private String sale; // продажа
    private String country; // название страны
    private int flagResource; // ресурс флага

    public Сurrency(String name, String purchase, String sale, String country) {

        this.name = name;
        this.purchase = purchase;
        this.sale = sale;
        this.country = country;
    }

    public Сurrency(String name, String purchase, String sale, String country, int flag) {

        this.name = name;
        this.purchase = purchase;
        this.sale = sale;
        this.country = country;
        this.flagResource = flag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurchase() {
        return this.purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public String getSale() {
        return this.sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}
