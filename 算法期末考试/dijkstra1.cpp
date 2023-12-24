#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

const int INF = 1000000000;

struct Node
{
	int v;	 // 边的目标顶点
	int dis; // dis为边权
	Node(int x, int y)
		: v(x),
		  dis(y) {}
};

void Dijkstra(int n, int s, vector<vector<Node>> Adj, vector<bool> vis, vector<int> &d)
{
	/*
	param
	n: 顶点个数
	s: 起点
	Adj: 图的领接表
	vis: 标记顶点是否被访问
	d: 存储顶点s到其他顶点的最短距离
	*/

	fill(d.begin(), d.end(), INF);
	d[s] = 0;
	for (int i = 0; i < n; i++)
	{
		int u = -1;
		int MIN = INF;
		for (int j = 0; j < n; j++)
		{
			if (vis[j] == false && d[j] < MIN)
			{
				u = j;
				MIN = d[j];
			}
		}
		// 找不到小于INF的d[u], 说明剩下的顶点和起点s不连通
		if (u == -1)
		{
			return;
		}
		vis[u] = true;
		for (int j = 0; j < Adj[u].size(); j++)
		{
			// 通过领接表获取u能直接到达的v
			int v = Adj[u][j].v;
			if (vis[v] == false && d[v] > d[u] + Adj[u][j].dis)
			{
				// 优化d[u]
				d[v] = d[u] + Adj[u][j].dis;
			}
		}
	}
}

int main()
{
	return 0;
}
