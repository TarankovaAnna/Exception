package ru.netology.domain;


public class Product {

    protected int id;
    protected String name;
    protected int price;


    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    protected int getId() {
        return id;
    }

    protected String getName() {
        return name;
    }

    //  protected int getPrice() {
    //      return price;
    //  }

    // public void setId(int id) {
    //      this.id = id;
    // }

    //   public void setName(String name) {
    //      this.name = name;
    //  }

    //  public void setPrice(int price) {
    //      this.price = price;
    //  }


}
