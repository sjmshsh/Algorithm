class Solution {
public:
    // 从后往前遍历是不会出现任何问题的
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int x = nums1.size() - 1;
        int end1 = m - 1; // 指向nums1数组的最后一个元素
        int end2 = n - 1; // nums2数组的最后一个元素
        while (end1 >= 0 && end2 >= 0) {
            if (nums1[end1] > nums2[end2]) {
                nums1[x--] = nums1[end1--];
            } else {
                nums1[x--] = nums2[end2--];
            }
        }
        while (end2 >= 0) {
            nums1[x--] = nums2[end2--];
        }
    }
};
