package LeetCode.MergeIntervals;


public class Entry {
    public static void main(String[] args) {
        int[][] a = {{4,5},{3,5},{5,6},{0,0},{2,2},{4,5},{2,2}};
        int[][] ans = new Solution().merge(a);
        for (int[] i : ans){
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
