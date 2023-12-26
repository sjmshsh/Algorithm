#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>

using namespace std;

struct Node
{
	int weight; // 节点所对应的重量
	int value;	// 节点所对应的价值

	Node() {}
	Node(int weight, int value)
		: weight(weight),
		  value(value) {}
};

class Bag01
{
public:
	int maxWeight = 9; // 背包的最大容量
	int maxValue = 0;  // 背包内的最大价值总和

	void f(int weight[], int value[], int size)
	{
		queue<Node> queue;
		Node node;

		// 放入一个初始节点, 节点状态均为0
		queue.push(node);

		int p = 0; // 物品指针位置

		while (!queue.empty())
		{
			// 取出当前节点的背包状态
			Node nowBagNode = queue.front();
			queue.pop();

			// 如果物品没有放完
			if (p < size)
			{
				// 不放此p号物品的状态
				queue.push(Node(nowBagNode.weight, nowBagNode.value));

				// 放置此p号物品的状态, 如果放入超重了, 那就不能放了
				if (nowBagNode.weight + weight[p] <= maxWeight)
				{
					nowBagNode.weight += weight[p];
					nowBagNode.value += value[p];
					p++;

					queue.push(Node(nowBagNode.weight, nowBagNode.value));
					maxValue = max(nowBagNode.value, maxValue);
				}
			}
		}
		cout << maxValue << endl;
	}
};

int main()
{
	int weights[] = {2, 3, 5, 4};
	int values[] = {66, 40, 95, 40};
	int size = sizeof(weights) / sizeof(weights[0]);

	Bag01 bag01;
	bag01.f(weights, values, size);
	return 0;
}
