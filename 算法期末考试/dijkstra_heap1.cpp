#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

struct node_info
{
public:
	node_info(int i, int w)
		: index(i), weight(w) {}
	node_info()
		: index(0), weight(0) {}
	node_info(const node_info &ni)
		: index(ni.index), weight(ni.weight) {}

	friend bool operator<(const node_info &lth, const node_info &rth)
	{
		return lth.weight > rth.weight; // 为了实现从小到大的顺序
	}

public:
	int index;	// 结点位置
	int weight; // 权值
};

struct path_info
{
	path_info()
		: front_index(0),
		  weight(numeric_limits<int>::max())
	{
	}
	int front_index;
	int weight;
};

class ss_shortest_paths
{
public:
	ss_shortest_paths(const vector<vector<int>> &g, int end_location)
		: no_edge(-1), end_node(end_location), node_count(g.size()), graph(g)
	{
	}

	// 求最短路径
	void shortest_paths()
	{
		vector<path_info> path(node_count);
		priority_queue<node_info, vector<node_info>> min_heap;
		min_heap.push(node_info(0, 0)); // 将起始节点入队

		while (true)
		{
			// 取出最大值
			node_info top = min_heap.top();
			min_heap.pop();

			// 已到达目的节点
			if (top.index == end_node)
			{
				break;
			}

			// 未到达则遍历
			for (int i = 0; i < node_count; i++)
			{
				// 顶点top.index和i间有边，且此路径长小于原先从原点到i的路径长
				if (graph[top.index][i] != no_edge &&
					(top.weight + graph[top.index][i]) < path[i].weight)
				{
					min_heap.push(node_info(i, top.weight + graph[top.index][i]));
					path[i].front_index = top.index;
					path[i].weight = top.weight + graph[top.index][i];
				}
			}
			if (min_heap.empty())
			{
				break;
			}
		}

		shortest_path = path[end_node].weight;
		int index = end_node;
		s_path_idex.push_back(index);
		while (true)
		{
			index = path[index].front_index;
			s_path_idex.push_back(index);
			if (index == 0)
			{
				break;
			}
		}
	}

private:
	vector<vector<int>> graph; // 图的数组表示
	int node_count;			   // 节点个数
	const int no_edge;		   // 无通路
	const int end_node;		   // 目的节点
	vector<int> s_path_idex;   // 最短路径
	int shortest_path;		   // 最短路径
};

int main()
{
	return 0;
}
