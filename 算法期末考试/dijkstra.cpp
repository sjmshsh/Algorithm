#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

const int INF = 1000000000;

/* Dijkstra算法解决的事单源最短路径问题， 即给定图G(V, E)和起点s(起点又称为源点),
求从起点s到达其他顶点的最短距离, 并将短距离存储在矩阵d中*/
void Dijkstra(int n, int s, vector<vector<int>> G, vector<bool> &vis, vector<int> &d)
{
	/*
	param
	n: 顶点个数
	s: 源点
	G: 图的领接矩阵
	vis: 标记顶点是否已经被访问
	d: 存储源点s到达其他顶点的最短路径
	*/

	// 初始化最短距离矩阵, 全部为INF
	fill(d.begin(), d.end(), INF);
	d[s] = 0; // 起点s到达自身的距离为0
	for (int i = 0; i < n; i++)
	{
		int u = -1;	   // 找到d[u]最小的u
		int MIN = INF; // 记录最小的d[u]
		// 开始寻找最小的d[i]
		for (int j = 0; j < n; ++j)
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
		// 标记u已经被访问
		vis[u] = true;
		for (int v = 0; v < n; ++v)
		{
			// 遍历所有顶点, 如果v没有被访问&&u能够到达v&&以u为中介可以使d[v]更优
			if (vis[v] == false && d[u] + G[u][v] < d[v])
			{
				d[v] = d[u] + G[u][v]; // 更新d[v]
			}
		}
	}
}

int main()
{

	return 0;
}
