import java.util.HashSet;

class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
         HashSet<Integer> set = new HashSet<>();
         for (int i : nums){
             if(set.contains(i)){
                return true;
             }
             set.add(i);
         }   
         return false;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println("Contains Duplicate! "+containsDuplicate(nums));

        int nums1[] = {1,1,1,3,3,4,3,2,4,2};
        System.out.println("Contains Duplicate! "+containsDuplicate(nums1));

        int nums2[] = {1,2,3,4,5};
        System.out.println("Contains Duplicate! "+containsDuplicate(nums2));
    }
}

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true

 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */