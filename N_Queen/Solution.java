package N_Queen;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        Boolean[][] b = new Boolean[4][18];
        for (int i=0; i<4; i++){
            for (int j=0; j<18; j++){
                b[i][j] = true;
            }
        }
        Character[][] grid = new Character[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = '.';
            }
        }
        backtrack(0, n, grid, ans, b, 0);
        return ans;
    }
    void backtrack(int p, int n, Character[][] grid, List<List<String>> ans, Boolean[][] b, int count){
        if (p == n*n){
            if (count == n){
                List<String> temp = new ArrayList<>();
                for (int i=0; i<n; i++){
                    String s = "";
                    for(int j=0; j<n; j++){
                        s += grid[i][j];
                    }
                    temp.add(s);
                }
                ans.add(temp);
            }
            return;
        }
        int x = p/n;
        int y = p%n;
        if (!(b[0][x] == false || b[1][y] == false || b[2][x-y+9] == false || b[3][x+y] == false)){
            grid[x][y] = 'Q';
            b[0][x] = false;
            b[1][y] = false;
            b[2][x-y+9] = false;
            b[3][x+y] = false;
            backtrack(p+1, n, grid, ans, b, count+1);
            b[0][x] = true;
            b[1][y] = true;
            b[2][x-y+9] = true;
            b[3][x+y] = true;
            grid[x][y] = '.';
        }
        backtrack(p+1, n, grid, ans, b, count);
    }
}
class run {
    public static void main(String[] args) {
        List<List<String>> ans = new Solution().solveNQueens(4);
        for (int i=0; i<ans.size(); i++){
            for (int j=0; j<ans.get(i).size(); j++){
                System.out.println(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}