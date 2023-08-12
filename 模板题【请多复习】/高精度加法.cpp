#include <iostream>
#include <vector>

using namespace std;

string n, m;

vector<int> Add(vector<int> &a1, vector<int> &a2) {
	if (a1.size() < a2.size()) {
		// 需要保证a1比a2大
		return Add(a2, a1);
	}
	vector<int> res;
	int t = 0;
	for (int i = 0; i < a1.size(); i++) {
		t += a1[i];
		if (i < a2.size()) {
			t += a2[i];
		}
		res.push_back(t % 10);
		t /= 10;
	}
	if (t) {
		res.push_back(t);
	}

	return res;
}

int main() {
	cin >> n;
	cin >> m;
	vector<int> a1, a2;
	// 将整数字符串放入到vector里面去, 倒着放
	for (int i = n.size() - 1; i >= 0; i--) {
		a1.push_back(n[i] - '0');
	}
	for (int i = m.size() - 1; i >= 0; i--) {
		a2.push_back(m[i] - '0');
	}
	vector<int> a3 = Add(a1, a2);
	for (int i = a3.size() - 1; i >= 0; i--) {
		printf("%d", a3[i]);
	}
	return 0;
}
