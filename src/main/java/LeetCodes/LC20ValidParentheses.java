package LeetCodes;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20ValidParentheses {
    class Solution {
        public boolean isValid(String s) {

            Map<Character, Character> signMap = new HashMap<>();
            signMap.put(')','(');
            signMap.put(']','[');
            signMap.put('}','{');

            char[] chars = s.toCharArray();

            Stack<Character> stack = new Stack<>();

            for(char c : chars){

                if(stack.isEmpty()){
                    stack.push(c);
                }else{
                    helper(c,signMap,stack);
                }
            }

            return stack.isEmpty()? true:false;
        }

        public void helper(Character c, Map<Character, Character> signMap, Stack<Character> stack){

            Character temp = signMap.get(c);
            if(stack.peek()==temp){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
    }
}
