package Combinations;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }
    void backtrack(List<List<Integer>> ans, List<Integer> list, int p, int n, int k){
        if (list.size() == k){
            ans.add(list);
            return;
        }
        for (int i=p; i<=n; i++){
            List<Integer> newlist = new ArrayList<>(list);
            newlist.add(i);
            backtrack(ans, newlist, i+1, n, k);
        }
    }
}
class run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        List<List<Integer>> ans = new Solution().combine(n, k);
        for (int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}