package LeetCode.ValidPalindrome;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(Solution.isPalindrome(s));
    }
}
class Solution {
    public static boolean isPalindrome(String s) {
        String in = "";
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                in = in + (char)(s.charAt(i) + 32);
            }
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                in = in + (char)(s.charAt(i));
            }
            else if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9'){
                in = in + (char)(s.charAt(i));
            }
        }
        System.out.println(in);
        int l = 0;
        int r = in.length()-1;
        while (l < r){
            if (in.charAt(l) != in.charAt(r)){return false;}
            l++;
            r--;
        }
        return true;
    }
}