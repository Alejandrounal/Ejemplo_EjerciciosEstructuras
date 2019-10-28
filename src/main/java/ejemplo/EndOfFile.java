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
public class EndOfFile {
    
 public static void main(String[] args) {
       Scanner i = new Scanner(System.in);
       int cont = 1;
       while(i.hasNext()){
           String p = i.nextLine();
           System.out.println(cont+" "+p);
           cont++;
        }
    }
}
