import java.util.HashMap;

public class SlidingWindowMaxLen {

    public static void main(String args[]) {
        int num[] = { 1, 2, 3, 4, 5 };
        int k = 3;
        System.out.println(maxLen(num, k));
    }

    private static int maxLen(int num[], int k){
        int left = 0, right = num.length-1, maxLen = 0;

        while(left <= right){
            int sum = num[left]+num[right];
            if(sum == k){
                maxLen = Math.max(sum, maxLen);
                left++;
                right--;
            }
            else if(sum < k){
                left++;
            }else{
                right--;
            }
        }
        return maxLen;
    }
   
}