class Solution {
    public boolean canTransform(String start, String end) {
        int N = start.length();
        int i = 0;
        int j = 0;
        while (i < N || j < N) {
            // 找到start和end中不是X的字符
            while (i < N && start.charAt(i) == 'X') i++;
            while (j < N && end.charAt(j) == 'X') j++;
            if (i == N || j == N) {
                // 为了避免越界问题，这里马上就进行一次判断
                return i == j;
            }
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return i == j;
    }
}
