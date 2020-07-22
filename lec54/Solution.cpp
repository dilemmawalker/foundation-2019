class Solution {
    public int coinChange(int[] coins, int amount) {
        int[]dp=new int[amount+1];
        Arrays.fill(dp,-1);
       int a=ans(coins,amount,dp,0);
        if(a!=100000)
            return a;
        else
            return -1;
    }
    int ans(int[]arr,int tar,int[]dp,int val){
        if(tar==0){
            return val; 
        }
       
         // if(dp[tar]!=-1)
         //    return dp[tar];
        int count=100000;
        for(int i=0;i<arr.length;i++){
            if(tar-arr[i]>=0)
                count=Math.min(count+1,ans(arr,tar-arr[i],dp,val+1));
        }
        dp[tar]=count;
         return dp[tar];
}
}
   