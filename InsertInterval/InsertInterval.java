package LeetCode.InsertInterval;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] v = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int [][] ans = new Solution().insert(v, newInterval);
        for (int i=0; i<ans.length; i++){
            System.out.print(ans[i][0] + " " + ans[i][1]);
            System.out.println();
        }
    }
}
