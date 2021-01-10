package com.example.binusezyfood;

public class Food {


    private String name; private int price; private int imageResourceId;
    public static final Food[] foods = {
            new Food("Pizza", 123, R.drawable.air),
            new Food("Lasagna", 123, R.drawable.apel),
            new Food("Indomie", 123, R.drawable.mangga),
            new Food("Nasi Goreng", 123, R.drawable.alpukat)
    };

    private Food(String name, int price, int ImageResourceId) {
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
