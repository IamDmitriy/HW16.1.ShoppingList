package com.company;

public class Wish {
    private String name;
    private String description;
    private double price;
    private String url;
    private int priority;

    public Wish(String name, String description, double price, String url, int priority) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.url = url;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public int getPriority() {
        return priority;
    }
}
