#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int merge_sort(vector<int> &A, int left, int right)
{
	if (left >= right)
	{
		return 0;
	}
	int mid = (left + right) / 2;
	// merge_sort递归
	int count = merge_sort(A, left, mid) + merge_sort(A, mid + 1, right);
	int i = left, j = mid + 1; // 两个指针, 分别指向两个数组的开头
	vector<int> B;
	while (i <= mid && j <= right)
	{
		if (A[i] <= A[j])
		{
			B.push_back(A[i]);
			i++;
		}
		else
		{
			count += mid - i + 1;
			B.push_back(A[j]);
			j++;
		}
	}
	while (i <= mid)
	{
		B.push_back(A[i]);
		i++;
	}
	while (j <= right)
	{
		B.push_back(A[j]);
		j++;
	}
	for (int k = left; k <= right; k++)
	{
		A[k] = B[k - left];
	}
	return count;
}

int main()
{
	vector<int> A = {1, 3, 5, 2, 4, 6};
	int count = merge_sort(A, 0, A.size() - 1);
	cout << count << endl;
	return 0;
}
