/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_Bonus;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 *
 * @author Alejandro
 */
public class Solution_25_QHEAP1_2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        PriorityQueue heap = new PriorityQueue(n);
        int [] arr =  new int [n];
        for (int p = 0; p < arr.length; p++) {
            arr[p] = Integer.MAX_VALUE;
        }
        int cont = 0;
        for (int i = 0; i < n; i++) {
          String entrada = scan.nextLine();
          String[] entArray = entrada.split(" ");
            switch(Integer.parseInt(entArray[0])){
                case 1:
                    arr[cont] = Integer.parseInt(entArray[1]);
                    cont++;
                    for (int j = 0; j < cont; j++) {
                        System.out.print(arr[j]+" ");
                    }
                    System.out.println("");
                    break;
                case 2:
                    for (int j = 0; j < arr.length; j++) {
                        if(arr[j] == Integer.parseInt(entArray[1])){
                            arr[j] = Integer.MAX_VALUE;
                        }
                    }
                    break;
                case 3:
                    int min = Integer.MAX_VALUE;
                    for (int j = 0; j < arr.length; j++) {
                        if(arr[j] < min)
                            min = arr[j];
                    }
                    for (int q = 0; q < arr.length; q++) {
                        if(arr[q] == min)
                            arr[q] = Integer.MAX_VALUE;
                    }
                    System.out.println(min);
                    break;
                default:
                    System.out.println("No se encontro el comando");
                    break;
            }
        }
    }
}
