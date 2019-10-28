/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class FuzzBUzz {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            int a = s.nextInt();
            int resul = 0;
            if(a%3 == 0)
                resul = 1;
            if(a%5 == 0)
                resul = 2;
            if(a%3 == 0 && a%5==0)
                resul = 3;
            
            switch(resul){
                case 1:
                    System.out.println("Fuzz");
                    break;
                case 2:
                    System.out.println("Buzz");
                    break;
                case 3: 
                    System.out.println("FuzzBuzz");
                    break;
                default:
                    System.out.println(a);
            }
                
        }

    }
}
