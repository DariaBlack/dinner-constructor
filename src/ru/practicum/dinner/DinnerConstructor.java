package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> mapDishes;
    Random random = new Random();

    DinnerConstructor() {
        mapDishes = new HashMap<>();
    }

    void saveDishes(String dishType, String dishName) {

        ArrayList<String> dishesNames = mapDishes.computeIfAbsent(dishType, k -> new ArrayList<>()); // Спасибо за наводку!

        if (!dishesNames.contains(dishName)) {
            dishesNames.add(dishName);
        }
    }

    void generationCombo(int number, ArrayList<String> types) {
        for (String type : types) {
            if (!mapDishes.containsKey(type)) {
                System.out.println("Несуществующий тип блюда: " + type + ". Введите другой.");
                return;
            }
        }

        for (int i = 0; i < number; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                ArrayList<String> dishesList = mapDishes.get(type);
                String randomDish = dishesList.get(random.nextInt(dishesList.size()));
                combo.add(randomDish);
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo);
        }
    }
}