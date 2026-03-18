/**
 * Logic / Strategy : Sort array + Fixed element + Two Pointers Time: O(n ** 2)
 * Space: O(n) or O(1)
 */

class ThreeSum {
	/**
	 * Given an array of integers, return a list of lists, where each inner list
	 * contains three distinct integers that sum up to zero. The outer list is
	 * ordered by the values of the inner lists, from smallest to largest. The inner
	 * lists are ordered from smallest to largest. If no such triplets exist, an
	 * empty list is returned.
	 * 
	 * Time complexity: O(n ** 2), where n is the length of the input array. Space
	 * complexity: O(n) or O(1), depending on whether the input array is modified in
	 * place or not.
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue; // Skip duplicate fixed elements
			}
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++; // Skip duplicate left elements
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--; // Skip duplicate right elements
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		ThreeSum ts = new ThreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(ts.threeSum(nums));
	}
}