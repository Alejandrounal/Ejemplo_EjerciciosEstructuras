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
public class Solution_25_QHEAP {
    
   static private class PriorityQueue {
    private long array[];
    private int size;

    public PriorityQueue(int n) {
        array = new long[n];
        this.size = 0;
    }
    
    public void inserItem(long item){
        array[size] = item;
        moveUp();
        size++;
    }
    
    private void moveUp(){
        int child = size;
        int parent = (child-1)/2;
        long temp = array[child];
        while(child > 0 && temp < array[parent]){
            array[child] = array[parent];
            child = parent;
            parent = (child-1)/2;
        }
        array[child] = temp;
    }
    
    public long removeMin(){
        long min = array[0];
        array[0] = array[--size];
        moveDown();
        return min;
    }
    
    private void moveDown(){
        boolean flag = false;
        long smallest = -1;
        int parent = 0;
        int child = 2*parent+1;
        long temp = array[parent];
        while(child < size && !flag){
            smallest = array[child];
            if(child+1 < size && array[child+1] < array[child])
                smallest = array[++child];
            if(smallest < temp){
                array[parent] = smallest;
                parent = child;
            }
            else
                flag = true;
            child = 2*parent+1;
        }
        array[parent] = temp;
    }
    
    public void delete(long item){
        for (int i = 0; i < size-1; i++) {
            if(array[i] == item){
                  //System.out.println("el numero que se elimina es:   " + item);
                  int j = i;
                  int p = j;
                  while(j < size){
                      array[j] = array[j+1];
                      j++;
                  }
                  size--;
                  break;
            }
         }
    }
    
 }
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        PriorityQueue heap = new PriorityQueue(n);
        for (int i = 0; i < n; i++) {
          String entrada = scan.nextLine();
          String[] entArray = entrada.split(" ");
            switch(Integer.parseInt(entArray[0])){
                case 1:
                    heap.inserItem(Long.parseLong(entArray[1]));
                    break;
                case 2:
                    heap.delete(Long.parseLong(entArray[1]));
                    break;
                case 3:
                    System.out.println(heap.removeMin());
                    break;
                default:
                    System.out.println("No se encontro el comando");
                    break;
            }
        }
    }
}
