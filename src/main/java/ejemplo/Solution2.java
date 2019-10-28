/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/**
 *
 * @author Alejandro
 */
public class Solution2 {
    
    static class Estudiante{
        private String nombre, apellido;
        private int id;

        public Estudiante(String nombre, String apellido, int id) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    } 
   /////////////////////////////////////////////////////////////////////////////
    public class Node {
    private Node next;
    private Estudiante  estudiante;
    private Node prev;
    private int data;
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
   public Estudiante getEstudiante(){
       return estudiante;
   }
}
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                // Print Case Here

                System.out.println(T);

                int N = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> Ki = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                int P = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, P).forEach(PItr -> {
                    try {

                        List<String> comand = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .collect(toList());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}


