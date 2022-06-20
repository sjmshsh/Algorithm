#include <iostream>

using namespace std;

char s[100001];
char str[100001];
int top = 0;

int main()
{
    int n;
    cin >> n;
    cin >> str;
    s[++top] = str[0];
    for (int i = 1; i < n; i++)
    {
        if (s[top] == str[i])
        {
            top--;
        }
        else
        {
            s[++top] = str[i];
        }
    }
    for (int i = 1; i <= top; i++)
    {
        printf("%c", str[i]);
    }
    return 0;
}
