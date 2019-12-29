package com.company;

import com.company.sort.PriceWishComparator;
import com.company.sort.PriorityWishComparator;
import com.company.sort.SortingDirection;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static TreeSet<Wish> wishTreeSet;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        wishTreeSet = selectSortTree();

        addWishForExample();

        introduceWish();

        printWishList(wishTreeSet);

        while (true) {
            System.out.print("Для продолжения нажмите Enter, для выхода введите \"end\": ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Выход!");
                break;
            }

            TreeSet<Wish> wishTreeSetNew = selectSortTree();

            introduceWish();

            wishTreeSetNew.addAll(wishTreeSet);

            printWishList(wishTreeSetNew);
        }
    }

    private static void addWishForExample() {
        Wish[] wishes = new Wish[]{
                new Wish("Яндекс колонка", "Хороший звук!", 15_000, "http://1", 5),
                new Wish("iPhone", "Удобный телефон!", 40_000, "http://2", 3),
                new Wish("Джинсы", "Комфортные, синие", 3_000, "http://3", 4),
                new Wish("Наушники", "Высокое качество", 7_000, "http://5", 1),
                new Wish("Свитер", "Колется", 1_000, "http://5", 0),
                new Wish("Сноуборд", "Для зимних катаний", 1_000, "http://5", 2),
                new Wish("apple watch", "Занятие спортом и стиль", 30_000, "http://5",
                        2),
                new Wish("Спортивное питание", "Для поддержания формы", 2_000, "http://5",
                        3),
        };

        for (Wish wish : wishes) {
            wishTreeSet.add(wish);
        }

    }

    private static void printWishList(TreeSet<Wish> treeSet) {
        System.out.println("Ваш список:");
        for (Wish wish : treeSet) {
            System.out.println("    - " + wish);
        }
    }

    private static void introduceWish() {
        while (true) {
            System.out.println("Введите что бы вы хотели купить (введите пустую строку для выхода):");
            System.out.println("Название:");

            String input = scanner.nextLine();

            if ("".equals(input)) {
                System.out.println("Окончание ввода списка покупок!");
                break;
            }

            String name = input;

            System.out.println("Краткое описание:");
            String description = scanner.nextLine();

            double price;
            while (true) {
                System.out.println("Цена в рублях:");
                input = scanner.nextLine();

                if (stringIsDouble(input)) {
                    price = Double.parseDouble(input);
                    break;
                } else {
                    System.out.println("Введите число!");
                    continue;
                }
            }

            System.out.println("Ссылка:");
            String url = scanner.nextLine();

            int priority;
            while (true) {
                System.out.println("Приоритет (0 - не очень важно, 5 - очень важно):");
                input = scanner.nextLine();
                if (stringIsInteger(input)) {
                    priority = Integer.parseInt(input);

                    if (!(priority >= 0 && priority <= 5)) {
                        System.out.println("Укажите число от 0 до 5!");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Укажите число от 0 до 5!");
                    continue;
                }
            }

            Wish curWish = new Wish(name, description, price, url, priority);

            if (wishTreeSet.add(curWish)) {
                System.out.println("Добавлено!");
            }

        }
    }

    private static TreeSet<Wish> selectSortTree() {

        while (true) {
            System.out.println("1. Сортировка по убыванию цены");
            System.out.println("2. Сортировка по возрастанию цены");
            System.out.println("3. Сортировка по приоритету от самого важного");
            System.out.println("4. Сортировка по приоритету от низкого приоритета");
            System.out.println("Введите идентификатор сортировки:");
            String id = scanner.nextLine().trim();

            switch (id) {
                case "1":
                    return new TreeSet<>(new PriceWishComparator(SortingDirection.DESCENDING_SORT));
                case "2":
                    return new TreeSet<>(new PriceWishComparator(SortingDirection.ASCENDING_SORT));
                case "3":
                    return new TreeSet<>(new PriorityWishComparator(SortingDirection.DESCENDING_SORT));
                case "4":
                    return new TreeSet<>(new PriorityWishComparator(SortingDirection.ASCENDING_SORT));
                default:
                    System.out.println("Укажите один из вариантов");
            }
        }
    }

    private static boolean stringIsInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean stringIsDouble(String str) {
        if (stringIsInteger(str)) return true;

        if (!str.contains(".")) return false;

        String[] numbers = str.split("\\.");

        if (!(numbers.length == 2)) return false;

        return stringIsInteger(numbers[0]) && stringIsInteger(numbers[1]);

    }
}