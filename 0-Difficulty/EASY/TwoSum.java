import java.util.HashMap;

public class TwoSum {

	/**
	 * Given an array of integers and a target value, return a pair of indices that
	 * add up to the target value. If no such pair exists, return an empty array.
	 * 
	 * Time complexity: O(n) Space complexity: O(n)
	 * 
	 * @param num    the array of integers
	 * @param target the target value
	 * @return a pair of indices that add up to the target value, or an empty array
	 *         if no such pair exists
	 */
	private static int[] twoSum(int num[], int target) {
		HashMap<Integer, Integer> seen = new HashMap<>(); // value --> index

		for (int i = 0; i < num.length; i++) {
			int complement = target - num[i];
			if (seen.containsKey(complement)) {
				return new int[] { seen.get(complement), i };
			}
			seen.put(num[i], i);
		}

		return new int[] {};
	}

	public static void main(String args[]) {

		int num[] = { 2, 17, 9, 7, 10, 11, 15 };
		int target = 9;

		int indices[] = twoSum(num, target);
		System.out.println(" Target Two Sum Indices are (" + indices[0] + "," + indices[1] + ")");

	}

}