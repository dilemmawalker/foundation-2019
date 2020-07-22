/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static Scanner scn=new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
	    ans();
		
	}
	public static void ans(){
	    int t=scn.nextInt();
	    for(int i=1;i<=t;i++){
	        String s=scn.next();
	        int k=scn.nextInt();
	        int x=scn.nextInt();
	        String str="";
	        boolean flag=false;
	        boolean flag2=false;
	       
	        for(int j=0;j<s.length();j++){
	            char ch=s.charAt(j);
	            int n=str.length();
	            while(--n>0){
	                char c=str.charAt(n);
	                if(c==ch){
	                    flag2=true;
	                    if(--k<0){
	                        flag=true;
	                    break;
						}
						break;
					}
	            }
	            if(flag==false && flag2==false){
	                str+=ch;
	            }
	            else if(flag==true){
	            
	            break;
	            }
	        }
	       System.out.println(str.length());
	        
	        
	    }
	}
	
}
