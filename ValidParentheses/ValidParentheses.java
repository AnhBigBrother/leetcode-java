package LeetCode.ValidParentheses;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]";
        System.out.println(Solution.isValid(s));
    }
}
class Solution {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }
            else if (s.charAt(i) == '}'){
                if (st.empty() || st.peek() != '{'){return false;}
                else {st.pop();}
            }
            else if (s.charAt(i) == ']'){
                if (st.empty() || st.peek() != '['){return false;}
                else {st.pop();}
            }
            else {
                if (st.empty() || st.peek() != '('){return false;}
                else {st.pop();}
            }
        }
        if (st.empty()){return true;}
        return false;
    }
}
