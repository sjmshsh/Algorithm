// https://leetcode.cn/problems/valid-perfect-square/

class Solution {
public:
    bool isPerfectSquare(int num) {
        long l = -1;
        long r = (long) num + 1;
        while (l + 1 != r) {
            int mid = l + (r - l) / 2;
            long s = (long) mid * mid;
            if (s < num) {
                l = mid;
            } else if (s > num) {
                r = mid;
            } else {
                return true;
            }
        }
        return false;
    }
};
