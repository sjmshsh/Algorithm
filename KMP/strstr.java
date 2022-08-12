class Solution {
    // KMP算法
    public int strStr(String haystack, String needle) {
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] nexts = getNextArray(needleArr);
        while (i1 < haystackArr.length && i2 < needleArr.length) {
            if (haystackArr[i1] == needleArr[i2]) {
                i1++;
                i2++;
            } else if (i2 == 0) {
                i1++;
            } else {
                i2 = nexts[i2];
            }
        }
        return i2 == needleArr.length ? i1 - i2 : -1;
    }

    public int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[] {-1};
        }
        int[] nexts = new int[str.length];
        int i = 2;
        nexts[0] = -1;
        nexts[1] = 0;
        int cn = 0;
        while (i < str.length) {
            if (str[i - 1] == str[cn]) {
                nexts[i++] = ++cn;
            } else if (cn > 0) {
                cn = nexts[cn];
            } else {
                nexts[i++] = 0;
            }
        }
        return nexts;
    }
}
