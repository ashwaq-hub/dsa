/**
 * Logic / Strategy : Map closing to opening; Push/Pop Time: O(n) Space: O(n)
 * 
 * Strategy: Push expected closing brackets onto the stack.
 */

class ValidParentheses {

	/**
	 * Check if a given string contains valid parentheses.
	 * 
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The string is valid if: 1. Open brackets must be closed by the same type of
	 * brackets. 2. Open brackets must be closed in the correct order.
	 * 
	 * @param s the input string
	 * @return true if the string contains valid parentheses, false otherwise
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String args[]) {
		String s = "([{}])";
		System.out.println("Matching valid parentheses ? " + isValid(s));

		String s1 = "}])";
		System.out.println("Matching valid parentheses ? " + isValid(s1));
	}
}
