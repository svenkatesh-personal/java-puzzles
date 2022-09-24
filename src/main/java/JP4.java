/*
Stream usage
- statistics
- lambda usage
 */
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class JP4 {
    public static void main(String[] args) {

        int[] numbers = {1, 32, 0, 22, 3, 3, 4};

        // sum
        int sum = IntStream.of(numbers)
                .distinct()
                .sum();
        System.out.println("Sum " + sum);

        // min
        IntStream.of(numbers).min().ifPresent(num -> System.out.println("Min " + num));

        // statistics
        System.out.println("\nMax, Min, Avg via IntSummaryStatistics");
        IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());

        // distinct, sorted, first 3
        System.out.println("\nPrint Distinct, Sorted, First 3");
        IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);
        // IntStream.of(numbers).map(n -> n * 2).forEach(System.out::println);
    }
}
