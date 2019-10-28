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
public class Anagrama {

/*static boolean isAnagram(String a, String b) {
      String alow = a.toLowerCase();
      String blow = b.toLowerCase();
      char[] aArray = alow.toCharArray();
      char[] bArray = blow.toCharArray();
      
     
      
      Arrays.sort(aArray);
      Arrays.sort(bArray);
      
      
      String aString = new String(aArray);
      String bString = new String(bArray);
      
      
      return aString.equals(bString);
      
      
    }*/

    static boolean ana(String a, String b){
        boolean result = true;
        String alow = a.toLowerCase();
        String blow = b.toLowerCase();
        char[] aArray = alow.toCharArray();
        char[] bArray = blow.toCharArray();
        if(aArray.length != bArray.length)
            result = false;
        else{
            for (int i = 0; i < aArray.length; i++) {
                char element = aArray[i];
                int countA = 0;
                int countB = 0;
                for (int j = 0; j < aArray.length; j++) {
                    if(aArray[j] == element)
                        countA++;
                }
                for (int j = 0; j < bArray.length; j++) {
                    if(bArray[j] == element)
                        countB++;
                }
                if(countA == countB)
                    result = true;
                else
                    result = false;
            }
        }
        return result;
    }
    
public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = ana(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

