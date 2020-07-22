#include<vector>
#include<iostream>

using namespace std;
int pair_and_single(int n,vector<int>dp){
    if(n<=1){
        dp[n]=n;
        return 1;
    }
    if(dp[n]!=0)
    return dp[n];

   int singleways= pair_and_single(n-1,dp);
   int pairupways= pair_and_single(n-2,dp)*(n-1);

   return dp[n]=singleways+pairupways;

}
int pair_and_single2(int n,vector<int>dp){
    for(int i=0;i<=n;i++){

        if(i<=1){
            dp[i]=1;
            continue;
        }
   int singleways= dp[i-1];
   int pairupways= dp[i-2]*(i-1);

   return dp[i]=singleways+pairupways;

}
return dp[n];
}

int pair_and_single3(int n)
{
    if (n <= 1)
        return 1;

    int a = 1; // n=0
    int b = 1; //n=1;
    int ans = 0;
    for (int i = 2; i <= n; i++)
    {
        ans = b + a * (i - 1);
        a = b;
        b = ans;
    }

    return ans;
}

int main(){

}