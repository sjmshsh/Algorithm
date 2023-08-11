#include <iostream>
#include <algorithm>

using namespace std;

typedef long long ll;
const int N = 1e5 + 10;
int n;
int arr[N], tmp[N];

ll merge_sort(int l, int r) {
	if (l >= r) {
		return 0;
	}
	int mid = (l + r) >> 1;
	ll res = merge_sort(l, mid) + merge_sort(mid + 1, r);
	int k = 0, i = l, j = mid + 1;
	while (i <= mid && j <= r) {
		if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
		else {
			tmp[k++] = arr[j++];
			res += mid - i + 1;
		}
	}

	while (i <= mid) tmp[k++] = arr[i++];
	while (j <= r) tmp[k++] = arr[j++];

	for (int i = l, j = 0; i <= r; i++, j++) {
		arr[i] = tmp[j];
	}
	return res;
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	cout << merge_sort(0, n - 1);
	return 0;
}
