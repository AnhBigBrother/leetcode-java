package LeetCode.PrefixTree;

class TrieNode{
    char c;
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
    public TrieNode(){}
    public TrieNode(char c){
        this.c = c;
    }
}

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode t = root;
        for (Character x : word.toCharArray()){
            if (t.next[x-'a'] == null){
                t.next[x-'a'] = new TrieNode(x);
            }
            t = t.next[x-'a'];
        }
        t.isWord = true;
    }

    public boolean search(String word) {
        TrieNode t = root;
        for (Character x : word.toCharArray()){
            if (t.next[x-'a'] == null){return false;}
            t = t.next[x-'a'];
        }
        return t.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode t = root;
        for (Character x : prefix.toCharArray()){
            if (t.next[x-'a'] == null){return false;}
            t = t.next[x-'a'];
        }
        return true;
    }
}
