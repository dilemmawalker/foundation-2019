import java.util.ArrayList;
import java.util.Scanner;
public class returntype{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String []args){
        String str="iihithhhiiiiihitih";
       // String a=removehi(str);
       // System.out.print(a);
      // String a=hit(str);
       //System.out.print(a);
      // String arr=new string();
      // check(str,arr,)
      int sr=0,sc=0,er=2,ec=2;
      
  System.out.print(mazepath(sr,sc,er, ec));
 
    }
   /* public static arraylist<String>subseq(String str){
        subseq(String str){
            char ch=str.charAt(0);
            String ros=str.substring(1);
            ArrayList<String>recans=subseq(ros);
            ArrayList<String>myans=new ArrayList<>();
            myans.addA;
            for(String s:recans){
                myans.add(ch+s);
            }
            return myans;
        }*/
        public static String removehi(String ques){
            if(ques.length()==0)
            return "";
            if(ques.length()>1 && ques.substring(0,2).equals("hi"))
            return removehi(ques.substring(2));
            else
            {
                char ch=ques.charAt(0);
                return ch+removehi(ques.substring(1));
            
            }
        }
            public static String hit(String ques){
                if(ques.length()==0)
                return "";
                if(ques.length()>1 && ques.substring(0,2).equals("hi"))
                {
                    if(ques.charAt(2)=='t')
                        return ques.substring(0,3)+hit(ques.substring(3));
                    else{
                        return hit(ques.substring(2));
                    }
                }
                else {
                    char ch=ques.charAt(0);
                    return ch+hit(ques.substring(1));
                }

            }
            public static ArrayList<String> mazepath(int sr,int sc,int er,int ec){
           if(sr==er&&sc==ec){
               ArrayList<String> arr=new ArrayList<String>();
               arr.add(" ");
               return arr;
           }
             
             ArrayList<String> ans=new ArrayList<>();
             if(sc+1<=ec){
                 ArrayList<String> horizontal=mazepath(sr,sc+1,er,ec);
                 for(String s:horizontal){
                     ans.add("h"+s);
                 }
                 }
                 if(sr+1<=er){
                 ArrayList<String> vertical=mazepath(sr+1,sc,er,ec);
              for(String s:vertical){
                  ans.add("v"+s);
              }
                 }
                 return ans;
             }

            }

            
