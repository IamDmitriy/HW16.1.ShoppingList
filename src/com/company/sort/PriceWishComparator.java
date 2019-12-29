package com.company.sort;

import com.company.Wish;

import java.util.Comparator;

public class PriceWishComparator implements Comparator<Wish> {
    private SortingDirection sortingDirection;

    public PriceWishComparator(SortingDirection sortingDirection) {
        this.sortingDirection = sortingDirection;
    }

    @Override
    public int compare(Wish o1, Wish o2) {
        int difference;

        double differenceDouble = o1.getPrice() - o2.getPrice();

        if (differenceDouble > 0) {
            difference = 1;
        } else if (differenceDouble < 0) {
            difference = -1;
        } else {
            return 0;
        }

        switch (sortingDirection) {
            case ASCENDING_SORT:
                return difference;
            case DESCENDING_SORT:
                return difference * (-1);
        }
        return 0;
    }


}
