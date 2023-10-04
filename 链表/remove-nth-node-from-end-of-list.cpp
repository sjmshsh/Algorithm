// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 链表题目，遇事不决哨兵位即可
        ListNode* dum = new ListNode(-1, head);
        ListNode* fast = dum;
        ListNode* slow = dum;
        while (n-- && fast != nullptr) {
            fast = fast->next;
        }
        // 让fast再多走一步，目的是让slow在倒数第n个节点的上一个位置
        fast = fast->next;
        while (fast != nullptr) {
            fast = fast->next;
            slow = slow->next;
        }
        // 删除即可
        slow->next = slow->next->next;
        // 返回头结点
        return dum->next;
    }
};
