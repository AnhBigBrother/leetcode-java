package LeetCode.FloodFill;

import java.util.PriorityQueue;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int [][] image = {{0,0,0},{0,0,0}};
        System.out.println("before:");
        for (int i=0; i<image.length; i++){
            for (int j = 0 ;j<image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        int [][] ans = new Solution().floodFill(image, 1, 0, 2);
        System.out.println("after:");
        for (int i=0; i<ans.length; i++){
            for (int j = 0 ;j<ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color){return image;}
        int k = image[sr][sc];
        Queue <Integer> q = new PriorityQueue<Integer>();
        int n = image[0].length;//so cot
        int m = image.length;//so hang
        image[sr][sc] = color;
        q.add(sr*n + sc);
        while (q.size() > 0){
            int p = q.peek();
            q.remove();
            int x = p/n;
            int y = p%n;

            if (x-1>=0 && image[x-1][y] == k){image[x-1][y] = color;q.add((x-1)*n+y);}
            if (y-1>=0 && image[x][y-1] == k){image[x][y-1] = color;q.add(x*n+y-1);}
            if (x+1<m && image[x+1][y] == k){image[x+1][y] = color;q.add((x+1)*n+y);}
            if (y+1<n && image[x][y+1] == k){image[x][y+1] = color;q.add(x*n+y+1);}
        }

        return image;
    }
}
