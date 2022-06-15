#include <bits/stdc++.h>

#pragma GCC optimize(2)
#define endl '\n'
using namespace std;

int n, m, f[1001][1001], w[1001], v[1001], a[2001];
vector<int> c[1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i] >> v[i] >> w[i];
        c[a[i]].push_back(i);
    }
    for (int i = 1; i <= 1000; ++i) {
        for (int j = 0; j <= m; ++j) {
            f[i][j] = f[i - 1][j];
            for (auto k: c[i]) {
                if (v[k] <= j) {
                    f[i][j] = max(f[i][j], f[i - 1][j - v[k]] + w[k]);
                }
            }
        }
    }
    cout << f[1000][m];
    return 0;
}
