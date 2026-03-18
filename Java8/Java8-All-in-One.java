/*
    Java 8 was a massive update that shifted Java from purely Object-Oriented to a more Functional style. Below is a comprehensive, single-file program that demonstrates every major feature including Lambdas, Streams, Method References, Grouping, Optional, and Default/Static Interface methods.

    Feature,Description
    Lambda Expressions,Anonymous functions that treat code as data.
    Method References,Shorthand syntax Class::method for calling existing methods.
    Stream API,"Declarative data processing (filter, map, reduce)."
    Collectors,Used for advanced reductions like groupingBy and partitioningBy.
    Optional,A container object which may or may not contain a non-null value.
    Default Methods,Allows adding new methods to interfaces without breaking implementing classes.
    Date/Time API,Immutable and thread-safe classes for handling dates and times.
    Parallel Streams,Process collections in parallel for performance on large datasets.
    Functional Interfaces,Interfaces with a single abstract method, used for lambda expressions.
    @FunctionalInterface,Annotation to indicate a functional interface.
    @Override,Annotation to indicate a method is overriding a parent method.
    Access Modifiers,private, public, protected for encapsulation.
    Interfaces vs Abstract Classes,Interfaces for pure abstraction, abstract classes for shared code.
    Polymorphism,Allows one interface to be used for a general class of actions.
    Inheritance,Allows a class to derive features from another.
    Encapsulation,Protects data from unauthorized access.
    Abstraction,Hides complexity; focuses on what instead of how.

*/

import java.util.*;
import java.util.stream.*;
import java.time.*;

// 1. Functional Interface (Single Abstract Method)
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
    
    // 2. Default Method in Interface
    default void log(String message) {
        System.out.println("LOG: " + message);
    }
    
    // 3. Static Method in Interface
    static void info() {
        System.out.println("This is a Functional Interface Demo.");
    }
}

public class Java8Masterclass {
    public static void main(String[] args) {
        
        // 4. Lambda Expressions
        Calculator add = (a, b) -> a + b;
        System.out.println("Lambda Add: " + add.operate(5, 3));
        add.log("Addition performed");

        // 5. Method References (System.out::println)
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        System.out.print("Method Reference Print: ");
        names.forEach(System.out::print); 
        System.out.println();

        // 6. Optional Class (Preventing NullPointerExceptions)
        Optional<String> checkNull = Optional.ofNullable(null);
        System.out.println("Optional Value: " + checkNull.orElse("Default Value"));

        // 7. Stream API (Filter, Map, Collect)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)      // Filter even numbers
                .map(n -> n * n)             // Square them
                .collect(Collectors.toList());
        System.out.println("Processed Stream: " + evenSquares);

        // 8. Grouping & Partitioning (Collectors)
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n > 5));
        System.out.println("Partitioned (>5): " + partitioned);

        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);

        // 9. New Date & Time API (java.time)
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date: " + today);
        System.out.println("Formatted Time: " + now.plusDays(1).getHour() + "h on tomorrow");

        // 10. Parallel Streams (For performance on large data)
        long count = numbers.parallelStream()
                .filter(n -> n > 5)
                .count();
        System.out.println("Parallel Stream Count (>5): " + count);
    }
}