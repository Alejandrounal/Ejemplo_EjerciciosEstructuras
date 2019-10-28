
package ejemplo;
import java.io.*;
import java.util.*;
/**
 *
 * @author Alejandro
 */
public class SubArray {
    public static int subSumArray(int[] a){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                if(a[i]+a[j] < 0)
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       int n = scan.nextInt();
       int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
       
        
    }
}
