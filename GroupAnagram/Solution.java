package LeetCode.GroupAnagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i=0; i<strs.length; i++){
            int[] count = new int[26];
            for (char x : strs[i].toCharArray()){
                count[x-'a'] ++;
            }
            String key = "";
            for (int j=0; j<26; j++){
                while (count[j] > 0){
                    key += (char)j;
                    count[j] --;
                }
            }
            if (!hm.containsKey(key)){hm.put(key, new ArrayList<>());}
            hm.get(key).add(strs[i]);
        }
        
        return new ArrayList<>(hm.values());
    }
}
class Entry{
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}
