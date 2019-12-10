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


public class Solution9_Maximun {
   static class Node {
    private Node next;
    private int data;
    private Node prev;

    public Node() {
        this(0);
    }

    public Node(int data) {
        this.next = null;
        this.data = data;
       
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
   
}//////////////////////////////////////////////Aqui finaliza el stack
    static class LinkedStack {
    private Node top;

    public LinkedStack() {
        this.top = null;
    }
    
    public boolean push(int item){
        boolean pushed =false;
        Node newp = new Node(item);
        newp.setNext(top);
        top = newp;
        return true;
    }
    
    public int pop(){
        int result = -1;
        if(top!= null){
            result = top.getData();
            top = top.getNext();
        }return result;
    }
    
    public int  top(){
        if(empty())
            return 0;
        else 
            return top.getData();
    }
    
    public boolean empty(){
        return top == null;
    }
    
}////////////Fin de la clase
    static void insertar(LinkedStack s, LinkedStack m, int item){
        s.push(item);
        if(m.empty() || item > m.top())
            m.push(item);
    }
    
    static void eliminar(LinkedStack s, LinkedStack m){
        if(!s.empty()){ 
            if(s.top() == m.top()){
                m.pop();
            }s.pop();
        }
    }
    static int maximo(LinkedStack m){//metodo que saca el maximo de la pila maximo.
        return m.top();
    }
    
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        LinkedStack maximo = new LinkedStack();
        Scanner scan = new Scanner(System.in);
        int querys = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < querys; i++) {
            int accion = scan.nextInt();
            if(accion == 1){
               insertar(stack,maximo,scan.nextInt());
            }
            if(accion == 2){
                eliminar(stack,maximo);
            }
            if(accion == 3){
                System.out.println(maximo(maximo));
            }
            if(scan.hasNextLine())
                scan.nextLine();
        }
    }

}