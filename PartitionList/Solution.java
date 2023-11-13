public class Solution{
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode();
        ListNode last = new ListNode();
        ListNode l = new ListNode();
        ListNode f = new ListNode();
        f.next = first;
        l.next = last;
        while (head != null){
            if (head.val < x){
                f.next.next = head;
                f = f.next;
            }
            else {
                l.next.next = head;
                l = l.next;
            }
            head = head.next;
        }
        f.next.next = last.next;
        l.next.next = null;
        return first.next;
    }
}

class run {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(4);
        ListNode showAnswer = new Solution().partition(head, 3);
        while (showAnswer != null){
            System.out.print(showAnswer.val + " ");
            showAnswer = showAnswer.next;
        }
    }
}