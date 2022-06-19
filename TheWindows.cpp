#include <iostream>
#include <vector>

using namespace std;

std::vector<int> res;
int q[11];


int main(){
	int w = 3;
	int arr[] = {4, 3, 5, 4, 3, 3, 6, 7};
	int N = sizeof(arr) / sizeof(arr[0]);
	int head = 0;
	int tail = 0;
	q[head] = 0;
	q[tail] = 0;
	for (int i = 1; i < N; i++){
		for(; arr[q[tail]] <= arr[i] && head <= tail; tail--);
		q[++tail] = i;
		if (q[head] + w == i){
			head++;
		}
		if (i >= w - 1){
			res.push_back(arr[q[head]]);
		}
	}
	for(auto e : res){
		cout << e << " ";
	}
	return 0;
}
