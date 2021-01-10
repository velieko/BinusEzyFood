package com.example.binusezyfood;

public class Drink {


    private String name; private int price; private int imageResourceId;
    public static final Drink[] drinks = {
            new Drink("Air mineral", 123, R.drawable.air),
            new Drink("Jus Apel", 123, R.drawable.apel),
            new Drink("Jus Mangga", 123, R.drawable.mangga),
            new Drink("Just Alpukat", 123, R.drawable.alpukat)
    };

    private Drink(String name, int price, int ImageResourceId) {
        this.name = name;
        this.price = price;
        this.imageResourceId = ImageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
    public String toString() {
        String temp = this.name + "\n Price : "+ this.price;
        return temp;
    }
}
