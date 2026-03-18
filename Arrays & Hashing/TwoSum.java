/**
 * Logic / Strategy : * HashMap to store (target - n)
 * Time: O(n)
 * Space: O(n)
 *
 * Strategy: One-pass with a HashMap to find the complement.
 */

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) return new int[] { map.get(diff), i };
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String args[]){
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,7,11,21,3};
        int target = 9
        twoSum.twoSum(nums.target);
    }
}

