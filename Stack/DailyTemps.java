/**
 * Logic / Strategy : Monotonic Dec. Stack (store indices) Time: O(n) Space:
 * O(n)
 */

class DailyTemps {

	/**
	 * Given an array of integers representing daily temperatures, returns an array
	 * of integers representing the number of days you have to wait until a warmer
	 * temperature is recorded. If there is no future day for which this is
	 * possible, the integer should be 0 instead.
	 * 
	 * Logic/Strategy: Monotonic Dec. Stack (store indices) Time: O(n) Space: O(n)
	 * 
	 * @param T an array of integers representing daily temperatures
	 * @return an array of integers representing the number of days you have to wait
	 *         until a warmer temperature is recorded
	 */
	public int[] dailyTemperatures(int[] T) {
		int n = T.length;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int idx = stack.pop();
				res[idx] = i - idx;
			}
			stack.push(i);
		}
		return res;
	}

	public static void main(String args[]) {
		DailyTemps dt = new DailyTemps();
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] res = dt.dailyTemperatures(T);
		for (int r : res)
			System.out.print(r + " ");
	}
}
