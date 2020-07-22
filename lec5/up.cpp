#include <iostream>
#include <vector>
using namespace std;

int binary(vector<int> &arr)
{
    int i, ansidx = -1;
    cout << "enter no. to be searched";
    int no;
    cin >> no;
    int si = 0;
    int ei = arr.size() - 1;
    while (si <= ei)
    {
        int mid = (si + ei) / 2;
        if (arr[mid] == no)
        {
            if (mid + 1 >= 0 && arr[mid] == arr[mid + 1])
                ei = mid + 1;
            else
            {
                ansidx = mid;
                return ansidx;
            }
        }

        else if (arr[mid] < no)
            si = mid + 1;
        else
            ei = mid - 1;
    }
}

int input(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
        cin >> arr[i];
    return 0;
}
int main()
{
    int n;
    cout << "enter the no. of inputs in array";
    cin >> n;
    vector<int> arr(n, 0);
    input(arr);
    cout << binary(arr);
    return 0;
}
