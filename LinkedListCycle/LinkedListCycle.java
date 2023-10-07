package LeetCode.LinkedListCycle;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode p = new ListNode(0);
        p.next = head;
        p.next.next = new ListNode(2);
        ListNode x = new ListNode(0);
        x.next = p.next.next;
        p = p.next;
        p.next.next = new ListNode(3);
        p = p.next;
        p.next.next = new ListNode(4);
        p = p.next;
        p.next.next = x.next;
        System.out.println(new Solution().hasCycle(head));
    }
}
