package LeetCode.ReverseLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        ListNode out = new Solution().reverseList(head);
        while (out != null){
            System.out.println(out.val);
            out = out.next;
        }
    }
}
