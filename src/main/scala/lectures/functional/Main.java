package com.globant.udemy.course.scala_essentials.lectures.functional;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Character> characters = List.of('a', 'b');

        List<String> test = numbers.stream()
                .flatMap(n ->
                        characters.stream()
                                .map(c -> "" + n + c)
                )
                .toList();
        System.out.println(numbers);
        System.out.println(characters);
        System.out.println(test);
    }
}
