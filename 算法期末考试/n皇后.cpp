#include <iostream>

using namespace std;

const int N = 20;

// bool数组用来判断搜索的下一个位置是否可行
// col列, dg对角线, udg反对角线
// g[N][N]用来存路径

int n;
char g[N][N];
bool col[N], dg[N], udg[N];

void dfs(int u)
{
	// u == n表示已经搜索了n行, 故输出这条路径
	if (u == n)
	{
		for (int i = 0; i < n; i++)
		{
			cout << g[i] << endl;
		}
		cout << endl;
		return;
	}

	// 枚举u这一行, 搜索合法的列
	int x = u;
	for (int y = 0; y < n; y++)
	{
		// 剪枝(对于不满足要求的点, 不再继续往下搜索)
		// y - x + n, +n是为了防止下标小于0
		if (col[y] == false && dg[y - x + n] == false && udg[y + x] == false)
		{
			col[y] = dg[y - x + n] = udg[y + x] = true;
			g[x][y] = 'Q';
			dfs(x + 1);
			g[x][y] = '.';
			col[y] = dg[y - x + n] = udg[y + x] = false;
		}
	}
}

int main()
{
	cin >> n;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			g[i][j] = '.';
	return 0;
}
