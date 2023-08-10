// https://www.nowcoder.com/practice/acead2f4c28c401889915da98ecdc6bf?tpId=230&tqId=2021480&ru=/exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196

#include <iostream>
using namespace std;

const int N = 100010;
long long arr[N];
long long dp[N];

int main() {
    int n, q;
    cin >> n >> q;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
        dp[i] = dp[i - 1] + arr[i];
    }
    int l, r;
    while (q--) {
        cin >> l >> r;
        printf("%lld\n", dp[r] - dp[l - 1]);
    }
    return 0;
}
