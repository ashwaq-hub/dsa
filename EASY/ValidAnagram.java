import java.util.Arrays;
/*
Valid Anagram
Given two strings s and t .
Base Case: compare the length of both strings s and t . If they are not equal then return false.
Sort the characters of both the strings.
Compare the sorted strings. If they are equal, then the two strings are anagrams of each other. Otherwise, they are not.
*/


class ValidAnagram {

    private static boolean isValidAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }

    public static void main(String[] args) {
       String s = "anagram", t = "nagaram";
       System.out.println("isValid Anagram? "+isValidAnagram(s,t));

       String p = "rat", q = "car";
       System.out.println("isValid Anagram? "+isValidAnagram(p,q));
    }

}


/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */