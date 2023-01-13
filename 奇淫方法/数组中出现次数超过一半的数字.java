//给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int N = array.length;
        int win = array[0];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (array[i] == win) {
                count++;
            } else if (count == 0) {
                win = array[i];
                count = 1;
            } else {
                count--;
            }
        }
        return win;
    }
}
