/**
 * Logic / Strategy : Binary search on the result range Time: O(n log m) Space:
 * O(1)
 */

class KokoEating {

	/**
	 * kokoEating(int k, int m, int[] stalls) : This method takes in three
	 * parameters: k (the number of bananas Koko can eat in one minute), m (the
	 * minimum number of minutes Koko needs to eat all the bananas), and stalls (an
	 * array of integers representing the number of bananas in each stall). The
	 * method uses binary search to find the minimum number of minutes it takes for
	 * Koko to eat all the bananas. It iteratively calculates the sum of the minimum
	 * number of bananas Koko can eat in one minute at each stall, and adjusts the
	 * left and right boundaries of the search range based on whether the sum is
	 * greater than or equal to m. The method returns the minimum number of minutes
	 * it takes for Koko to eat all the bananas.
	 */
	public static int kokoEating(int k, int m, int[] stalls) {
		int left = 0, right = m;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int sum = 0;
			for (int stall : stalls) {
				sum += Math.min(stall, mid) / k;
			}
			if (sum >= m) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String args[]) {
		int k = 3;
		int m = 6;
		int[] stalls = { 1, 2, 3 };
		System.out.println(kokoEating(k, m, stalls));
	}
}
