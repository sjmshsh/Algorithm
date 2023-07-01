// 编写一个算法来判断一个数 n 是不是快乐数。

//「快乐数」 定义为：

//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果这个过程 结果为 1，那么这个数就是快乐数。
//如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

//链接：https://leetcode.cn/problems/happy-number
class Solution {
public:

    // 返回n这个数每一位上的平方和
    int bitSum(int n) {
        int sum = 0;
        while (n) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

    bool isHappy(int n) {
        int slow = n, fast = bitSum(n);
        while(slow != fast)
        {
            slow = bitSum(slow);
            fast = bitSum(bitSum(fast));
        }
        return slow == 1;
    }
};
