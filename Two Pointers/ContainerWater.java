/**
 * Logic / Strategy : Move pointer with the shorter height
 * Time: O(n)
 * Space: O(1)
 *
 * Strategy: Shrink the width while always moving the pointer pointing to the shorter line.
 */

class ContainerWater {

    public int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, area);
            if (height[l] < height[r]) l++; else r--;
        }
        return max;
    }

    public static void main(String args[]){
        
        ContainerWater ContainerWater = new ContainerWater();
        int[] height = {};
        ContainerWater.maxArea();
    }
}