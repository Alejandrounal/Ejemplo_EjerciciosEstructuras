/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;
import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author Alejandro
 */
public class OrdenadoNOOrdenado {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){    
        int n = s.nextInt();
        if(n!=0){
        int[] arr = new int[n];
        boolean result = false; 
        for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<=arr[i+1])
                result = true;
            else{
                result = false;
                break;
            } 
        }
        if(result)
            System.out.println("Ordenado");
        else
            System.out.println("NO Ordenado");
        }}
    }
}
