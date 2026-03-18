/**
 * Logic / Strategy : Frequency map + contract until invalid Time: O(n + m)
 * Space: O(k)
 */
class MinWindowSubstr {
	/**
	 * Returns the minimum window substring of s that contains all characters of t.
	 * If no such window exists, returns an empty string.
	 * 
	 * Time complexity: O(n + m), where n is the length of s and m is the length of
	 * t. Space complexity: O(k), where k is the number of unique characters in t.
	 */
	public static String minWindowSubstr(String s, String t) {
		Map<Character, Integer> mapT = new HashMap<>();
		for (char c : t.toCharArray()) {
			mapT.put(c, mapT.getOrDefault(c, 0) + 1);
		}

		int left = 0, minLen = Integer.MAX_VALUE, formed = 0;
		Map<Character, Integer> mapS = new HashMap<>();
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			mapS.put(c, mapS.getOrDefault(c, 0) + 1);
			if (mapT.containsKey(c) && mapS.get(c) <= mapT.get(c)) {
				formed++;
			}
			while (left <= right && formed == t.length()) {
				c = s.charAt(left);
				if (mapT.containsKey(c) && mapS.get(c) <= mapT.get(c)) {
					formed--;
				}
				mapS.put(c, mapS.get(c) - 1);
				left++;
				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
				}
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(left - minLen, left);
	}

public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(minWindowSubstr(s, t)); // Output: "BANC"
}