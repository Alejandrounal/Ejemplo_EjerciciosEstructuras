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
public class Interance1 {
    
   public static int divisor_sum(int n){
        int sum = 0;
        for(int i = 1; i < n+1; i++){
            if((n%i) ==0)
                sum+=i;
        }
        return sum;   
    
   
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(divisor_sum(n));
        
    }
}
