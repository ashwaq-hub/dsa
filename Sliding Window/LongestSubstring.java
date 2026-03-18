/**
 * Logic / Strategy : Expand right, shrink left on repeat
 * Time: O(n)
 * Space: O(min(m,n))
 *
 * Strategy: Use a HashSet to track the window; move left to "shrink" until the window is valid again.
 * 
 */

class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String args[]){

    }
}
