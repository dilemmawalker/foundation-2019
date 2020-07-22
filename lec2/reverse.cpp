#include<iostream>
using namespace std;
int main()
{
int n=0,n1=0;
cout<<"enter the no.";
cin>>n;
while(n!=0)
{
    n1=(n1*10)+(n%10);
    n=n/10;
}
cout<<"the reverse is "<<n1;
}
