/**
 * Logic / Strategy : Move pointer with the shorter height Time: O(n) Space:
 * O(1)
 *
 * Strategy: Shrink the width while always moving the pointer pointing to the
 * shorter line.
 */

class ContainerWater {

	/**
	 * Returns the maximum area of water that can be contained in a container given
	 * by the heights of its vertical bars.
	 * 
	 * Time complexity: O(n) Space complexity: O(1)
	 * 
	 * @param height array of heights of vertical bars
	 * @return maximum area of water that can be contained
	 */
	public int maxArea(int[] height) {
		int max = 0, l = 0, r = height.length - 1;
		while (l < r) {
			int area = Math.min(height[l], height[r]) * (r - l);
			max = Math.max(max, area);
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return max;
	}

	public static void main(String args[]) {
		ContainerWater ContainerWater = new ContainerWater();
		int[] height = {};
		ContainerWater.maxArea();
	}
}