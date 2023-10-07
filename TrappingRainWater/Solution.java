package TrappingRainWater;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int S = 0;
        int top = 0;
        for (int i=0; i<n; i++){
            S += height[i];
            if (height[i] > height[top]){
                top = i;
            }
        }
        int topleft = 0;
        int topright = n-1;
        int S_left = 0;
        int S_right = 0;
        for (int i=1; i<=top; i++){
            if (height[i] >= height[topleft]){
                S_left += height[topleft]*(i-topleft);
                topleft = i;
            }
        }
        for (int i=n-2; i>=top; i--){
            if (height[i] >= height[topright]){
                S_right += height[topright]*(topright-i);
                topright = i;
            }
        }
        System.out.println("top = " + top);
        System.out.println("s left = " + S_left);
        System.out.println("s right = " + S_right);
        System.out.println("s = " + S);
        return S_left + S_right - S + height[top];
    }
}
class run{
    public static void main(String[] args) {
        int [] height = {2,0,2};
        System.out.println(new Solution().trap(height));
    }
}