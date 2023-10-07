package LeetCode.WordSearch;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String s : words){
            if (new check().exist(board, s) == true){
                ans.add(s);
            }
        }
        return ans;
    }
}
class check{
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0; j<n; j++){
                if (board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    DFS(board, word, visited, i, j, 1);
                    if (flag == true){return true;}
                    visited[i][j] = false;
                }
            }
        }
        return flag;
    }
    void DFS (char[][] board, String word, boolean[][] visited, int x, int y, int i){
        if (i == word.length()){
            flag = true;
            return;
        }
        int m = board.length;
        int n = board[0].length;
        if (x - 1 >= 0 && visited[x-1][y] == false && board[x-1][y] == word.charAt(i)){
            visited[x-1][y] = true;
            DFS(board, word, visited, x-1, y, i+1);
            visited[x-1][y] = false;
            if (flag == true){return;}
        }
        if (x + 1 < m && visited[x+1][y] == false && board[x+1][y] == word.charAt(i)){
            visited[x+1][y] = true;
            DFS(board, word, visited, x+1, y, i+1);
            visited[x+1][y] = false;
            if (flag == true){return;}
        }
        if (y - 1 >= 0 && visited[x][y-1] == false && board[x][y-1] == word.charAt(i)){
            visited[x][y-1] = true;
            DFS(board, word, visited, x, y-1, i+1);
            visited[x][y-1] = false;
            if (flag == true){return;}
        }
        if (y + 1 < n && visited[x][y+1] == false && board[x][y+1] == word.charAt(i)){
            visited[x][y+1] = true;
            DFS(board, word, visited, x, y+1, i+1);
            visited[x][y+1] = false;
            if (flag == true){return;}
        }
    }
}