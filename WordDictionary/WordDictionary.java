package LeetCode.WordDictionary;

import java.util.ArrayList;
import java.util.List;

class WordDictionary {
    List<String> l;
    public WordDictionary() {
        l = new ArrayList<>();
    }
    
    public void addWord(String word) {
        l.add(word);
    }
    
    public boolean search(String word) {
        for (int i=0; i<l.size(); i++){
            if (check(l.get(i), word)){return true;}
        }
        return false;
    }
    private boolean check(String s1, String s2){
        if (s1.length() != s2.length()){return false;}
        for (int i=0; i<s1.length(); i++){
            if (s2.charAt(i) != '.' && s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}