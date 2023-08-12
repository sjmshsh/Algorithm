#include <iostream>

using namespace std;

double n;

int main() {
	cin >> n;
	double l = -10000;
	double r = 10000;
	while (r - l > 1e-8) {
		double mid = (l + r) / 2;
		if (mid * mid * mid < n) l = mid;
		else r = mid;
	}
	printf("%lf\n", l);
	return 0;
}
