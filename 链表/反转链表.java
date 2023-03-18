// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

// https://leetcode.cn/problems/reverse-linked-list/

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
 // 翻转链表需要3个指针
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
            if (next != null) {
                next = next.next;
            }
        }
        return slow;
    }
}
