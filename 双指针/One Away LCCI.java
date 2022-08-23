class Solution {
    public boolean oneEditAway(String first, String second) {
        int n = first.length();
        int m = second.length();
        if (Math.abs(n - m) > 1) {
            return false;
        }
        if (n > m) {
            return oneEditAway(second, first);
        }
        // 我们保证让n是更小的那个，m是更大的那个
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < n && j < m && cnt <= 1) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                if (n == m) {
                    cnt++;
                    i++;
                    j++;
                } else {
                    cnt++;
                    j++;
                }
            }
        }
        return cnt <= 1;
    }
}
