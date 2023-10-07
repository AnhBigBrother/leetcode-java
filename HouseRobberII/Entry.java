package LeetCode.HouseRobberII;

/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed. 
All houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, adjacent houses have a security system connected, 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.


 */

public class Entry {
    public static void main(String[] args) {
        int[] nums = {7,2,8,10,15,23,8,16,10,11};
        System.out.println(new Solution().rob(nums));
    }
}
