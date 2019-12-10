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
public class Solution7 {
     static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
    
    static SinglyLinkedListNode insert(SinglyLinkedListNode head, int pos, int data){
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if(head == null){
            head = node;
            return head;
        }
        else{
            SinglyLinkedListNode actual = head;
            for(int i = 1; i < pos; i++){
                actual = actual.next;
            }
            node.next = actual.next;
            actual.next = node;
            return head;
        }
    }
    static SinglyLinkedListNode delete(SinglyLinkedListNode head, int pos){
          SinglyLinkedListNode node = head;
        if (pos == 0){
        return node.next;
        }
        pos--;
        while (pos > 0){
        node = node.next;
        pos--;
        }
    node.next = node.next.next;
    return head;
    }
    
    static void printR(SinglyLinkedListNode p) { 
        if(p != null) {
            System.out.print(p.data+" ");
            printR(p.next);} 
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < L; i++) {
            list.insertNode(scan.nextInt());
        }
        scan.hasNextLine();// Hasta aca lee los elementos de la lista
       // Hasta aqui va vien
       SinglyLinkedListNode finalList =  list.head;
        int N = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < N; i++) {
            String query = scan.next();
            scan.nextLine();
            if(query.equals("Insert")){
                int pos = scan.nextInt();
                int data = scan.nextInt();
                finalList = insert(finalList,pos,data);
            }
            if(query.equals("Delete")){
                int pos = scan.nextInt();
                finalList = delete(finalList,pos);
            }
        }
        printR(finalList);
        
    }
}