package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Такой команды сейчас нет. Введите 1, 2, или 3.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.saveDishes(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        if (dc.mapDishes.isEmpty()) {
            System.out.println("Список блюд пуст. Пожалуйста, добавьте хотя бы одно блюдо.");
            return;
        }

        System.out.print("Введите количество наборов, которые нужно сгенерировать: ");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        if (numberOfCombos <= 0) {
            System.out.println("Количество наборов должно быть больше 0");
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> types = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            types.add(nextItem);
            nextItem = scanner.nextLine();
        }

        dc.generationCombo(numberOfCombos, types);
    }
}