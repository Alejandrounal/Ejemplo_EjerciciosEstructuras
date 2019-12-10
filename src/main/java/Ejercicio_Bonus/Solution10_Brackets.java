/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_Bonus;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 *
 * @author Alejandro
 */
public class Solution10_Brackets {
    

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
    } 
 // Complete the isBalanced function below.
    
    
    static String isBalanced(String s) {
      boolean resultado = true;
      LinkedStack stack = new LinkedStack();
      char[] exp = new char[s.length()];
      exp = s.toCharArray();
        for (int i = 0; i < exp.length; i++) {
            char bracket =  exp[i];
            if (bracket == '(' || bracket == '{' || bracket == '['){
                stack.push(bracket);
            }
            else{
                if(bracket == ')'){
                    bracket = '(';
                }
                else if(bracket == '}'){
                    bracket = '{';
                }
                else if(bracket == ']'){
                    bracket = '[';
                }
                
                
            if(stack.empty()){
               resultado = false;
               break;
            }
            if(bracket == stack.top()){
                stack.pop();
            }else{
                resultado = false;
                break;
            }
            }
        }
        if(resultado)
            return "YES";
        else
            return "NO";
    }  

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}