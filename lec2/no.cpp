#include<iostream>
using namespace std;
int main(int args, char **argv)
{
    int n=0,c=0;
    cout<<"enter the no.";
    cin>>n;
    for(int i=1;i<=n;i++)
    {
     if(n/10>=10)
     {
     c++;
     n=n/10;
     }
     else 
     break;
     } c=c+2;cout<<"no. of digits is "<<c;
}