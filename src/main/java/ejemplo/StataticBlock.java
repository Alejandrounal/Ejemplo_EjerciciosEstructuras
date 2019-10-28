/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.util.Scanner;

/**
 *
 * @author Alejandro
 */

public class StataticBlock {
    static int B;
    static int H;
    static boolean flag;
    
    static{ 
        Scanner i = new Scanner(System.in);
        B = i.nextInt();
        i.nextLine();
        H = i.nextInt();
        if( B <= 0 || H <= 0){
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
        
        else if(B > 0 && H > 0)
            flag = true;    
        
}
    
    public static void main(String[] args) {
       if(flag){
            int area=B*H;
            System.out.print(area);
	}
		
    }
}
