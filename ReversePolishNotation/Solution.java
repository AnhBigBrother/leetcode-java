package LeetCode.ReversePolishNotation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> l = new ArrayList<Integer>();
        for (String s : tokens){
            if (s.equals("+") ){
                int y = l.remove(l.size()-1);
                int x = l.remove(l.size()-1);
                int k = x + y;
                l.add(k);
            }
            else if (s.equals("-")){
                int y = l.remove(l.size()-1);
                int x = l.remove(l.size()-1);
                int k = x - y;
                l.add(k);
            }
            else if (s.equals("*")){
                int y = l.remove(l.size()-1);
                int x = l.remove(l.size()-1);
                int k = x * y;
                l.add(k);
            }
            else if (s.equals("/")){
                int y = l.remove(l.size()-1);
                int x = l.remove(l.size()-1);
                int k = x / y;
                l.add(k);
            }
            else {
                l.add(Integer.parseInt(s));
            }
        }
        return l.get(0);
    }
}
