public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int [][] hp = new int[m+1][n+1]; // hp[i][j] = hp need if start at position [i][j]
        for (int i=0; i<=m ; i++){
            for (int j=0; j<=n; j++){
                hp[i][j] = Integer.MAX_VALUE;
            }
        }
        hp[m-1][n] = 1;
        hp[m][n-1] = 1;
        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                int x = Integer.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j];
                hp[i][j] = x <= 0 ? 1 : x;
            }
        }
        return hp[0][0];
    }
}

class run {
    public static void main(String[] args) {
        int [][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new Solution().calculateMinimumHP(dungeon));
    }
}