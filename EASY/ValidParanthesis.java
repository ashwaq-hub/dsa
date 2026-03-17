import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

    public static void main(String args[]){
        String s = "({[]})";
        System.out.println(isValid(s));
        String s1 = "({[})";
        System.out.println(isValid(s1));
        String s2 = "()";
        System.out.println(isValid(s2));
    }

    public static boolean isValid(String s){
        HashMap<Character,Character> seen = new HashMap<>();
        seen.put(')','(');
        seen.put(']','[');
        seen.put('}','{');

        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(seen.containsKey(c)){
                if(stack.isEmpty() || stack.peek()!=seen.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return true;
    }
}