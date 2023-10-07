package LongestValidParentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Character> st = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int i = 0;
        int x = 0;
        while(i < s.length()){
            if (s.charAt(i) == '('){
                if (st.isEmpty()){
                    count.add(x);
                }
                st.add(s.charAt(i));
                i++;
            }
            else {
                if (st.isEmpty()){
                    x = 0;
                    i++;
                }
                else if (st.peek() == '('){
                    x += 2;
                    if (ans < x){ans = x;}
                    st.pop();
                    i++;
                }
                else if (st.peek() == ')'){
                    x = 0;
                    st.add(s.charAt(x));
                    i++;
                }
            }
        }
        return ans;
    }
}
class run{
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new Solution().longestValidParentheses(s));
    }
}