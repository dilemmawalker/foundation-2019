import java.util.*;
class Solution {
    public static int numSteps(String s) {
        int no=ans(s);
    }
    public static int ans(String str){
        while(str.length()>0){
            char ch=str.charAt(0);
            int a=ch-'0';
            str=str.substring(1);
        }
    }
}

    public static void main(String[]args){
        // int[]nums={4,3,10,9,8};
           System.out.print(  longestDiverseString(1,1,7)  );
    }
}