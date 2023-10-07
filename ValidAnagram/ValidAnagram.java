package LeetCode.ValidAnagram;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(Solution.isAnagram(s, t));

    }
}
class Solution {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){return false;}
        HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++){
            m1.put(s.charAt(i), 0);
        }
        System.out.println("before");
        for (int i=0; i<s.length(); i++){
            int temp1 = m1.get(s.charAt(i)) + 1;
            m1.put(s.charAt(i), temp1);
            System.out.println(s.charAt(i) + " " + m1.get(s.charAt(i)));
        }
        System.out.println("process");
        for (int i=0; i<t.length(); i++){
            if (m1.containsKey(t.charAt(i)) == false) {return false;}
            else {
                int temp1 = m1.get(t.charAt(i)) - 1;
                m1.put(t.charAt(i), temp1);
            }
            System.out.println(t.charAt(i) + " " + m1.get(t.charAt(i)));
        }
        System.out.println("after");
        for (int i=0; i<t.length(); i++){
            if (m1.get(s.charAt(i)) != 0){return false;}
            System.out.println(s.charAt(i) + " " + m1.get(s.charAt(i)));
        }
        return true;
    }
}
