#include <iostream>
#include <cmath>
using namespace std;

// Karatsuba乘法
long long karatsuba(long long num1, long long num2)
{
	// 递归终止条件
	if (num1 < 10 || num2 < 10)
		return num1 * num2;

	// 计算拆分长度
	int size1 = to_string(num1).length();
	int size2 = to_string(num2).length();
	int halfN = max(size1, size2) / 2;

	/* 拆分为a, b, c, d */
	long long a = stoll(to_string(num1).substr(0, size1 - halfN));
	long long b = stoll(to_string(num1).substr(size1 - halfN));
	long long c = stoll(to_string(num2).substr(0, size2 - halfN));
	long long d = stoll(to_string(num2).substr(size2 - halfN));

	// 计算z2, z0, z1，此处的乘法使用递归
	long long z2 = karatsuba(a, c);
	long long z0 = karatsuba(b, d);
	long long z1 = karatsuba((a + b), (c + d)) - z0 - z2;

	return (long long)(z2 * pow(10, (2 * halfN)) + z1 * pow(10, halfN) + z0);
}

int main()
{
	long long num1 = 12345;
	long long num2 = 6789;
	long long result = karatsuba(num1, num2);
	cout << "Product: " << result << endl;
	return 0;
}
