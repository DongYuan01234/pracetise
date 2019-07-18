package com.guozz.practise.java8inaction.chap4;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter to return only low calorie dishes
 */
public class StreamBasic {

    public static void main(String[] args) {
        getLowerCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
        System.out.println("-----华丽丽的分割线------");
        getLowerCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);;
    }

    private static List<String> getLowerCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.stream().filter(d->d.getCalories()<400).sorted(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        }).map(Dish::getName).collect(Collectors.toList());
    }


    public static List<String> getLowerCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowerCaloriesDish=Lists.newArrayList();
        for(Dish dish : dishes){
            if(dish.getCalories()<400){
                lowerCaloriesDish.add(dish);
            }
        }

        lowerCaloriesDish.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });

        List<String> lowerCaloriDishNames=Lists.newArrayList();

        for(Dish lDish:lowerCaloriesDish){
            lowerCaloriDishNames.add(lDish.getName());
        }
        return lowerCaloriDishNames;
    }


}
