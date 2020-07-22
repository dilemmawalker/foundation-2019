#include<vector>
#include<iostream>

using namespace std;

    
    void display(vector<vector<int>> &dp){
        for(int i=0;i<dp.size();i++){
            for(int j=0;j<dp.size();j++){
                cout<<dp[i][j]<<" ";
            }
            cout<<endl;
        }
    }
    int ans(vector<vector<int>>& arr,int m,int n,vector<vector<int>> &dp) {
           if(m==arr[0].size()-1 && n==arr.size()-1){
               dp[n][m]=arr[n][m];
              return arr[n][m]; 
           }
        
        if(dp[n][m]!=0)
            return dp[n][m];
        
        int c1=10000;
        if(m<arr[0].size()-1)        
            c1=ans(arr,m+1,n,dp);
        
       
        int c2=10000;
        if(n<arr.size()-1)           
            c2=ans(arr,m,n+1,dp);
        
        
        int anss=min(c1,c2);
        dp[n][m]=anss+arr[n][m];
        return dp[n][m];
    }
     int ansDP(vector<vector<int>>& arr,int j,int i,vector<vector<int>> &dp) {
           for(int n=i;n>=0;n--){
               for(int m=j;m>=0;m--){

                   if(n==i && m==j){
                dp[n][m]=arr[n][m];
                continue;
                   }
        
        int c1=10000;
        if(m<arr[0].size()-1)        
            c1=dp[n][m+1];
        
       
        int c2=10000;
        if(n<arr.size()-1)           
            c2=dp[n+1][m];
        
        
        int anss=min(c1,c2)+arr[n][m];
        dp[n][m]=anss;
        
               }
           }           
           return dp[0][0];     
    }

    void minPathSum(vector<vector<int>>& grid) {
        vector<vector<int>>dp(grid.size(),vector<int>(grid[0].size(),0));
       //cout<< ans(grid,0,0,0,dp)<<endl;
       display(dp);
    }
    int minPathSumDP(vector<vector<int>> &arr)
{
    int n = arr.size();
    int m = arr[0].size();
    for (int i = n - 1; i >= 0; i--)
    {
        for (int j = m - 1; j >= 0; j--)
        {
            if (i == n - 1 && j == m - 1)
            {
                continue;
            }

            int c1 = j + 1 < m ? arr[i][j + 1] : 1e6;
            int c2 = i + 1 < n ? arr[i + 1][j] : 1e6;

            int minCost = min(c1, c2);
            arr[i][j] += minCost;
        }
    }

    cout<< arr[0][0]<<endl;
    display(arr);
}
    int main(){
        int m=3;
        int n=3;
        
        vector<vector<int>>dp(m,vector<int>(n,0));
        vector<vector<int> > vect{ { 1, 3, 1 }, 
                               { 1, 5, 1 }, 
                               { 4, 2, 1 } }; 
    // minPathSumDP(vect);
   //  minPathSum(vect);
    //  cout<<ans(vect,0,0,dp);
    //  display(dp);
    cout<<ansDP(vect,2,2,dp);
    display(dp);
    }