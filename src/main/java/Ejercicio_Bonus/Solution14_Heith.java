/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_Bonus;
import java.util.*;
import java.io.*;
/**
 *
 * @author Alejandro
 */
  

public class Solution14_Heith {
   static class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
    public static int height(Node root){
        return heightTree(root) -1;
    }
	public static int heightTree(Node root) {
      	if(root == null)
            return 0;
        int a = heightTree(root.left);
        int b = heightTree(root.right);
        int result;
        if(a > b)
             result = a;
        else
            result = b;
        return result+1;
    }
    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}


