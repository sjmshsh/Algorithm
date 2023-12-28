#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

const int maxn = 1e5 + 10;
int q[maxn], tmp[maxn];
int ans;

void merge_sort(int q[], int l, int r)
{
	// 如果只有一个数字或者没有数字, 则无需排序
	if (l >= r)
		return;
	int mid = (l + r) / 2;
	merge_sort(q, l, mid);	   // 分解左序列
	merge_sort(q, mid + 1, r); // 分解右序列
	int k = l;
	int i = l;
	int j = mid + 1;
	while (i <= mid && j <= r)
	{
		if (q[i] <= q[j])
			tmp[k++] = q[i++];
		else
		{
			tmp[k++] = q[j++];
			ans += mid - i + 1; // 统计产生逆序对的数量
		}
	}
	while (i <= mid)
		tmp[k++] = q[i++]; // 复制左边子序列剩余
	while (j <= r)
		tmp[k++] = q[j++]; // 复制右边子序列剩余
	for (int i = l; i <= r; i++)
		q[i] = tmp[i];
}

int main()
{
	return 0;
}
