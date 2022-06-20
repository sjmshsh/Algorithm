#include <iostream>
#include <string>

using namespace std;

//模拟栈的数组
char s[100001];
//存放字符串的数组
char str[200001];
//标记变量
bool flg = false;
//用来模仿栈顶
int top = 0;

int main()
{
    int n;
    cin >> n;
    cin >> str;
    for (int i = 0; i < n; i++)
    {
        if (str[i] == '[' || str[i] == '(')
        {
            s[++top] = str[i];
        }
        else
        {
            if (str[i] == ']')
            {
                if (s[top] != '[')
                {
                    flg = true;
                    break;
                }
                else
                {
                    top--;
                }
            }
            else
            {
                if (s[top] != '(')
                {
                    flg = true;
                    break;
                }
                else
                {
                    top--;
                }
            }
        }
    }
    if(flg || top)
    {
        cout << "No";
    }
    else
    {
        cout << "Yes";
    }
    return 0;
}
