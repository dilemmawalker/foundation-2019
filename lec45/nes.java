import java.util.ArrayList;
public class nes{
  private  static int a=0;
    private static ArrayList<Integer>arr=new ArrayList<>();
    
    nes(){
       this.arr=new ArrayList<>();
   }
   public static void main(String[]args){
        solve();  
    }
   public static void solve(){
      // System.out.print(a+20);
        arr.add(10);
         System.out.print(arr.get(0));
    }
}