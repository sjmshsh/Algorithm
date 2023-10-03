// https://leetcode.cn/problems/reverse-linked-list/

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
    ListNode* reverseList(ListNode* head) {
        ListNode* temp = nullptr; // 保存cur的下一个节点，因为cur的指向要改变了
        ListNode* pre = nullptr;
        ListNode* cur = head;
        while (cur != nullptr) {
            temp = cur->next;
            cur->next = pre;
            // 迭代
            pre = cur;
            cur = temp;
        }
        return pre;
    }
};
