#include <iostream>

using namespace std;

int n;
int s[10001];
int top = 0;
int l = 0;

int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int x;
        cin >> x;
        if (s[top] != x)
        {
            for (int j = l + 1; j <= x; j++)
            {
                printf("push %d\n", j);
            }
            l = x;
        }
        printf("pop\n");
        top--;
    }
    return 0;
}
