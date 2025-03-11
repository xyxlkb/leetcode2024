package org.jwk;

import java.util.HashSet;
import java.util.Set;

public class lc160_getIntersectionNode {
}

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head = headA;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            set.add(head);
            head = head.next;
        }
        head = headB;
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}

