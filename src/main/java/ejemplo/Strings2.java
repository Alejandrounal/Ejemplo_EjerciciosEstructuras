/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;
import java.util.Scanner;
/**
 *
 * @author Alejandro
 */
public class Strings2 {
      public static String getSmallestAndLargest(String s, int k) {
        String smallest = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i=0 ; i < s.length() - (k-1);i++){
            String sub = s.substring(i,i+k);
            if(sub.compareTo(smallest) <0)
                smallest = sub; 
            if(sub.compareTo(largest) >0)
                largest = sub;
        }
        return smallest + "\n" + largest;
    }
     
public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
    