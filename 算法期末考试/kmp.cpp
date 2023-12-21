#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

// KMP算法的核心就是next数组, 不必像暴力搜索一样，目标串每次只能往前移动一个字符，而是可以根据next的指向，移动到下一个有可能完成匹配的下标处。
void get_next(string t, vector<int> &next)
{
	int i = 0, j = -1;
	next[0] = -1; // -1的含义是没有办法继续往后匹配了, 只能换一个起始点
	while (i < t.size() - 1)
	{
		if (j == -1 || t[i] == t[j])
		{
			next[++i] = ++j;
		}
		else
		{
			j = next[j];
		}
	}
}

int KMP_search(string s, string t)
{
	int i = 0, j = 0;
	vector<int> next(t.size());
	get_next(t, next);
	while (j == -1 || (i < s.size() && j < t.size()))
	{
		if (j == -1 || s[i] == t[j])
		{
			i++;
			j++;
		}
		else
		{
			j = next[j];
		}
	}
	if (j == t.size())
	{
		return i - j;
	}
	else
	{
		return -1;
	}
}

int main()
{
	string s = "aaab";
	string t = "ab";
	cout << KMP_search(s, t) << endl;
	return 0;
}
