#include <iostream>

using namespace std;

const int N = 1e5 + 10;
int a[N];
int n, q;

int left_bound(int x) {
	int l = -1;
	int r = n;
	while (l + 1 != r) {
		int mid = (l + r) >> 1;
		if (a[mid] < x) l = mid;
		else r = mid;
	}
	if (r == n || a[r] != x) {
		return -1;
	}
	return r;
}

int right_bound(int x) {
	int l = -1;
	int r = n;
	while (l + 1 != r) {
		int mid = (l + r) >> 1;
		if (a[mid] <= x) l = mid;
		else r = mid;
	}
	if (l == -1 || a[l] != x) {
		return -1;
	}
	return l;
}

int main() {
	scanf("%d%d", &n, &q);
	for (int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	while (q--) {
		int k;
		scanf("%d", &k);
		printf("%d %d\n", left_bound(k), right_bound(k));
	}
	return 0;
}
