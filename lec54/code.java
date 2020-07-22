import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.util.Pair; 


class code{
   
   public static int targetsum(int[]arr,int tar,int[][]dp,int idx){    //incorrect as we cannot apply for loop in here,
                                                                       //  will give extra calls.
        if(tar==0){
         dp[idx][tar]=1;
         return 1;
        }
        
        // if(dp[idx][tar]!=0){
        //     return dp[idx][tar];
        // }
        int count=0;
        for(int i=idx;i<arr.length;i++){
            if(tar-arr[i]>=0){
                count+=targetsum(arr,tar-arr[i],dp,i+1);
            }
            count+=targetsum(arr,tar,dp,i+1);
        }
       return dp[idx][tar]=count;
        
    }
    public static int targetsum1(int[]arr,int tar,int[][]dp,int idx){
        if(tar==0){
         dp[idx][tar]=1;
         return 1;
        }
        
        // if(dp[idx][tar]!=0){
        //     return dp[idx][tar];
        // }
        if(idx==arr.length)
        return 0;
        int count=0;
       
            if(tar-arr[idx]>=0){
                count+=targetsum1(arr,tar-arr[idx],dp,idx+1);
            }
            count+=targetsum1(arr,tar,dp,idx+1);
       return dp[idx][tar]=count;
        
    }

    

