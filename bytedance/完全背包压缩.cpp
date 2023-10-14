#include <iostream>
#include <algorithm>

using namespace std;

// 有n个物品可以取, m表示物品的总体积是m
int n, m;
int v[1001]; // 体积
int w[1001]; // 收益
int dp[1001][1001];

int main() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		cin >> v[i] >> w[i];
	}
	// 背包压缩
	for (int i = 1; i <= n; i++) {
		for (int j = v[i]; j <= m; j++) {
			dp[j] = max(dp[j], dp[j - v[i]] + w[i]);
		}
	}
	cout << dp[n][m];
	return 0;
}
