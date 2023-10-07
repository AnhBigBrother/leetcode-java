package LeetCode.StringtoInteger;

public class Solution {
    public int myAtoi(String s) {
        int isPossitive = 1;
        int l = 0;
        int i=0;
        int n=s.length();
        while (i<n && s.charAt(i) == ' '){
            i++;
        }
        if (s.charAt(i) == '+'){
            isPossitive = 1;
            i++;
        }
        else if (s.charAt(i) == '-'){
            isPossitive = -1;
            i++;
        }
        while (i < n){
            int digit = s.charAt(i) - '0';
            if(digit < 0 || digit > 9) {break;}
            if (Integer.MAX_VALUE/10 < l || (Integer.MAX_VALUE/10 == l && digit==7)){
                return isPossitive==1?Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            l = l*10 + digit;
        }
        return l*isPossitive;
    }
}
