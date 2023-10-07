package AddTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode p = l;
        int rem = 0;
        while (!(l1 == null && l2 == null)){
            int x1 = 0;
            int x2 = 0;
            if (l1 != null) {x1 = l1.val;}
            if (l2 != null) {x2 = l2.val;}
            int x = x1 + x2 + rem;
            if (x < 10){
                l.next = new ListNode(x);
                rem = 0;
            }
            else {
                l.next = new ListNode(x % 10);
                rem = 1;
            }
            if (l1 != null){l1 = l1.next;}
            if (l2 != null){l2 = l2.next;}
            l = l.next;
        }
        if (rem == 1){l.next = new ListNode(rem);}
        return p.next;
    }
}
class Entry{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l = new Solution().addTwoNumbers(l1, l2);
        while (l != null){
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}