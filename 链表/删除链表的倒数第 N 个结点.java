// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点

// 先来演示一种错误的做法：

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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // 快指针先走两部
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = fast;
        return head;
    }
}

// 这种做法会错误，原因是：我的题目是删除某一个节点，既然设计到删除，那么删除头节点和删除其他节点的处理逻辑不同的，直接处理不好，但是
// 分类讨论又非常复杂，所以我们应该使用虚拟头节点来做

// 正确方法如下：



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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个虚拟头节点
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode slow = node;
        ListNode fast = node;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        fast = fast.next;
        while (fast != null && slow != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }
}









