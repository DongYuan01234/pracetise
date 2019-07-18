package com.guozz.practise.java8inaction.chap5;

import com.guozz.practise.java8inaction.chap4.Dish;

import java.util.Optional;

public class Finding {

    private static boolean isVegetarianFriendlyMenu(){
        return Dish.menu.stream().anyMatch(Dish::isVegetarian);
    }

    public static boolean isHealthMenu(){
        return Dish.menu.stream().allMatch(d->d.getCalories()<1000);
    }

    private static boolean isHealthyMenu2(){
        return Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish(){
        return Dish.menu.stream().filter(Dish::isVegetarian).findAny();
    }

    public static void main(String[] args) {
        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegetarian friendly");
        }
        System.out.println(isHealthMenu());
        System.out.println(isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

}
