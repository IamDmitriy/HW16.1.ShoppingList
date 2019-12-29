package com.company.sort;

public enum SortingDirection {
    DESCENDING_SORT("нисходящая сортировка"),
    ASCENDING_SORT("восходящая сортировка");

    private String name;

    SortingDirection(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\"" + name + "\"";
    }
}
