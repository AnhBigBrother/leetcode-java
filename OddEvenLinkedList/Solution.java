package LeetCode.OddEvenLinkedList;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){return head;}
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode l3 = l2;
        while (l1.next != null && l2.next != null){
            if (l2.next != null){
                l1.next = l2.next;
                l1 = l1.next;
            }
            if (l1.next != null){
                l2.next = l1.next;
                l2 = l2.next;
            }
        }
        l2.next = null;
        l1.next = l3;
        return head;
    }
}
