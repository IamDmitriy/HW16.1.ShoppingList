package com.company.sort;

import com.company.Wish;

import java.util.Comparator;

public class PriorityWishComparator implements Comparator<Wish> {
    private SortingDirection sortingDirection;

    public PriorityWishComparator(SortingDirection sortingDirection) {
        this.sortingDirection = sortingDirection;
    }

    @Override
    public int compare(Wish o1, Wish o2) {
        int difference = o1.getPriority() - o2.getPriority();

        switch (sortingDirection) {
            case ASCENDING_SORT:
                return difference;
            case DESCENDING_SORT:
                return difference * (-1);
            default:
                return 0;
        }
    }
}