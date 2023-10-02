class Solution {
public:
    int mySqrt(int x) {
        long long l = -1;
        long long r = (long long)x + 1;
        int ans = -1;
        while (l + 1 != r) {
            long long mid = l + (r - l) / 2;
            if ((long long)mid * mid <= x) {
                ans = mid;
                l = mid;
            } else {
                r = mid;
            }
        } 
        return ans;
    }
};
