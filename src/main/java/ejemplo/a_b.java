/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
import java.math.BigInteger;

public class a_b {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            BigInteger a = new BigInteger(s.next());
            BigInteger b = new BigInteger(s.next());
            System.out.println(a.add(b));
            
        }


    }
}
