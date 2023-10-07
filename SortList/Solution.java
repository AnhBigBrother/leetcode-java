package LeetCode.SortList;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            nums.add(p.val);
            p = p.next;
        }
        quicksort(nums, 0, nums.size()-1);
        ListNode k = head;
        int i=0;
        while (k != null){
            k.val = nums.get(i);
            i++;
            k = k.next;
        }
        return head;
    }
    public void quicksort(List<Integer> nums, int l, int r){
        int m = nums.get((l+r)/2);
        int i = l;
        int j = r;
        while (i < j){
            while (nums.get(i) < m){
                i++;
            }
            while (nums.get(j) > m){
                j--;
            }
            if (i <= j){
                int temp = nums.get(i);
                nums.set(i, nums.get(j));
                nums.set(j, temp);
                i++;
                j--;
            }
        }
        if (l < j){quicksort(nums, l, j);}
        if (i < r){quicksort(nums, i, r);}
    }
}
class Entry{
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(1, new ListNode(3, new ListNode(2))));
        ListNode p = new Solution().sortList(head);
        while (p!=null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}