    public static int targetsumDP(int[]arr,int tar,int[][]dp,int idx){
        dp[0][0]=1;                 //if zero append at 0 index of coins array.
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<=tar;j++){
                if (j == 0)
            {
                dp[i][j] = 1;
                continue;
            }
                if(j-arr[i]>=0)
                dp[i][j]+=dp[i-1][j-arr[i]];
                dp[i][j]+=dp[i-1][j];

            }
        }
        return dp[arr.length-1][tar];   
}

 public static int knapsack(int cap,int idx,int[]weight, int[]cost, int [][]dp){
      if(idx==-1 || cap==0)
      return 0;

    //   if(dp[idx][cap]!=0)
    //   continue;

    int picked=0;
    int unpicked=0;
    if(cap-weight[idx]>=0)
    picked=knapsack(cap-weight[idx],idx-1,weight,cost,dp)+cost[idx];
    unpicked=knapsack(cap,idx-1,weight,cost,dp);

    return dp[idx][cap]=Math.max(picked,unpicked);
 }

 public static int knapsackDP(int cap,int i,int[]weight, int[]cost, int [][]dp){
   
    for(int idx=1;idx<weight.length;idx++){
         for(int j=0;j<=cap;j++){
            int picked=0;
    int unpicked=0;
    if(j-weight[idx-1]>=0)
        picked=dp[idx-1][j-weight[idx-1]]+cost[idx-1];
        unpicked=dp[idx-1][j];
            dp[idx][j]=Math.max(picked,unpicked);
         }
     }
     return dp[dp.length-1][dp[0].length-1];
    }

    public static int unboundedknapsack(int[]weight,int[]cost,int cap,int[]dp){
        dp[0]=0;
        for(int i=0;i<weight.length;i++){
            for(int j=1;j<=cap;j++){
                int picked=0;
                if(j-weight[i]>=0)
                picked=dp[j-weight[i]]+cost[i];
                int unpicked=dp[j];
                dp[j]=Math.max(picked,unpicked);
            }
        }
        return dp[cap];
    }

    public static boolean[][] palindromestring(String str){
        boolean[][]dp=new boolean[str.length()][str.length()];
        for(int gap=0;gap<str.length();gap++){
            for(int i=0,j=gap;j<str.length();i++,j++){
                if(gap==0)
                dp[i][j]=true;
               else if(str.charAt(i)==str.charAt(j)){
                if(gap==1)
                dp[i][j]=true;
                else if(dp[i+1][j-1])
                dp[i][j]=true;

                }
            }
        }
        return dp;
       // display2dboolean(dp);
    }
    public static void longestpalindromesubstring(String str){

        boolean[][]ispal=palindromestring(str);
        int[][]dp=new int[str.length()][str.length()];
        for(int gap=0;gap<=str.length();gap++){
            for(int i=0,j=gap;j<str.length();i++,j++){
                if(gap==0)
                dp[i][j]=1;
               else if(str.charAt(i)==str.charAt(j) && gap==1)
                dp[i][j]=2;
                else if(str.charAt(i)==str.charAt(j) && ispal[i+1][j-1])
                    dp[i][j]=dp[i+1][j-1]+2;
                
                    else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                
            }
        }
        display2d(dp);
    }

    // public static void countpalindromesubsequence(String str){

    //     for(int gap=0;gap<str.length();gap++){
    //         for(int i=0,j=gap;j<str.length();j++,i++){
    //             if(gap==0)
    //             dp[i][j]=1;
    //             else if(str.charAt(i)==str.charAt(j)){
    //                 dp[i][j]+=dp[i+1][j-1]+1;               //when both first and last character is included
    //                 dp[i][j]+=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];       //when only one characer is included

    //             }
    //             else
    //             dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
    //         }
    //     }
    //     return dp[0][str.length()-1];
    // }


    public static void longestpalindromesubsequence(String str){
        int[][]dp=new int[str.length()][str.length()];
        for(int gap=0;gap<=str.length();gap++){
            for(int i=0,j=gap;j<str.length();i++,j++){
                if(gap==0)
                dp[i][j]=1;
                else if(str.charAt(i)==str.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                    else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                
            }
        }
        display2d(dp);
    }

    public static int longestincreasingsubsequence(int[]arr,int idx,String ans){
        if(idx==arr.length){
            //System.out.print(ans+" ");
          //  return ans;
          return 1;
        } 
        int count=0;
        count+=longestincreasingsubsequence(arr,idx+1,ans);
       
        for(int i=idx+1;i<arr.length;i++){
            if(arr[i]>arr[idx]){
                count+=longestincreasingsubsequence(arr,i,ans+arr[i]);
            }
        }
        return count;
    }

    public static int[] LIS(int []arr){
        int max=0;
        int[]dp=new int [arr.length];
        Arrays.fill(dp,1);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);         
        }
        //  display(dp);
        //  System.out.println();
        return dp;
    }

    public static int[] LDS(int[]arr){
            int max=0;
            int[]dp=new int [arr.length];
            Arrays.fill(dp,1);
            for(int i=arr.length-2;i>=0;i--){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i]<arr[j]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                max=Math.max(max,dp[i]);         
            }
            //  display(dp);
            //  System.out.println();
            return dp;
        }

        public static int LBS(int[]arr){
            int[]LI=LIS(arr);
            int[]LD=LDS(arr);
            int[]LB=new int[arr.length];

            int max=1;
            for(int i=0;i<arr.length;i++){
                LB[i]=LI[i]+LD[i]-1;
                max=Math.max(max,LB[i]);
            }
            display(LB);
            System.out.println();
            return max;

        }
        public static int LISmax=0;
        public static int LIS_rec(int[]arr,int ei,int[]dp){
            if(ei==0)
            return 1;

            int max=1;
            for(int i=ei-1;i>=0;i--){
                int recans=LIS_rec(arr,i,dp);
                if(arr[i]<arr[ei]){
                    LISmax=Math.max(LISmax,recans+1);
                    max=Math.max(max,recans+1);
                }
            }
            dp[ei]=max;
            return max;
        }


      public static int[] maximumSumSubsequnece(int[]arr)
{
    int[] dp=new int[arr.length];
    int max = 1;
    for (int i = 1; i < arr.length; i++)
    {
        dp[i] = arr[i];
        for (int j = 0; j < i; j++) // har ek j cell uss tak ka maximum increasing subsequence store krke apne pass rakhta hai.
        {
            if (arr[i] > arr[j]) // agar i cell j se bada hoga to length ek se increase hojayegi.
            {
                dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }
        max = Math.max(max, dp[i]);
    }

    // cout << max << endl;
    return dp;
}

// Minimum number of deletion to make sorted sequence.
int minimumDeletion(int[]arr)
{
    int[] dp=new int[arr.length];
    int max = 1;
    for (int i = 1; i < arr.length; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (arr[i] >= arr[j]) // for equal numbers.
            {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        max = Math.max(max, dp[i]);
    }

    return arr.length - max;
}

// non - verlapping bridges.
// russian doll.
// activity selection.

public static int minchainmatrix(int[]arr,int si,int ei,int[][]dp){
if(si+1==ei){
return 0;
}
int left;
int right;
int max=100000;
int mycost=0;
for(int cut=si+1;cut<ei;cut++){
left=minchainmatrix(arr,si,cut,dp);
right=minchainmatrix(arr,cut,ei,dp);
mycost=left+  arr[si]*arr[cut]*arr[ei]  +right;
if(mycost<max){
    max=mycost;
}
}
return max;
}

// public static Pair<Integer,String> MCM_memostring(int[]arr,int si,int ei,Pair<Integer,String>[][]dp){

//     if(si+1==ei){
//         String str=(char)(si+'A')+"";
//        return dp[si][ei]={0,str};
        
//     }
//     if(dp[si][ei]!=0)
//     return dp[si][ei];

//     Pair<Integer,String>minans={10000000,""};
//     for(int cut=si+1;cut<ei;cut++){
//         Pair<Integer,String>left=MCM_memosubstring(arr,si,cut,dp);
//         Pair<Integer,String>right=MCM_memosubstring(arr,cut,ei,dp);

//         int mycost=left.first+arr[si]*arr[cut]*arr[ei]+right.first;
//         if(mycost<minans){
//             minans.first=mycost;
//             minans.second="("+left.second+right.second+")";
//         }
//     }
//     dp[si][ei]=minans;
//     return minans;

// }

public static int mcm_dp(int []arr ,int[][]dp){
    String [][]sdp=new String[arr.length][arr.length];
    for(int gap=1;gap<arr.length;gap++){
        for(int si=0,ei=gap;ei<arr.length;si++,ei++){
            if(si+1==ei){
                sdp[si][ei]=(char)(si+'A')+"";
                continue;
            }
            int minans=10000000;
            for(int cut =si+1;cut<ei;cut++){
                int left=dp[si][cut];
                int right=dp[cut][ei];
                int mycost=left+arr[si]*arr[cut]*arr[ei]+right;
                if(mycost<minans){
                    dp[si][ei]=mycost;
                    minans=mycost;
                    sdp[si][ei]="("+sdp[si][cut]+sdp[cut][ei]+")";
                }
            }
        }
    }
    System.out.println(sdp[0][arr.length-1]+"->"+dp[0][arr.length-1]);
    return dp[0][arr.length-1];
}

public static int minpalindromiccut_rec(String str,int si,int ei,int[][]dp,boolean[][]ispal){
    if(ispal[si][ei]){
        dp[si][ei]=0;
        return 0;
    }
   if( dp[si][ei]!=0)
   return dp[si][ei];

   int min=10000000;
   for(int cut=si;cut<ei;cut++){
    int left=minpalindromiccut_rec(str, si,cut,dp,ispal);
    int right=minpalindromiccut_rec(str,cut+1,ei,dp,ispal);
    min=Math.min(min,left+1+right);
}
dp[si][ei]=min;
return min;
}

public static int minpalindromiccut_dp(String str,int[][]dp,boolean[][]ispal){
    for(int gap=1;gap<str.length();gap++){
        for(int si=0,ei=gap;ei<str.length();si++,ei++){
            if(ispal[si][ei]){
                dp[si][ei]=0;
                continue;
            }
            int min=10000000;
            for(int cut=si;cut<ei;cut++){
                int left=dp[si][cut];
                int right=dp[cut+1][ei];
                min=Math.min(min,left+1+right);
            }
            dp[si][ei]=min;
        }
    }
    return dp[0][str.length()-1];
}

public static int burstbaloon(int []arr, int si,int ei,int[][]dp){
   if(dp[si][ei]!=0)
   return dp[si][ei]; 

   int l=(si-1)==-1?1:arr[si-1];
   int r=(ei+1)==arr.length?1:arr[ei+1];
   int max=0;
   for(int cut=si;cut<=ei;cut++){
    int left=(cut==si)?0:burstbaloon(arr,si,cut-1,dp);
    int right=(ei==cut)?0:burstbaloon(arr,cut+1,ei,dp);

    int cost=left  + l*arr[cut]*r  + right;
    max=Math.max(max,cost);
   }
   dp[si][ei]=max;
   return max;
}

public static int burstbaloonDP(int []arr,int si,int ei,int[][]dp){
    
    for(int gap=0;gap<arr.length;gap++){
        for(si=0,ei=gap;ei<arr.length;si++,ei++){

            int l=(si-1==-1)?1:arr[si-1];
            int r=(ei+1==arr.length)?1:arr[ei+1];
            int max=0;

            for(int cut=si;cut<=ei;cut++){
                int left=(cut==si)?0:dp[si][cut-1];
                int right=(cut==ei)?0:dp[cut+1][ei];
                int mycost=left + l*arr[cut]*r + right;
               max=Math.max(max,mycost);
            }
            dp[si][ei]=max;
        }
    }
    return dp[0][arr.length-1];
}

public static int sumInRange(int[]freq, int si, int ei)
{
    int sum = 0;
    for (int i = si; i <= ei; i++)
    {
        sum += freq[i];
    }
    return sum;
}

public static int OBST(int[]keys,int[]freq, int si, int ei, int[][]dp, int[]psum)
{
    if (dp[si][ei] != 0)
        return dp[si][ei];

    int minCost =(int) 1e8;
    for (int cut = si; cut <= ei; cut++)
    {
        int left = (cut == si) ? 0 : OBST(keys, freq, si, cut - 1, dp, psum);
        int right = (cut == ei) ? 0 : OBST(keys, freq, cut + 1, ei, dp, psum);

        // int myCost = left + sumInRange(freq, si, ei) + right;   //O(n^4)
        int myCost = left + (psum[ei] - ((si - 1) >= 0 ? psum[si - 1] : 0)) + right; //O(n^3)
        minCost = Math.min(minCost, myCost);
    }

    return dp[si][ei] = minCost;
}

// public static int LCS(String s1,String s2,String ans){
//     if(s1.length()==0 && s2.length()==0)
//     return 0;


// }

public static int nooftimesoccurance(String s1,String s2){
    if(s2.length()==0)
    return 1;
    if(s1.length()==0)
    return 0;

    int count=0;
    char ch1=s1.charAt(0);
    char ch2=s2.charAt(0);
    if(ch1==ch2)
    count+=nooftimesoccurance(s1.substring(1),s2.substring(1));
    count+=nooftimesoccurance(s1.substring(1),s2);
    return count;
}








 

    public static void main(String[] args){
       // int []arr={10,22,9,33,21,50,41,60,80};
      //  int[][]dp=new int[5][8];
      // int []dp=new int[8];
        // int[]weight={2,5,1,3,4};
        // int[]cost={15,14,10,45,30};
     // System.out.println( targetsumDP(arr,10,dp,0));
    //  System.out.println( knapsackDP(7,cost.length-1,weight,cost,dp));
   //  System.out.println( unboundedknapsack(weight,cost,7,dp));
  // String str="abbd";
    //    boolean[][]dp=new boolean[4][4];
 // palindromestring(str,dp);
// longestpalindromesubstring(str);
 //longestpalindromesubsequence(str);
   //  display(dp);
    //  display2d(dp);

    // for(int i=0;i<arr.length;i++){
    // System.out.println(longestincreasingsubsequence(arr,i,""));
    // }
    //     int ei=8;
    //     int[]dp=new int[9];
    // System.out.print(LIS_rec(arr,ei,dp));

    //     String str="abcbddf";
    // int []arr={40, 20, 30, 10, 30} ;
    // // int[][]dp=new int[arr.length][arr.length];

    //  int[][]dp=new int[str.length()][str.length()];

  //  System.out.print(minchainmatrix(arr,0,arr.length-1,dp));

//   Pair<Integer,String>[][]dp=new Pair<Integer,String>[arr.length][arr.length];
//     Pair<Integer,String>p= MCM_memostring(arr,0,arr.length-1,dp);
//     System.out.print(p.first+"->"+p.second);

      // System.out.print(mcm_dp(arr,dp));

    //   boolean[][]ispal=palindromestring("abcbddf");
    //   System.out.print(minpalindromiccut_dp("abcbddf",dp,ispal));

    // int[]arr={3,1,5,8};
    // int[][]dp=new int[arr.length][arr.length];
    // for(int i=0;i<arr.length;i++){
    //     for(int j=0;j<arr.length;j++){
    //         dp[i][j]=0;
    //     }
    // }
    // System.out.print(burstbaloonDP(arr,0,arr.length-1,dp));



    // int[] keys = {10, 12, 20};
    // int[] freq = {34, 8, 50};
    // int[][] dp=new int[keys.length][keys.length];
    // int[] psum=new int[freq.length];
    // for(int i=0;i<psum.length;i++)
    // psum[i]=0;

    // for (int i = 0; i < freq.length; i++)
    // {
    //     if (i != 0)
    //         psum[i] += psum[i - 1];
    //     psum[i] += freq[i];
    // }

    // System.out.println( OBST(keys, freq, 0, keys.length- 1, dp, psum));

    // display2d(dp);

    System.out.print(nooftimesoccurance("geeksforgeeks","gks"));


    }


    public static void display2dboolean(boolean[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
   
    public static void display2d(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void  display(int []arr){
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
    }
}