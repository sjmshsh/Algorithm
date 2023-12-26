#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>

using namespace std;

struct Knapsack
{
	int weight;	   // 物品重量
	int value;	   // 物品价值
	int unitValue; // 单位重量价值

	Knapsack(int weight, int value)
		: weight(weight),
		  value(value)
	{
		unitValue = (weight == 0) ? 0 : value / weight;
	}

	bool operator<(const Knapsack *other) const
	{
		return unitValue > other->unitValue;
	}
};

struct Node
{
	int currWeight; // 当前放入物品的重量
	int currValue;	// 当前放入物品等价值
	int upperLimit; // 不放入当前物品可能得到的价值上限
	int index;		// 当前操作物品的索引

	Node(int currWeight, int currValue, int index)
		: currWeight(currWeight),
		  currValue(currValue),
		  index(index)
	{
	}
};

class ZeroAndOnePackage
{
private:
	vector<Knapsack> knapsacks; // 物品数组
	int totalWeight;			// 背包承重量
	int num;					// 物品数
	int bestValue;				// 可以获得的最大价值

public:
	ZeroAndOnePackage(vector<Knapsack> &knapsacks, int totalWeight)
		: knapsacks(knapsacks),
		  totalWeight(totalWeight)
	{
		num = knapsacks.size();
		// 物品依据单位重量价值进行排序
		sort(knapsacks.begin(), knapsacks.end());
		bestValue = 0;
	}

	int getBestValue()
	{
		return bestValue;
	}

	// 价值上限=节点现有价值+背包剩余容量*剩余物品的最大单位重量价值
	// 当物品由单位重量的价值从大到小排序到时候, 计算出的价值上限大于所有物品的总重量, 否则小于物品的总重量
	// 当放入背包的物品越来越多的时候, 价值上限也越来越接近物品的真实总价值
	int getPutValue(Node &node)
	{
		// 获取背包剩余容量
		int surplusWeight = totalWeight - node.currWeight;
		int value = node.currValue;
		int i = node.index;

		while (i < num && knapsacks[i].weight <= surplusWeight)
		{
			surplusWeight -= knapsacks[i].weight;
			value += knapsacks[i].value;
			i++;
		}
		// 当物品超重无法放入背包的时候, 可以通过背包剩余容量*下个物品单位重量的价值计算出物品的价值上限
		if (i < num)
		{
			value += knapsacks[i].unitValue * surplusWeight;
		}
		return value;
	}

	void findMaxValue()
	{
		deque<Node> nodeList;
		nodeList.push_back(Node(0, 0, 0));

		while (!nodeList.empty())
		{
			Node node = nodeList.front();
			nodeList.pop_front();

			// 如果当前节点的上限大于等于最大价值并且节点索引小于物品总数, 那就可以进行操作
			// 否则没有操作的必要, 上限都没有当前的最大价值大, 何必操作嗯
			if (node.upperLimit >= bestValue && node.index < num)
			{
				// 左节点: 该节点代表物品放入背包, 上个节点的价值+本次物品的价值为当前价值
				int leftWeight = node.currWeight + knapsacks[node.index].weight;
				int leftValue = node.currValue + knapsacks[node.index].value;
				Node left(leftWeight, leftValue, node.index + 1);
				// 放入当前物品后可以获得的价值上限
				left.upperLimit = getPutValue(left);
				// 当物品放入背包中的左节点的判断条件为保证不超过背包的总承重
				if (left.currWeight <= totalWeight && left.upperLimit > bestValue)
				{
					// 将左节点添加到队列中
					nodeList.push_back(left);
					if (left.currValue > bestValue)
					{
						// 物品放入背包不超重, 且当前价值更大, 则当前价值为最大价值
						bestValue = left.currValue;
					}
				}
				// 右节点: 改节点表示物品不放入背包中, 上个节点的价值为当前价值
				Node right(node.currWeight, node.currValue, node.index + 1);
				// 不放入当前物品后可以获取的价值上限
				right.upperLimit = getPutValue(right);
				if (right.upperLimit >= bestValue)
				{
					nodeList.push_back(right);
				}
			}
		}
	}
};

int main()
{
	vector<Knapsack> knapsacks = {
		Knapsack(2, 13),
		Knapsack(1, 10),
		Knapsack(3, 24),
		Knapsack(2, 15),
		Knapsack(4, 28),
		Knapsack(5, 33),
		Knapsack(3, 20),
		Knapsack(1, 8)};
	int totalWeight = 12;

	ZeroAndOnePackage zeroAndOnePackage(knapsacks, totalWeight);
	zeroAndOnePackage.findMaxValue();

	cout << "最大价值为：" << zeroAndOnePackage.getBestValue() << endl;

	return 0;
	return 0;
}
