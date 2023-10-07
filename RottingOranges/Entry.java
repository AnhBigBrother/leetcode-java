package LeetCode.RottingOranges;

public class Entry {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,2},
                          {0,0,1,1},
                          {0,1,1,1},
                          {1,1,1,1}};
        System.out.println(new Solution().orangesRotting(matrix));
    }
}
