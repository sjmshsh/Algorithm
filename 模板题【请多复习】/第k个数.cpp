#include <iostream>

using namespace std;

const int N = 1e5 + 10;
int n, k;
int arr[N];

int quick_sort(int l, int r, int k) {
	if (l >= r) return arr[l];
	int i = l - 1, j = r + 1, x = arr[l];
	while (i < j) {
		do i++ ; while (arr[i] < x);
		do j-- ; while (arr[j] > x);
		if (i < j) swap(arr[i], arr[j]);
	}
	int len = j - l + 1;
	if (k <= len) return quick_sort(l, j, k);
	else return quick_sort(j + 1, r, k - len);
}

int main() {
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; ++i) {
		scanf("%d", &arr[i]);
	}
	printf("%d", quick_sort(0, n - 1, k));
	return 0;
}
