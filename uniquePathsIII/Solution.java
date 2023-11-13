public class Solution {
    int ans = 0;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Boolean [][] visited = new Boolean[m][n];
        int x = 0;
        int y = 0;
        int ban = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                visited[i][j] = false;
                if (grid[i][j] == -1){
                    ban ++;
                }
                if (grid[i][j] == 1){
                    x = i;
                    y = j;
                    grid[i][j] = -1;
                }
            }
        }
        backtrack(x, y, ban, grid, m, n, visited, 1);
        return ans;    
    }
    void backtrack (int x, int y, int ban, int[][] grid, int m, int n, Boolean[][] visited, int len){
        if (grid[x][y] == 2){
            if (len + ban == m*n){
                ans++;
            }
            return;
        }
        if (x-1 >= 0 && visited[x-1][y] == false && grid[x-1][y] != -1){
            visited[x-1][y] = true;
            backtrack(x-1, y, ban, grid, m, n, visited, len+1);
            visited[x-1][y] = false;
        }
        if (x + 1 < m && visited[x+1][y] == false && grid[x+1][y] != -1){
            visited[x+1][y] = true;
            backtrack(x+1, y, ban, grid, m, n, visited, len+1);
            visited[x+1][y] = false;
        }
        if (y - 1 >= 0 && visited[x][y-1] == false && grid[x][y-1] != -1){
            visited[x][y-1] = true;
            backtrack(x , y-1, ban, grid, m, n, visited, len+1);
            visited[x][y-1] = false;
        }
        if (y + 1 < n && visited[x][y+1] == false && grid[x][y+1] != -1){
            visited[x][y+1] = true;
            backtrack(x , y+1, ban, grid, m, n, visited, len+1);
            visited[x][y+1] = false;
        }
    }
}

class run {
    public static void main(String[] args) {
        int [][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println("answer of grid 1: ");
        System.out.println(new Solution().uniquePathsIII(grid));
        int [][] grid2 = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println("answer of grid 2: ");
        System.out.println(new Solution().uniquePathsIII(grid2));
    }
}