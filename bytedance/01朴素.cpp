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
	// 下标为0的时候表示目前没有物品可以取, 所以能得到的最大价值就是0
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= m; j++) {
			// 第一钟可能性, 我不要这个背包
			dp[i][j] = dp[i - 1][j];
			// 第二种可能性, 我要这个背包
			if (j - v[i] >= 0) {
				dp[i][j] = max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
			}
		}
	}
	cout << dp[n][m];
}
