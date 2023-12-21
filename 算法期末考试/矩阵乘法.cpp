#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

// 矩阵乘法
vector<vector<int>> multiplyMatrix(
	const vector<vector<int>> &matrix1,
	const vector<vector<int>> &matrix2)
{
	// 矩阵相乘, 第一个矩阵的列数等于第二个矩阵的行数
	// m*n矩阵乘n*p矩阵, 结果为m*p矩阵
	int m = matrix1.size();	   // 第一个矩阵的行数
	int n = matrix1[0].size(); // 第一个矩阵的列数
	int p = matrix2[0].size(); // 第二个矩阵的列数

	// 创建一个结果矩阵, 初始化全部为零
	vector<vector<int>> result(m, vector<int>(p, 0)); // 定义m*p的矩阵, 初值为零

	// 执行矩阵乘法
	for (int i = 0; i < m; i++) // 第一个矩阵的行
	{
		for (int j = 0; j < p; j++) // 第二个矩阵的列
		{
			for (int k = 0; k < n; k++) // 第k个元素
			{
				result[i][j] += matrix1[i][k] * matrix2[k][j];
			}
		}
	}
	return result;
}

int main()
{
	// 示例输入矩阵
	vector<vector<int>> matrix1 = {{1, 2, 3}, {4, 5, 6}};
	vector<vector<int>> matrix2 = {{7, 8}, {9, 10}, {11, 12}};

	// 调用矩阵乘法函数
	vector<vector<int>> result = multiplyMatrix(matrix1, matrix2);

	// 打印结果矩阵
	for (const auto &row : result)
	{
		for (const auto &val : row)
		{
			cout << "\t" << val << " ";
		}
		cout << endl;
	}

	return 0;
}
