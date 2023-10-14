// https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?company_slug=bytedance

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
    ListNode* reverseKGroup(ListNode* head, int k) {
        // 定义哨兵位
        ListNode* dummy = new ListNode(0, head);
        ListNode* pre = dummy;
        ListNode* end = dummy;
        while (end != nullptr) {
            // 走k步
            for (int i = 0; end != nullptr && i < k; i++) {
                end = end->next;
            }
            // 长度不足k了
            if (end == nullptr) break; // 如果end为空, 代表以及到达了末尾, 说明题目已经完成
            ListNode* start = pre->next;
            ListNode* next = end->next;
            end->next = nullptr;
            pre->next = reverse(start);
            start->next = next;
            pre = start;

            end = pre;
        }
        return dummy->next;
    }

    // 首先得写一个链表翻转的函数
    ListNode* reverse(ListNode* head) {
        ListNode* pre = nullptr; // 前指针
        ListNode* cur = head; // 后指针
        while (cur != nullptr) {
            ListNode* next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
};
