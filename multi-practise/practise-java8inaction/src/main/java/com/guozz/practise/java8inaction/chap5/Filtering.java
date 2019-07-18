package com.guozz.practise.java8inaction.chap5;

import com.google.common.collect.Lists;
import com.guozz.practise.java8inaction.chap4.Dish;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Filtering {

    public static void main(String[] args) {
        List<Dish>  vegetarians=  Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());

        vegetarians.forEach(System.out::println);

        //Filtering unique elements
        List<Integer> numbers=Lists.newArrayList(1,2,2,3,4,5,66,6,6);

        numbers.stream().filter(i->i%2 == 0).distinct().forEach(System.out::println);

        //truncating  a stream
        List<Dish> dishes3=Dish.menu.stream().filter(d->d.getCalories()>400).limit(3).collect(toList());
        dishes3.forEach(System.out::println);


        System.out.println("Skipping elements----------------");
        // Skipping elements
        List<Dish> dishesSkip2 =
                Dish.menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(toList());

        dishesSkip2.forEach(System.out::println);






    }
}
