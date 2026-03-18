/**
 * Logic / Strategy : Map closing to opening; Push/Pop
 * Time: O(n)
 * Space: O(n)
 * 
 * Strategy: Push expected closing brackets onto the stack.
 */

class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String args[]){
        String s = "([{}])";
        System.out.println("Matching valid parentheses ? "+isValid(s));
        
        String s1 = "}])";
        System.out.println("Matching valid parentheses ? "+isValid(s1));
    }
}
