package LeetCode.MergeTwoSortedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution{
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l = new ListNode();
        ListNode head = new ListNode(0, l);
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                l.next = new ListNode(list1.val);
                l = l.next;
                list1 = list1.next;
            }
            else {
                l.next = new ListNode(list2.val);
                l = l.next;
                list2 = list2.next;
            }
        }
        if (list1 != null){
            l.next = list1;
        }
        if (list2 != null){
            l.next = list2;
        }
        return head.next.next;
    }
}
public class MergeTwoSortedList{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode list1 = new ListNode(0, l1);
        l1.next = new ListNode(2);l1 = l1.next;
        l1.next = new ListNode(4);
        list1 = list1.next;
        ListNode l2 = new ListNode(1);
        ListNode list2 = new ListNode(0, l2);
        l2.next = new ListNode(3);l2 = l2.next;
        l2.next = new ListNode(4);
        list2 = list2.next;

        ListNode head = Solution.mergeTwoLists(list1, list2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}