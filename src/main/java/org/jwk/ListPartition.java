package org.jwk;

public class ListPartition {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode result = partition(head, 3);
        while (result != null){
            System.out.println(result.val + " ");
            result = result.next;
        }
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode partition(ListNode head, int x){
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        ListNode current = head;
        while (current != null){
            if (current.val < x){
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }
        less.next = greaterHead.next;
        greater.next = null;

        return lessHead.next;
    }
}
