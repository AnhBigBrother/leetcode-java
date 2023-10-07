package LeetCode.LinkedListCycle;


public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {return false;}
        ListNode walker = head;
        ListNode runner = head.next;
        while (runner != null){
            if (runner.next == null) {return false;}
            if (walker == runner){return true;}
            else {
                walker = walker.next;
                runner = runner.next.next;
            }
        }
        return false;
    }
}
