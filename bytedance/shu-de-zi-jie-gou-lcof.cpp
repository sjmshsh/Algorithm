/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSubStructure(TreeNode* A, TreeNode* B) {
        if (B == nullptr) return false;
        if (A == nullptr) return false;

        if (compare(A, B)) {
            return true;
        }

        return isSubStructure(A->left, B) || isSubStructure(A->right, B);
    }

    bool compare(TreeNode* A, TreeNode* B) {
        // 如果B已经遍历完成了, 那么就返回true了
        if (B == nullptr) {
            return true;
        }
    
        if (A == nullptr) {
            // A已经遍历完了，但是B还没有遍历完
            return false;
        }

        if (A->val != B->val) {
            return false;
        }

        return compare(A->left, B->left) && compare(A->right, B->right);
    }
};
