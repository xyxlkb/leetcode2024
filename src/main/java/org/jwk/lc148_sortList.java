package org.jwk;

// 链表排序，二分法
public class lc148_sortList {
    public static void main(String[] args) {
        Solution148 so = new Solution148();
        // 创建一个未排序的链表
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("原链表：");
        so.printList(head);

        // 对链表进行排序
        head = so.sortList(head);

        System.out.println("排序后的链表：");
        so.printList(head);
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution148 {
    public ListNode sortList(ListNode head) {
        // 如果链表为空或只有一个元素，则不需要排序，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针法找到链表的中间节点
        ListNode mid = getMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null;

        // 递归地排序左右两半
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // 合并排序后的两半
        return merge(left, right);
    }

    // 获取链表的中间节点
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个已排序的链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); //虚拟头节点
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }

    // 打印链表
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
