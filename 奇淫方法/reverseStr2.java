class Solution {

    public void Swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public void reverse(char[] str, int l, int r) {
        while (l < r) {
            Swap(str, l, r);
            l++;
            r--;
        }
    }
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        for (int i = 0; i < n; i = i + 2*k) {
            int r = i + k - 1;
            reverse(str, i, Math.min(n - 1, r));
        }
        return String.valueOf(str);
    }
}
