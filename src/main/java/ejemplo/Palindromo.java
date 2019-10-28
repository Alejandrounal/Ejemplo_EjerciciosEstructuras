/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;
import java.io.*;
import java.util.*;
/**
 *
 * @author Alejandro
 */
public class Palindromo {
    
    public static boolean palin(String a){
        char[] b = a.toCharArray();
        char[] c = new char[b.length]; 
        for (int i = 0; i < c.length; i++) {
            c[i] = b[b.length-(i+1)];
        }
        String ca = new String(c);
        return a.equals(ca);
    }
    
    public static void result(boolean r){
        if(r)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        result(palin(A));
    }
}