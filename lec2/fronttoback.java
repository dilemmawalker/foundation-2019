import java.util.Scanner;
public class fronttoback
{
    public static Scanner scn=new Scanner(System.in);
public static void main(String [] args)
{
    int n=0,n1=0,a=1,c=0;
System.out.println("enter the no. and rotation");
n=scn.nextInt();

n1=n;

int r=scn.nextInt();
int no=noOfDigits(n);

r=r%no;
if(r<0)
r=r+no;

    for(int i=1;i<=r;i++)
    { a=1;
while(n1!=0)
{
    if(n1<10)
    {
    c=n1%10;
    a=a*c;
    }
    a=a*10;
    n1=n1/10;
}
n=n-a/10;
n=n*10+c;
n1=n;
}

System.out.println("the ans is "+n);
}
public static int noOfDigits(int n)
{
    int count=0;
    while(n!=0)
    {
        n/=10;
        count++;
    }
    return count;
}
    

}