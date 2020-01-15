/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_Bonus;

import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class Solution15_PrintLevelTree {
static class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }
    
}

 static class NodeNode{
    private NodeNode next,prev;
    private Node data;

    public NodeNode() {
        this(null);
    }

    public NodeNode(Node node) {
        this.data = data;
        this.next = null;
    }

    public NodeNode getNext() {
        return next;
    }

    public void setNext(NodeNode next) {
        this.next = next;
    }

    public Node getData() {
        return data;
    }

    public void setData(Node data) {
        this.data = data;
    }

    public NodeNode getPrev() {
        return prev;
    }

    public void setPrev(NodeNode prev) {
        this.prev = prev;
    }
}

static class LinkedQueueNode{
    private NodeNode front, rear;
    private int elementos;

    public LinkedQueueNode() {
        this.front = null;
        this.rear = null;
    }
    
    public boolean enqueue(Node item){
        NodeNode newp = new NodeNode(item);
        if(rear!=null){
            rear.setNext(newp);
        }else{    
            front = newp;
        }
        rear = newp;
        elementos++;
        return true;
    }
    
    public Node dequeue(){
       Node result = null;
       if(!empty()){
             result = (Node)front.getData();
             if(front.getNext() == null)
                 front = null;
             else
                 front= front.getNext();
             elementos--;
       }return result;
    }
    
    public boolean empty(){
        return front==null;
    }
    
    public void pritnLinkedQueue(){
        while(!empty())
            System.out.println(dequeue());
    }

    public int elementos(){
        int contador =  1;
        NodeNode actual = front;
        while (actual.getNext() != null){
            actual = actual.getNext();
        contador++;
        }return contador;
       }
    }

    public static void levelOrder(Node root){
         if(root == null)
            return;
        LinkedQueueNode queue  = new LinkedQueueNode();
        System.out.println(root.data);
        queue.enqueue(root);
        System.out.println(queue.dequeue().data);
        while(true){
            int nivel = queue.elementos();
            if(nivel == 0)
                break;
            while(nivel > 0){
                Node node =null; //(Node)queue.dequeue();
                
                System.out.print(node.getData()+ " ");
                if(node.left != null)
                    queue.enqueue(node.left);
                if(node.right != null)
                    queue.enqueue(node.right);
                nivel--;
            }
            System.out.println("");
        }  
    }
    
    public static void main(String[] args) {
        Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
                
                Scanner scan = new Scanner(System.in);
                //int num = scan.nextInt();
                
                
                
		System.out.println(" Output by Better Approach : ");
		levelOrder(root);
    }
}
