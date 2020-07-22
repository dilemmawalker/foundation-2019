import java.util.Scanner;

public class find {
  public static Scanner scn = new Scanner(System.in);

  public static void main(String[] args) {

    int n = scn.nextInt();
    int[] arr = new int[n];

    input(arr);

  }

  public static int input(int[] arr) {

    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();

    }
    int data = scn.nextInt();
    System.out.print(find1(arr, data));

    return 0;
  }

  public static boolean find1(int[] arr, int data) {
    for (int i : arr) {
      if (i == data)
        return true;
    }
    return false;
  }
}