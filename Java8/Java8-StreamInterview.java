import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    Breakdown of Programs Explained:
    Character Counting: Uses Collectors.groupingBy with Function.identity() and Collectors.counting() to map each character to its frequency [07:07].

    Duplicates vs. Unique: Extends the counting logic by filtering the entrySet based on whether the count is > 1 (duplicates) or == 1 (unique) [12:26].

    First Non-Repeat Character: Crucially uses a LinkedHashMap within groupingBy to preserve the insertion order, as a standard HashMap does not guarantee order [19:58].

    Second Highest Number: Demonstrates sorting an array in reverse order, skipping the first element, and then grabbing the new first element (which is the second overall) [25:43].

    Longest String: Uses the reduce method (Map-Reduce concept) to compare string lengths and return the largest one [30:28].

    Filtering by Prefix: Converts integers to strings and uses the .startsWith() method within a filter [35:11].

    Skip and Limit: Useful for scenarios like skipping headers in a CSV file or pagination [40:02].
*/
public class Java8StreamInterview {

    public static void main(String[] args) {
        String input = "ilovejavatechie";
        int[] numbers = {5, 9, 11, 2, 8, 21, 1, 29};
        String[] words = {"java", "techie", "spring boot", "microservices", "docker", "amazon web service"};

        // 1. Character Occurrence
        System.out.println("--- Character Occurrence ---");
        Map<String, Long> charCount = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCount); [00:07:07]

        // 2. Find All Duplicate Elements
        System.out.println("\n--- Duplicate Elements ---");
        List<String> duplicates = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicates); [00:12:26]

        // 3. Find Unique Elements
        System.out.println("\n--- Unique Elements ---");
        List<String> unique = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(unique); [00:14:16]

        // 4. First Non-Repeat Element (Using LinkedHashMap to preserve order)
        System.out.println("\n--- First Non-Repeat Element ---");
        String firstNonRepeat = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .findFirst()
                .get().getKey();
        System.out.println("First Non-Repeat: " + firstNonRepeat); [00:19:58]

        // 5. Second Highest Number from Array
        System.out.println("\n--- Second Highest Number ---");
        Integer secondHighest = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Second Highest: " + secondHighest); [00:25:43]

        // 6. Longest String from Array
        System.out.println("\n--- Longest String ---");
        String longestString = Arrays.stream(words)
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();
        System.out.println("Longest: " + longestString); [00:30:28]

        // 7. Find Elements Starting with '1' (or '2')
        System.out.println("\n--- Elements Starting with '2' ---");
        List<String> startsWithTwo = Arrays.stream(numbers)
                .boxed()
                .map(s -> s + "") // Convert to string
                .filter(s -> s.startsWith("2"))
                .collect(Collectors.toList());
        System.out.println(startsWithTwo); [00:35:11]

        // 8. String Join Example
        System.out.println("\n--- String Join ---");
        List<String> list = Arrays.asList("1", "2", "3", "4");
        String joined = String.join("-", list);
        System.out.println("Joined: " + joined); [00:37:47]

        // 9. Skip and Limit (Print 2 to 9)
        System.out.println("\n--- Skip and Limit (2 to 9) ---");
        IntStream.rangeClosed(1, 10)
                .skip(1)
                .limit(8)
                .forEach(System.out::print); [00:40:02]
    }
}