package ru.tadzh.adapter;

public class Main {
        public static void main(String[] args) {
            Dish dish = new Dish();
            DishAdapter dishAdapter = new DishAdapter(dish);
            Man man = new Man();
            man.breakfast(dishAdapter);
        }
    }
