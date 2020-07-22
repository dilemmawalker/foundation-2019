import java.util.Scanner;
import java.util.ArrayList;
public class maze{
    public static void main(String [] args){
       // mazediagonal(0,0,2,2,""); 
       mazemulti(0,0,2,2,"");
    }
    public static void mazediagonal(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);   
            return;
        }
        if(sr<er && sc<ec){
            mazediagonal(sr+1,sc+1,er,ec,ans+"d");
        }
        if(sr<er){
            mazediagonal(sr+1,sc,er,ec,ans+"v");
        }
        if(sc<ec){
            mazediagonal(sr,sc+1,er,ec,ans+"h");
        }
        return;
    }
    public static void mazemulti(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);   
            return;
        }
          for(int i=1;i<=ec-sc && i<=er-sr;i++){
                if(sr<er && sc<ec)
            mazediagonal(sr+i,sc+i,er,ec,ans+"d"+i);
        }
            for(int j=1;j<=er-sr;j++){
            if(sr<er)
            mazediagonal(sr+j,sc,er,ec,ans+"v"+j);
        }
            for(int k=1;k<=ec-sc;k++){
            if(sc<ec)
            mazediagonal(sr,sc+k,er,ec,ans+"h"+k);
        }
        return;
    }
}