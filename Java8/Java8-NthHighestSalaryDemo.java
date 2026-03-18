/*


    Gemini said
    This video from Java Techie focuses on a popular interview question: Finding the Nth highest salary using the Java 8 Streams API. It highlights a common pitfall where simple sorting fails if there are duplicate salaries, and provides a robust, generic solution.

    The Problem & The Pitfall
    Simple Approach: Sort the map by value in descending order and pick the element at index (n-1).

    The Drawback: If multiple employees share the same salary (e.g., three people earning $1,200), the simple approach will treat each entry as a unique rank. This results in incorrect "Nth" rankings when there are duplicates [08:52].

    The Robust Solution: Grouping by Salary
    To correctly find the Nth highest salary, you must group employees by their salary amount first. This ensures that a specific salary level represents a single "rank," regardless of how many employees earn it.

    The Steps:

    Group by Salary
    Sort the groups by Salary in Descending Order
    Convert to list and pick the Nth element

    Key Steps Explained:
    groupingBy(Map.Entry::getValue, ...): Groups the data so the salary becomes the key.

    Collectors.mapping(Map.Entry::getKey, ...): Instead of storing the whole Entry object in the list, we only store the employee names [12:02].

    comparingByKey() with reverseOrder(): Since the keys in our new intermediate map are the salaries, we sort them from highest to lowest [14:18].

    get(n - 1): Retrieves the specific rank requested by the user.


    Comparison of Approaches
    
    | Feature            | Simple Sorting    |   Grouping Approach (Recommended)    |
    | LogicSorts         | entries directly. |   Groups by value then sorts groups. |
    | Duplicate Handling | Fails; treats same salaries as different ranks. | Correctly treats same salaries as one rank. |
    | OutputSingle       | Name/Salary entry. | List of Names for that Salary rank. |
    | Flexibility        | Less flexible; assumes unique salaries. | More flexible; works with duplicates and can easily be adapted for other ranking problems. |

*/

import java.util.*;
import java.util.stream.Collectors;

public class Java8NthHighestSalaryDemo {

    public static void main(String[] args) {
        // Sample Input with duplicate salaries
        Map<String, Integer> map = new HashMap<>();
        map.put("Ankit", 1200);
        map.put("Bhavna", 1200);
        map.put("James", 1200);
        map.put("Tom", 1300);
        map.put("Daniel", 1300);
        map.put("Micael", 1000);

        // Find 2nd Highest Salary
        Map.Entry<Integer, List<String>> result = getNthHighestSalary(2, map);
        System.out.println("2nd Highest Salary Rank: " + result); [00:16:59]
    }

    public static Map.Entry<Integer, List<String>> getNthHighestSalary(int n, Map<String, Integer> map) {
        return map.entrySet().stream()
                // 1. Group by Salary (Value), and Map only the Names (Keys) into a List
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue, 
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ))
                .entrySet().stream()
                // 2. Sort the groups by Salary (Key of the new map) in Descending Order
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                // 3. Convert to list and pick the Nth element (index n-1)
                .collect(Collectors.toList())
                .get(n - 1); [00:16:32]
    }
}