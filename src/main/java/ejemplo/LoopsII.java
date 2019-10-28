package ejemplo;
import java.util.Scanner;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;



public class LoopsII {
  
    public static void serie(int a, int b, int n){
        int sum = a;
        for (int i = 0; i < n ; i++) {
            sum += Math.pow(2, i)*b;
            System.out.print(sum+" ");
        }
        System.out.println("");
        }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            serie(a,b,n);
        }
        in.close();
    }
}

    
    


