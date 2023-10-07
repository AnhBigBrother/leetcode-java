package LeetCode.ClosestPointsToOrigin;

public class ClosestPointsToOrigin {
    public static void main(String[] args) {
        int [][] points = {{3,3}, {5,-1}, {-2,4}};
        int [][] ans = new Solution().kClosest(points, 2);
        for (int i=0; i<2; i++){
            System.out.println(ans[i][0] + "  " + ans[i][1]);
        }
    }
}
