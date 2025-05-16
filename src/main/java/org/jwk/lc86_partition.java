package org.jwk;

public class lc86_partition {
}

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummyLeft = new ListNode();
        ListNode curLeft = dummyLeft;
        ListNode dummyRight = new ListNode();
        ListNode curRight = dummyRight;
        ListNode curNode = head;


        while (curNode != null) {
            if (curNode.val < x) {
                curLeft.next = curNode;
                curLeft = curLeft.next;
            } else {
                curRight.next = curNode;
                curRight = curRight.next;
            }
            curNode = curNode.next;
        }

        curLeft.next = dummyRight.next;
        curRight.next = null;
        return dummyLeft.next;
    }
}