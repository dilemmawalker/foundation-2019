import java.util.ArrayList;
public class client{
    public static void main(String[]args){
        hashmap obj=new hashmap();
        obj.put(3,100);
        obj.put(13,50);
        obj.put(23,100);
        obj.put(6,50);
        obj.put(7,100);
        obj.put(8,50);
        obj.put(9,100);
        obj.put(10,50);
        obj.remove(8);
        System.out.println(obj);
        ArrayList<Integer>arr=obj.keySet();
        System.out.println(arr);
    }
}