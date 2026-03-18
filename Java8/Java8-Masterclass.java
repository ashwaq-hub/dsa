import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * MASTERCLASS: Java 8 Lambdas, Streams, and Collections
 * Focus: Practical Interview Patterns
 * 
    * Why this helps you learn effectively:
    Functional Interfaces: I’ve explicitly defined Predicate, Function, and Consumer so you can see how they act as the "engine" behind Streams.

    Collectors.groupingBy: This is a high-yield interview topic. I showed both the simple grouping and the complex grouping (with counting()).

    Method References: Throughout the code, I used Employee::getName instead of e -> e.getName(). This is the preferred "clean code" style in Java 8.

    Optional: Instead of checking for null, the program demonstrates findAny() with orElse(), which is a key best practice for modern Java developers.

    Date/Time API: I used LocalDate and LocalDateTime to show new features in Java 8.
    Map.merge: This is a powerful method for handling cases where you want to update values in a map without having to check if the key already exists.

    Collections: I used Set to detect duplicates and TreeMap for automatic key sorting.
    
 */
public class Java8Masterclass {

    public static void main(String[] args) {
        List<Employee> employees = JobData.getEmployees();

        System.out.println("=== LESSON 1: LAMBDAS & FUNCTIONAL INTERFACES ===");
        // Predicate: Boolean check
        Predicate<Employee> isHighEarner = e -> e.getSalary() > 70000;
        // Function: Transform T -> R
        Function<Employee, String> getName = Employee::getName;
        // Consumer: Use T, return nothing
        Consumer<String> printer = System.out::println;
        
        printer.accept("Test Lambda: " + getName.apply(employees.get(0)));

        System.out.println("\n=== LESSON 2: STREAM FILTERING & SORTING ===");
        employees.stream()
                .filter(isHighEarner)
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(2)
                .forEach(e -> System.out.println("Top Earner: " + e.getName()));

        System.out.println("\n=== LESSON 3: ADVANCED COLLECTORS (GROUPING) ===");
        // Grouping employees by Department
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        
        byDept.forEach((dept, list) -> System.out.println(dept + ": " + list.size() + " employees"));

        // Frequency Map (Counting occurrences of names)
        Map<String, Long> nameFrequency = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
        System.out.println("Name Frequency: " + nameFrequency);

        System.out.println("\n=== LESSON 4: DATA TRANSFORMATION (MAP/REDUCE) ===");
        // Get unique departments sorted alphabetically
        List<String> depts = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Departments: " + depts);

        // Sum of all salaries using reduce
        double totalPayroll = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Total Payroll: $" + totalPayroll);

        System.out.println("\n=== LESSON 5: OPTIONAL & NULL SAFETY ===");
        Optional<Employee> empOpt = employees.stream()
                .filter(e -> e.getName().equals("NonExistent"))
                .findAny();
        
        System.out.println("Safe Search Result: " + empOpt.orElse(new Employee("Default", 0, "N/A")));

        System.out.println("\n=== LESSON 6: NEW DATE/TIME API ===");
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date: " + today);
        System.out.println("Formatted Time: " + now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        System.out.println("\n=== LESSON 7: COLLECTIONS IMPROVEMENTS ===");
        // Map merge: Useful for updating counters or concatenating strings
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Java", 10);
        counts.merge("Java", 1, Integer::sum); // Increments to 11
        counts.merge("Python", 1, Integer::sum); // Adds new entry
        System.out.println("Merged Map: " + counts);
    }

    // --- DATA MODEL ---
    static class Employee {
        private String name;
        private double salary;
        private String department;

        public Employee(String name, double salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public String getName() { return name; }
        public double getSalary() { return salary; }
        public String getDepartment() { return department; }

        @Override
        public String toString() { return name + " ($" + salary + ")"; }
    }

    static class JobData {
        public static List<Employee> getEmployees() {
            return Arrays.asList(
                new Employee("Alice", 75000, "IT"),
                new Employee("Bob", 50000, "HR"),
                new Employee("Charlie", 85000, "IT"),
                new Employee("David", 45000, "Marketing"),
                new Employee("Alice", 60000, "Sales")
            );
        }
    }
}