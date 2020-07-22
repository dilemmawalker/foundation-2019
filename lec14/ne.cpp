#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int display(int n){
    if(n<=0){
        return 2;
    }
    
        if(n%2==0){
            n=n-1;
        }
        cout<<n<<endl;
 display(n-2);

}

int main() {
   int n;
    cin>>n;
display(n);
}
