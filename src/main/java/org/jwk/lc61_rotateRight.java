package org.jwk;

public class lc61_rotateRight {
}

class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = findLength(head);
        k = k % len;
        if (k == 0)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newTail = slow;
        ListNode newHead = slow.next;
        fast.next = head;

        newTail.next = null;
        return newHead;
    }

    private int findLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}