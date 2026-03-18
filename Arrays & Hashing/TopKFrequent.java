
/**
 * Logic / Strategy : Bucket Sort or Min-Heap
 * Time: O(n)
 * Space: O(n)
 */

import java.util.*;

class TopKFrequent {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
		for (int num : map.keySet()) {
			pq.offer(num);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = pq.poll();
		}
		return result;
	}

	public static void main(String[] args) {
		TopKFrequent tkf = new TopKFrequent();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		System.out.println(Arrays.toString(tkf.topKFrequent(nums, k)));
	}
}
