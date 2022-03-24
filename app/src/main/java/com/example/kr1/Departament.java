package com.example.kr1;

public class Departament {
    private String address; // адресс отделения банка
    private String bank_type;  // тип банка
    private String if_it_ready; // работает ли банк
    private String hours_in_worck; // часы работы
    //private int flagResource; // ресурс флага

    public Departament(String address, String bank_type, String if_it_ready, String hours_in_worck) {

        this.address = address;
        this.bank_type = bank_type;
        this.if_it_ready = if_it_ready;
        this.hours_in_worck = hours_in_worck;
        //this.flagResource = flag; int
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBank_type() {
        return this.bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getIf_it_ready() {
        return this.if_it_ready;
    }

    public void setIf_it_ready(String if_it_ready) {
        this.if_it_ready = if_it_ready;
    }

    public String getHours_in_worck() {
        return this.hours_in_worck;
    }

    public void setHours_in_worck(String hours_in_worck) {
        this.hours_in_worck = hours_in_worck;
    }

    //public int getFlagResource() {
    //    return this.flagResource;
    //}

    //public void setFlagResource(int flagResource) {
    //    this.flagResource = flagResource;
    //}
}
