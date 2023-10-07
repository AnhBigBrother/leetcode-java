package LeetCode.LongestPalindromicSubstring;


public class Solution {
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int[] begin = new int[s.length()];
        for (int i=0; i<s.length(); i++){
            begin[i] = i;
            if (i-1 >= 0 && c[i] == c[i-1]){
                begin[i] = i-1;
            }
            if (i-2 >= 0 && c[i] == c[i-2]){
                begin[i] = i-2;
            }
            if (i-1 >= 0 && begin[i-1]-1 >= 0 && c[begin[i-1]-1] == c[i]){
                begin[i] = begin[i-1]-1;
            }
        }
        int start = 0;
        int end = 0;
        for (int i=0; i<s.length(); i++){
            System.out.println(begin[i] + " " + i);
            if (i - begin[i] > end - start){
                start = begin[i];
                end = i;
            }
        }
        String str1 = s.substring(start, end+1);
        String str2 = duplicateSubStr(s);
        return str1.length()>str2.length()?str1:str2;
    }
    String duplicateSubStr(String s){
        int [] begin = new int[s.length()];
        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) == s.charAt(i-1)){
                begin[i] = begin[i-1];
            }
            else {begin[i] = i;}
        }
        int start = 0;
        int end = 0;
        for (int i=0; i<s.length(); i++){
            if (i - begin[i] > end - start){
                start = begin[i];
                end = i;
            }
        }
        return s.substring(start, end+1);
    }
}
