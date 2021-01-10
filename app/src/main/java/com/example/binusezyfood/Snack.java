package com.example.binusezyfood;

public class Snack {


    private String name; private int price; private int imageResourceId;
    public static final Snack[] snacks = {
            new Snack("Bakwan Goreng", 123, R.drawable.air),
            new Snack("Tahu Goreng", 123, R.drawable.apel),
            new Snack("Tempe Goreng", 123, R.drawable.mangga),
            new Snack("Kulit Ayam", 123, R.drawable.alpukat)
    };

    private Snack(String name, int price, int ImageResourceId) {
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
