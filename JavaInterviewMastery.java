import java.util.*;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*

Key Concepts Covered:
Intermediate Operations: filter(), map(), sorted(), and distinct().

Terminal Operations: collect(), forEach(), sum(), and findFirst().

Collectors: Using groupingBy for frequency analysis and toMap with a merge function to handle collisions.

Date/Time API: Demonstrating the thread-safe LocalDateTime and DateTimeFormatter.

Collections: Using Set to detect duplicates and TreeMap for automatic key sorting.

*/
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

public class JavaInterviewMastery {

    public static void main(String[] args) {
        // --- 1. DATA INITIALIZATION ---
        List<Integer> nums = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 70000),
            new Employee("Bob", 50000),
            new Employee("Charlie", 80000),
            new Employee("Alice", 75000) // Duplicate name for testing
        );

        System.out.println("--- JAVA 8 STREAM API EXAMPLES ---");

        // --- 2. FINDING DUPLICATES (Using Set) ---
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = nums.stream()
                .filter(n -> !set.add(n))
                .collect(Collectors.toList());
        System.out.println("Duplicate elements: " + duplicates);

        // --- 3. FILTERING & MAPPING (Even numbers starting with '1') ---
        nums.stream()
                .filter(n -> n % 2 == 0)
                .map(String::valueOf)
                .filter(s -> s.startsWith("1"))
                .forEach(n -> System.out.println("Even starting with 1: " + n));

        // --- 4. MAX & MIN VALUES ---
        nums.stream().max(Integer::compare).ifPresent(max -> System.out.println("Max Value: " + max));

        // --- 5. REDUCE / SUMMING (Total Salary) ---
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total Salary of all employees: " + totalSalary);

        // --- 6. GROUPING & COUNTING (Character Frequency) ---
        String input = "JavaTechie";
        Map<Character, Long> charCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(java.util.function.Function.identity(), Collectors.counting()));
        System.out.println("Character frequency: " + charCount);

        // --- 7. CONVERT LIST TO MAP (Handling Duplicate Keys) ---
        Map<String, Double> employeeMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName, 
                        Employee::getSalary, 
                        (existing, replacement) -> existing // Keep the first occurrence
                ));
        System.out.println("Map of Unique Names: " + employeeMap);

        System.out.println("\n--- CORE JAVA & UTILS ---");

        // --- 8. DATE & TIME FORMATTING ---
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Formatted Date: " + now.format(formatter));

        // --- 9. TREE MAP (Internal Sorting Order) ---
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 1);
        treeMap.put("Apple", 10);
        treeMap.put("Mango", 5);
        System.out.println("TreeMap (Natural Order): " + treeMap);
    }
}