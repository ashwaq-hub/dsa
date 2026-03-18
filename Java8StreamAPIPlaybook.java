import java.util.*;
import java.util.stream.Collectors;

class Project {
    String name;
    public Project(String name) { this.name = name; }
    public String getName() { return name; }
}

class Employee {
    int id;
    String name;
    String department;
    double salary;
    String gender;
    List<Project> projects;

    public Employee(int id, String name, String dept, double sal, String gen, List<Project> projs) {
        this.id = id; this.name = name; this.department = dept; 
        this.salary = sal; this.gender = gen; this.projects = projs;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getGender() { return gender; }
    public List<Project> getProjects() { return projects; }
    @Override
    public String toString() { return "Employee{name='" + name + "', dept='" + department + "'}"; }
}

public class StreamPlaybook {
    public static void main(String[] args) {
        List<Employee> employees = getEmployees();

        // 1. FILTER & MAP: Get names of High-Paid Devs
        List<String> devNames = employees.stream()
                .filter(e -> "Development".equals(e.getDepartment()))
                .filter(e -> e.getSalary() > 80000)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("High Paid Devs: " + devNames);

        // 2. FLATMAP: Get all unique project names across the company
        List<String> allProjects = employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(Project::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Projects: " + allProjects);

        // 3. SORTING: Top 3 highest salaries
        List<Employee> top3 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3 Employees: " + top3);

        // 4. GROUPING: Count by Gender
        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Gender Distribution: " + genderCount);

        // 5. MIN/MAX: Lowest Paid Employee
        employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(e -> System.out.println("Lowest Salary: " + e.getName() + " ($" + e.getSalary() + ")"));

        // 6. FIND FIRST: Any female in HR?
        employees.stream()
                .filter(e -> "Female".equals(e.getGender()) && "HR".equals(e.getDepartment()))
                .findFirst()
                .ifPresent(e -> System.out.println("First Female in HR: " + e.getName()));
    }

    private static List<Employee> getEmployees() {
        Project p1 = new Project("Alpha"), p2 = new Project("Beta"), p3 = new Project("Gamma");
        return Arrays.asList(
            new Employee(1, "Suraj", "Development", 95000, "Male", Arrays.asList(p1, p2)),
            new Employee(2, "Sophia", "Development", 82000, "Female", Arrays.asList(p2)),
            new Employee(3, "John", "HR", 60000, "Male", Arrays.asList(p1)),
            new Employee(4, "Emma", "HR", 65000, "Female", Arrays.asList(p3)),
            new Employee(5, "Raj", "Sales", 70000, "Male", Arrays.asList(p1, p3))
        );
    }
}

/*
[
  {
    "method": "filter",
    "purpose": "Conditional check",
    "why_use_it": "Replaces bulky if-else blocks inside loops; evaluates a Predicate to include/exclude elements."
  },
  {
    "method": "map",
    "purpose": "Data transformation",
    "why_use_it": "Executes a 1:1 transformation; extracts a specific field (e.g., getName) from an object stream."
  },
  {
    "method": "flatMap",
    "purpose": "Flattening nested structures",
    "why_use_it": "Handles 1:Many relationships; flattens a Stream<List<X>> into a Stream<X>. Essential for deep JSON structures."
  },
  {
    "method": "collect",
    "purpose": "Termination and conversion",
    "why_use_it": "The terminal operation that packages the stream results back into a List, Set, or Map."
  },
  {
    "method": "Optional",
    "purpose": "Null-safety wrapper",
    "why_use_it": "Returned by findFirst or max; forces the developer to handle the 'value not found' case safely."
  },
  {
    "method": "groupingBy",
    "purpose": "Data classification",
    "why_use_it": "Aggregates data into a Map based on a specific classifier (like SQL GROUP BY)."
  }
]
  
*/