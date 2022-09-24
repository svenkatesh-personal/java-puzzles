/*
Flatmap usage
- unique chars for a given list of words
- all pairs of numbers
 */

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class JP3 {
    public static void main(String[] args) {

        // Q1. How could you return a list of all the unique characters for a list of words?
        // For example, given the list of words ["Hello," "World"] you’d like to return the list ["H," "e," "l," "o," "W," "r," "d"].

        String[] words = {"Hello", "World"};

        Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        // Q2. Given two lists of numbers, how would you return all pairs of numbers? For example, given a list [1, 2, 3] and a list [3, 4]
        // you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two elements.

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1
                .stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(toList());

        System.out.println(Arrays.deepToString(pairs.toArray()));

    }
}

