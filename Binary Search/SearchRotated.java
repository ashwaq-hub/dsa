/**
 * Logic / Strategy : Find which half is sorted, then check range Time: O(log n)
 * Space: O(1)
 *
 * Strategy: Determine which half is sorted, then check if the target lies
 * within that range.
 */

class SearchRotated {

	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[l] <= nums[mid]) { // Left half is sorted
				if (target >= nums[l] && target < nums[mid])
					r = mid - 1;
				else
					l = mid + 1;
			} else { // Right half is sorted
				if (target > nums[mid] && target <= nums[r])
					l = mid + 1;
				else
					r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		SearchRotated sr = new SearchRotated();
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		System.out.println(sr.search(nums, target));
	}
}
