/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;
import java.io.*;
import java.util.*;

public class SubconjuntoUber {
    
    static int max(int[] arr){
        int max = 0;       
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] != arr[j]){
                    int num = arr[i]*arr[j];
                    if(num>max)
                        max=num;
                }
                    
            }
        }return max;
    }
    
   public static void main(String[] args) {
       
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
          arr[i] = scan.nextInt();
        }
       System.out.println(max(arr));
    
    } 
}
