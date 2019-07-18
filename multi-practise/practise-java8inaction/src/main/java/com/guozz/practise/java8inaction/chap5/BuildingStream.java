package com.guozz.practise.java8inaction.chap5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStream {

    public static void main(String[] args) throws IOException {
        //Stream.of
        Stream<String> stream=Stream.of("java 8","Lambdas","in","Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        //stream empty
        Stream<String> emptyStream=Stream.empty();

        //Arrays.Stream
        int [] numbers={1,2,3,4,5};
        int result = Arrays.stream(numbers).sum();
        System.out.println(result);
        System.out.println("----------");

        //Stream.iterate
        Stream.iterate(0,n->n+2).limit(10).forEach(System.out::println);


        // fibonnaci with iterate
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                . map(t -> t[0])
                .forEach(System.out::println);

        System.out.println("random stream of doubles with Stream.generate");
        // random stream of doubles with Stream.generate
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        // stream of 1s with Stream.generate
        System.out.println("stream of 1s with Stream.generate");
        IntStream.generate(()->1).limit(5).forEach(System.out::println);

        System.out.println("---------");
        IntStream.generate(new IntSupplier(){
            public int getAsInt(){
                return 2;
            }
        }).limit(5).forEach(System.out::println);

        System.out.println("-------------");


        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

        long uniqueWords = Files.lines(Paths.get("lambdasinaction/chap5/data.txt"), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();

        System.out.println("There are " + uniqueWords + " unique words in data.txt");





    }
}
