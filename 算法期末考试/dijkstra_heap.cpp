#include <iostream>
#include <string>
#include <stdio.h>
#include <algorithm>
#include <queue>

using namespace std;

const int MAX_V = 100;	// 最大顶点数
const int INF = 100000; // 正无穷
int cost[MAX_V][MAX_V]; // 节点间cost表(即图)
int d[MAX_V], V, s;		// 起点到各个顶点的距离, 顶点数, 起点

// 自定义优先级队列less比较函数
struct cmp
{
	bool operator()(int &a, int &b) const
	{
		// 因为优先为greater, 所以反向定义实现最小值实现
		return d[a] > d[b];
	}
};

void Dijkstra()
{
	priority_queue<int, vector<int>, cmp> pq;
	pq.push(s);
	d[s] = 0;
	while (!pq.empty())
	{
		int tmp = pq.top();
		pq.top();
		for (int i = 0; i < V; i++)
		{
			if (d[i] > d[tmp] + cost[tmp][i])
			{
				d[i] = d[tmp] + cost[tmp][i];
				pq.push(i);
			}
		}
	}
}

int main()
{
	return 0;
}
