
/**
 * Logic / Strategy : BFS to find shortest transformation
 * Time: O(n - m ** 2)
 * Space: O(n - m)
 */

import java.util.*;

public class WordLadder {

	/**
	 * Example usage of the WordLadder class.
	 *
	 * This example demonstrates how to find the length of the shortest
	 * transformation from the word "hit" to the word "cog" using a given list of
	 * words.
	 *
	 * @param args unused parameter
	 */
	public static void main(String args[]) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

	/**
	 * Finds the length of the shortest transformation from the given beginWord to
	 * the given endWord using a given list of words.
	 *
	 * @param beginWord the starting word
	 * @param endWord   the target word
	 * @param wordList  the list of words used for transformation
	 * @return the length of the shortest transformation, or 0 if no such
	 *         transformation exists
	 */

	public static int ladderLength(String beginWord, String endWord, String[] wordList) {
		Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
		if (!wordSet.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				if (word.equals(endWord)) {
					return level;
				}
				char[] chars = word.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char original = chars[j];
					for (char c = 'a'; c <= 'z'; c++) {
						chars[j] = c;
						String newWord = new String(chars);
						if (wordSet.contains(newWord)) {
							queue.add(newWord);
							wordSet.remove(newWord); // Avoid cycles
						}
					}
					chars[j] = original; // Backtrack
				}
			}
			level++;
		}
		return 0;
	}
}
