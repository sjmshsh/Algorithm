//我这个并查集里面全部放的是下标
class Union {
private:
	int sets;//用来记录目前有多少集合个数
	vector<int> parent;//用来记录此节点下标的上级节点下标是什么
	vector<int> size;//用来记录关键节点底下有多少个节点连着在
	vector<int> help;//用来压缩路径的数组，这里我们把这个数组当作stack来使用

	int findfather(int i)//这个传的是下标
	{
		int sakura = 0;
		while (i != parent[i])
		{
			i = parent[i];
			help[sakura++] = i;
		}//最后流的下来的就是根节点了
		sakura--;
		for (; sakura >= 0; sakura--)
		{
			parent[help[sakura]] = i;
			help[sakura] = 0;
		}
		return i;
	}
public:
	//构造函数
	Union(vector<int>& nums)
	{
		int n = nums.size();
		parent.resize(n);
		size.resize(n);
		help.resize(n);//这样的话可以确保一次性把内存分配够了
		sets = n;//初始化集合个数为n个
		for (int i = 0; i < n; i++)
		{
			parent[i] = i;//目前所有节点的上层节点都是它本身
			size[i] = 1;//所有代表节点底下都有1个兵
		}
	}

	bool isSameFather(int i, int j)
	{
		return findfather(i) == findfather(j);
	}

	int getsets()
	{
		return sets;
	}

	void together(int i, int j)
	{
		//先找到这两个下标的根节点
		int A = findfather(i);
		int B = findfather(j);
		if (A != B)//只有这两个节点不属于同一个集合才有必要进行合并
		{
			int big = size[A] > size[B] ? A : B;
			int small = big == A ? B : A;
			parent[small] = big;
             size[big] += size[small];
			size[small] = 0;
			sets--;
		}
	}
};
