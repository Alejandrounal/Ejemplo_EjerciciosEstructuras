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
public class Strings {
    
    public static int sum(String a, String b){
        return a.length() + b.length();
    }
    
    public static String compar(String a, String b){
        if(a.compareTo(b) > 0)
            return "Si";
        else
            return "No";
    }
        
    public static String mayuscula(String a){
        return a.substring(0,1).toUpperCase() + a.substring(1,a.length());
    }
    
    
     public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(sum(A,B)+"\n"+compar(A,B)+"\n"+mayuscula(A)+" "+mayuscula(B));
        
    }
}

