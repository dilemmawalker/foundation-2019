#include <iostream>
using namespace std;
int main(){
    int nst,nsp,csp,cst,i,n;
    cst=1;
    cin>>n;
    for(i=1;i<=n;i++){
        for(nst=1;nst<=cst;nst++){
        cout<<"*";
        }cout<<""<<endl;cst++;
    }
}