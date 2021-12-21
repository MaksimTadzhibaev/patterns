package ru.tadzh.adapter;

public class DishAdapter  implements Drinkable {

    private Dish dish;

    public DishAdapter (Dish dish){
        this.dish = dish;
    }

    @Override
    public void drink(){
        dish.eat();
    }
}
