#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

void merge(vector<int> &array, int low, int mid, int high)
{
	vector<int> tmp(high - low + 1);
	int i = low;
	int j = mid + 1;
	int k = 0;
	while (i <= mid && j <= high)
	{
		if (array[i] < array[j])
		{
			tmp[k++] = array[i++];
		}
		else
		{
			tmp[k++] = array[j++];
		}
	}
	while (i <= mid)
	{
		tmp[k++] = array[i++];
	}
	while (j <= high)
	{
		tmp[k++] = array[j++];
	}
	int m = 0;
	for (int x = low; x < high; x++)
	{
		array[x] = tmp[m++];
	}
}

void mergeSortInternal(vector<int> &array, int low, int high)
{
	if (low >= high)
	{
		return;
	}
	int mid = (low + high) / 2;
	// 左边
	mergeSortInternal(array, low, mid);
	// 右边
	mergeSortInternal(array, mid + 1, high);
	// 合并
	merge(array, low, mid, high);
}

void mergeSort(vector<int> &array, int N)
{
	mergeSortInternal(array, 0, N - 1);
}

int main()
{

	return 0;
}
