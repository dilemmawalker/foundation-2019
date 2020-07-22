#include<iostream>
using namespace std;
int main(){
    int i,nst,nsp,cst,csp,n;
    cout<<"enter the no.";
    cin>>n;
    csp=n-1;
    cst=1;
    for(i=1;i<=n;i++){
        for(nsp=1;nsp<=csp;nsp++){
        cout<<" ";
        }
        for(nst=1;nst<=cst;nst++){
            cout<<"*";
        }
          cout<<endl;
        if(i<=n/2){
            csp--;
            cst+=2;
      
}
else{
    cst-=2;
    csp++;
}
}}