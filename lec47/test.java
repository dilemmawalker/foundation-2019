import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class test{
    
    public static  void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        System.out.print(a+50);
    }
}
