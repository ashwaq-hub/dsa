/**
 * Logic / Strategy : Two Heaps (Max-Heap & Min-Heap) Time: O(log n) Space: O(n)
 */
public class MedianFinder {
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public double findMedian(int[] nums) {
		for (int num : nums) {
			if (maxHeap.isEmpty() || num < maxHeap.peek()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.add(maxHeap.poll());
			} else if (minHeap.size() > maxHeap.size()) {
				maxHeap.add(minHeap.poll());
			}
		}
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}

	public static void main(String args[]) {
		MedianFinder mf = new MedianFinder();
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(mf.findMedian(nums));
	}
}
