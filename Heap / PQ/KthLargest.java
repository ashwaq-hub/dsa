/**
 * Logic / Strategy : Min-Heap of size $k$
 * Time: O(n log k)
 * Space: O(k)
 * 
 * Strategy: Keep a Min-Heap of size $K$. The root will be the $K^{th}$ largest.
 */

class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String args[]){
        
    }
}
