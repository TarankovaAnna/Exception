package ru.netology.domain;

public class Smartphone extends Product {


    private String maker;

    // protected String getMaker() {
    //     return maker;
    //  }

    // public void setMaker(String maker) {
    //     this.maker = maker;
    //  }

    protected Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);

        this.maker = maker;
    }
}
