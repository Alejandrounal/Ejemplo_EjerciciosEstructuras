/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_Bonus;
import java.io.IOException;
import java.lang.reflect.Method;
/**
 *
 * @author Alejandro
 */
class Printer <T>
{
   public void printArray(T[] arreglo){
   for(int i = 0; i < arreglo.length; i++){
         System.out.println(arreglo[i]);  
     }
   }
    
}
public class Solution8_Generics {
    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
      
    }
}

