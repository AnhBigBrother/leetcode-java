package LeetCode.ReverseLinkedList;

import java.util.*;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){return head;}
        Stack <ListNode> st = new Stack<ListNode>();
        while (head.next != null){
            st.push(head);
            head = head.next;
        }

        ListNode p = new ListNode();
        p.next = head;
        while (!st.empty()){
            p.next.next = st.peek();
            st.pop();
            p = p.next;
        }
        p.next.next = null;
        return head;
    }
}
