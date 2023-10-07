package LeetCode.WordSearch;

import java.util.List;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.
 */

public class Entry {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> ans = new Solution().findWords(board, words);
        System.out.println(ans);
    }
}
