#include <iostream>
#include <algorithm>

using namespace std;

// 有n个物品可以取, m表示物品的总体积是m
int n, m;
int v[1001]; // 体积
int w[1001]; // 收益
int l[101]; // 每一个物品可以使用的次数
int dp[1001];

int main() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		cin >> v[i] >> w[i] >> l[i];
	}
	for (int i = 1; i <= n; i++) {
		// 我们在这个地方让01背包问题进行l[i]次就可以了
		for (int k = 1; k <= l[i]; k++) {
			for (int j = m; j >= v[i]; j--) {
				for (int j = m; j >= v[i]; j--) {
					dp[j] = max(dp[j], dp[j - v[i]] + w[i]);
				}
			}
		}
	}

	cout << dp[m];
	return 0;
}
