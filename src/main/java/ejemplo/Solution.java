package ejemplo;

import java.io.*;
import java.util.*;
/**
 *
 * @author Alejandro
 */
public class Solution {
    
  static class NodeGeneric {
    private NodeGeneric next,prev;
    private int data;

    public NodeGeneric() {
        this(0);
    }

    public NodeGeneric(int data) {
        this.data = data;
        this.next = null;
    }

    public NodeGeneric getNext() {
        return next;
    }

    public void setNext(NodeGeneric next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeGeneric getPrev() {
        return prev;
    }

    public void setPrev(NodeGeneric prev) {
        this.prev = prev;
    }
}  
    ////////////////////////////////////////////////////////////////////////////
   static class LinkedQueueGeneric {
    private NodeGeneric front, rear;

    public LinkedQueueGeneric() {
        this.front = null;
        this.rear = null;
    }
    
    public boolean enqueue(int item){
        NodeGeneric newp = new NodeGeneric(item);
        if(rear!=null){
            rear.setNext(newp);
        }else{    
            front = newp;
        }
        rear = newp;
        
        return true;
    }
    
    public boolean enqueueFirst(int item){
        boolean pushed =false;
        NodeGeneric newp = new NodeGeneric(item);
        newp.setNext(front);
        front = newp;
        return true;  
    }
    
    public int dequeue(){
       int result = 0;
       if(!empty()){
             result = front.getData();
             if(front.getNext() == null)
                 front = null;
             else
                 front= front.getNext();
       }return result;
    }
    
    public boolean empty(){
        return front==null;
    }
    
    public void pritnLinkedQueue(){
        while(!empty())
            System.out.println(dequeue());
    }
    }
   ///////////////////////////////////////////////////////////////////////////////////
   static class LinkedStackGeneric {
    private NodeGeneric top;

    public LinkedStackGeneric() {
        this.top = null;
    }
    
    public boolean push(int item){
        boolean pushed =false;
        NodeGeneric newp = new NodeGeneric(item);
        newp.setNext(top);
        top = newp;
        return true;
    }
    
    public int pop(){
        int result = 0;
        if(top!= null){
            result = top.getData();
            top = top.getNext();
        }return result;
    }
    
    public boolean empty(){
        return top == null;
    }
    
    public void printLinkedStack(){
        while(!empty())
            System.out.println(pop());
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
  
    static LinkedQueueGeneric llenar(String[] list){
       LinkedQueueGeneric pesas = new LinkedQueueGeneric();
        for (int i = 0; i < list.length; i++) {
            pesas.enqueue(Integer.parseInt(list[i]));
        }return pesas;
    }
    
    static LinkedQueueGeneric ordenar(LinkedQueueGeneric pesas, int num){
        LinkedStackGeneric soporte =  new LinkedStackGeneric();
        LinkedQueueGeneric orden = new LinkedQueueGeneric();
        while(num > 1){
           int p1 = pesas.dequeue(); 
           int p2 = pesas.dequeue();
           if(p1>=p2)
               soporte.push(p1);
           if(p2>p1){ 
               orden.enqueue(p1);
               int ps = Integer.MAX_VALUE;
               if (!soporte.empty()) {
                   ps = soporte.pop();
               }
               else if(ps<=p2){
                   orden.enqueue(ps);
               }else
                   soporte.push(ps);    
            }
           pesas.enqueueFirst(p2);
           num--;
           if(num == 1)
              orden.enqueue(p2);    
        }if(!soporte.empty())
            orden.enqueue(soporte.pop());
        return orden;
    }    
    
    static boolean activo(LinkedQueueGeneric orden){
        boolean result = true;
        int val = orden.dequeue();
        while(!orden.empty()){
            int val2 = orden.dequeue();
            if(val >= val2){ 
                result = false;
                break;
            }val = val2;
        }return result;
    }
   
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        for (int i = 0; i < N; i++) {
            int p = s.nextInt();
            s.nextLine();
            String[] pesas = s.nextLine().split(" ");
            ordenar(llenar(pesas),p).pritnLinkedQueue();
            if(activo(ordenar(llenar(pesas),p)))
                System.out.println("Activo");
            else
                System.out.println("No activo");
     }
    }
}       
        
