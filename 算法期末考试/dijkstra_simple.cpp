#include <iostream>
#include <string>
#include <stdio.h>
#include <algorithm>

using namespace std;

const int N = 510, M = 100010;

int g[N][N], dist[N];
bool visited[N];

int n, m; // n个点, m条边

int dijkstra()
{
	memset(dist, 0x3f, sizeof(dist));
	dist[1] = 0;
	for (int i = 1; i <= n; i++)
	{
		int t = -1;
		for (int j = 1; j <= n; j++)
		{
			if (!visited[j] && (t == -1 || dist[j] < dist[t]))
			{
				t = j;
			}
		}
		visited[t] = true;
		for (int j = 1; j <= n; j++)
		{
			dist[j] = min(dist[j], dist[t] + g[t][j]);
		}
	}
	if (dist[n] == 0x3f3f3f)
		return -1;
	return dist[n];
}

int main()
{
	scanf("%d%d", &n, &m);

	memset(g, 0x3f, sizeof(g));
	while (m--)
	{
		int x, y, c;
		scanf("%d%d%d", &x, &y, &c);
		g[x][y] = min(g[x][y], c);
	}

	cout << dijkstra() << endl;

	return 0;
}
