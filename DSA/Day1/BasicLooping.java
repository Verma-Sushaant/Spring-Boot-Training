import java.util.*;
public class BasicLooping {
    public static void pattern1(int n) {
        /*
        1 -> *
        2 -> **
        3 -> ***
        4 -> ****
        5 -> *****
        */
        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n) {
        /*
        1 ->     *
        2 ->    **
        3 ->   ***
        4 ->  ****
        5 -> *****
        */
        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<=n;j++) {
                if(j <= n-i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern3(int n) {
        /*
             123456789
        1 ->     *     [4,1,4]
        2 ->    ***    [3,3,3]
        3 ->   *****   [2,5,2]
        4 ->  *******  [1,7,1]
        5 -> ********* [0,9,0]
        */
        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<=(n-i);j++) {
                System.out.print(" ");
            }
            for(int j = 1;j<=((2*i)-1);j++) {
                System.out.print("*");
            }
            for(int j = 1;j<=(n-i);j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void pattern4(int n) {
        /* 
             123456789
        1 -> ********* [0,9,0]
        2 ->  *******  [1,7,1]
        3 ->   *****   [2,5,2]
        4 ->    ***    [3,3,3]
        5 ->     *     [4,1,4]
        */
        for(int i = 1;i<=n;i++) {
            for(int j = 0;j<=(i-1);j++) {
                System.out.print(" ");
            }
            for(int j = 1;j<=((2*(n-i))+1);j++) {
                System.out.print("*");
            }
            for(int j = 0;j<=(i-1);j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void printNTimes(int n) {
        for(int i = 1;i<=n;i++) {
            System.out.println(i);
        }
    }
    public static void printNTimesRev(int n) {
        for(int i = 1;i<=n;i++) {
            System.out.println(n-i+1);
        }
    }
    public static void a(int n) {
        
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        // pattern1(n);
        // pattern2(n);
        // pattern3(n);
        // pattern4(n);
        // printNTimes(n);
        // printNTimesRev(n);
    }
}