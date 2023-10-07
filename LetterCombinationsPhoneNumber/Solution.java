package LeetCode.LetterCombinationsPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> cobi = new ArrayList<>();
        if (digits == "") {return cobi;}

        String[] letter = new String[10];
        letter[2] = "abc";
        letter[3] = "def";
        letter[4] = "ghi";
        letter[5] = "jkl";
        letter[6] = "mno";
        letter[7] = "pqrs";
        letter[8] = "tuv";
        letter[9] = "wxyz";
        backTrack(cobi, letter, digits, "", 0);

        return cobi;
    }

    public void backTrack(List<String> cobi, String[] letter, String digit, String ass, int p){
        int x = digit.charAt(p) - '0';
        for (char c : letter[x].toCharArray()){
            if (ass.length() == digit.length()-1){
                cobi.add(ass+c);
            }
            else {
                backTrack(cobi, letter, digit, ass+c, p+1);
            }
        }
    }
}
class Entry{
    public static void main(String[] args) {
        String digit = "2";
        System.out.println(new Solution().letterCombinations(digit));
    }
}