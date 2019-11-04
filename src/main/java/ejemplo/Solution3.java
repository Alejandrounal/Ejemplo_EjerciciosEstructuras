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

public class Solution3 {
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    static class Cubiculo{
        public int numero;
        public double capacidad;
        double carga ;
        public int casillerosOcupados = 0;
        public Casillero[] casilleros;
        
        public Cubiculo(int numero, int capacidad){
            this.capacidad = capacidad;
            this.numero = numero;
            this.casilleros = new Casillero[capacidad];
            crearCasi(); 
            this.carga = this.casillerosOcupados/capacidad;
        }

        public void crearCasi(){
            for (int i = 0; i < capacidad; i++) {
                casilleros[i] = new Casillero(i+1,this.numero);
            }
        }

        public int getNumero() {
            return numero;
        }

        public double getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(double capacidad) {
            this.capacidad = capacidad;
        }

        public double getCarga() {
            return carga;
        }

        public void setCarga(double carga) {
            this.carga = carga;
        }

        public int getCasillerosOcupados() {
            return casillerosOcupados;
        }

        public void setCasillerosOcupados(int casillerosOcupados) {
            this.casillerosOcupados = casillerosOcupados;
        }

        public Casillero[] getCasilleros() {
            return casilleros;
        }

        public void setCasilleros(Casillero[] casilleros) {
            this.casilleros = casilleros;
        }
        
        public Casillero desocupado(){
            Casillero indiceCasillero = null;
            for (int i = 0; i < casilleros.length; i++) {
               if(casilleros[i].getEstudiante() == null ){
                   indiceCasillero = casilleros[i];
                   break;
               }
            }return indiceCasillero;
        }
        
        public void insertar(){
            this.casillerosOcupados++;
            actualizarCarga();
        }
        
        public void sacar(){
            this.casillerosOcupados--;
            actualizarCarga();
        }
        
        public void actualizarCarga(){
            this.carga = this.casillerosOcupados/this.capacidad;
        }
        
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    static class Casillero{
        private Student estudiante;
        private int indCas;
        private int indCub;

        public Casillero(int indCas, int indCub) {
            this.indCas = indCas;
            this.indCub = indCub;
            this.estudiante = null;
        }

        public Student getEstudiante() {
            return estudiante;
        }

        public void setEstudiante(Student estudiante) {
            this.estudiante = estudiante;
        }

        public int getIndCas() {
            return indCas;
        }

        public void setIndCas(int indCas) {
            this.indCas = indCas;
        }

        public int getIndCub() {
            return indCub;
        }

        public void setIndCub(int indCub) {
            this.indCub = indCub;
        }
        
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    static class Student{
        private String nombre;
        private String apellido;
        private int cedula;
        private Casillero casillero;

        public Student(String nombre, String apellido, int cedula) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.cedula = cedula;
            this.casillero = null;
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

        public int getCedula() {
            return cedula;
        }

        public void setCedula(int cedula) {
            this.cedula = cedula;
        }

        public Casillero getCasillero() {
            return casillero;
        }

        public void setCasillero(Casillero casillero) {
            this.casillero = casillero;
        } 
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class LinkedListStudent {
    private NodeStudent head, ptr, prev;
    
    public boolean insert(Student item){
        boolean inserted = false;
        ptr = head;
        prev = null;
        while(ptr !=null && ptr.getStudent().getCedula() < item.getCedula()){
            prev = ptr;
            ptr = ptr.getNext();
        }
       if(ptr == null || ptr.getStudent().getCedula()!= item.getCedula()){     
        inserted = true;
        NodeStudent newp = new NodeStudent(item);
        newp.setNext(ptr);
        if(prev == null)
            head = newp;
        else
            prev.setNext(newp);
       }return inserted;
    }
    
    public Student delete(int item){
        boolean deleted = false;
        Student estu = null;
        ptr = head;
        prev = null;
        while(ptr !=null && ptr.getStudent().getCedula() < item){
            prev = ptr;
            ptr = ptr.getNext();
        }
        if(ptr==null){
            deleted = false;
        }
        if(ptr.getStudent().getCedula() != item){
            deleted = false;
        }
        
        if(ptr.getStudent().getCedula() == item){
           deleted = true;
           estu = ptr.getStudent();
           if(prev == null){
               head = ptr.getNext();
           }else if(ptr.getNext() == null){
               prev.setNext(null);
           }else{ 
              prev.setNext(ptr.getNext());
              ptr.getNext().setPrev(ptr.getPrev());
        }
        }return estu;
    }
      
    public void printRecursive() { 
        System.out.print("Imprimir lista recursivamente: ");
        printR(head); System.out.println();
    }
    
    private void printR(NodeStudent p) { 
        if(p != null) {
            System.out.print(p.getStudent().getCedula()+" "+p.getStudent().getNombre());
            printR(p.getNext()); } 
    }
    
    
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class NodeStudent {
    private NodeStudent next;
    private Student estudiante;
    private NodeStudent prev;

    public NodeStudent() {
        this(null);
    }

    public NodeStudent(Student estudiante) {
        this.next = null;
        this.estudiante = estudiante;
       
    }

    public NodeStudent getNext() {
        return next;
    }

    public void setNext(NodeStudent next) {
        this.next = next;
    }

    public Student getStudent() {
        return estudiante;
    }

    public void setStudent(Student estudiante) {
        this.estudiante = estudiante;
    }

    public NodeStudent getPrev() {
        return prev;
    }

    public void setPrev(NodeStudent prev) {
        this.prev = prev;
    }
   
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    static class NodeCarga {
    private NodeCarga next;
    private Cubiculo cubiculo;
    private NodeCarga prev;

    public NodeCarga() {
        this(null);
    }

    public NodeCarga(Cubiculo cubiculo) {
        this.next = null;
        this.cubiculo = cubiculo;
       
    }

    public NodeCarga getNext() {
        return next;
    }

    public void setNext(NodeCarga next) {
        this.next = next;
    }

    public Cubiculo getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(Cubiculo cubiculo) {
        this.cubiculo = cubiculo;
    }

    public NodeCarga getPrev() {
        return prev;
    }

    public void setPrev(NodeCarga prev) {
        this.prev = prev;
    }
   
    }
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class LinkedListCarga {
    private NodeCarga head, ptr, prev;
     /*
    public boolean insert(Cubiculo item){
        boolean inserted = false;
        ptr = head;
        prev = null;
        while(ptr !=null && ptr.getCubiculo().getCarga()< item.getCarga()){
            prev = ptr;
            ptr = ptr.getNext();
        }
        
       if(ptr == null || ptr.getCubiculo().getCarga()!= item.getCarga()){     
            inserted = true;
            NodeCarga newp = new NodeCarga(item);
            newp.setNext(ptr);
        if(prev == null)
            head = newp;
        else
            prev.setNext(newp);
       }
       
       else if(ptr == null || ptr.getCubiculo().getCarga() == item.getCarga()){
            while(ptr !=null && ptr.getCubiculo().getNumero()< item.getNumero()){
                prev = ptr;
                ptr = ptr.getNext();
            }
            if(ptr == null || ptr.getCubiculo().getNumero()!= item.getNumero()){     
                inserted = true;
                NodeCarga newpo = new NodeCarga(item);
                newpo.setNext(ptr);
                if(prev == null)
                head = newpo;
                else
                prev.setNext(newpo);
            }
        }return inserted;
    }
    */
    public boolean insert(Cubiculo item){
        boolean inserted = false;
        ptr = head;
        prev = null;
        while(ptr !=null && ptr.getCubiculo().getCarga() < item.getCarga()){
            prev = ptr;
            ptr = ptr.getNext();
        }
        while(ptr !=null && ptr.getCubiculo().numero < item.getNumero()){
            if(ptr.getCubiculo().getCarga() > item.carga)
                break;
            else{
                prev = ptr;
                ptr = ptr.getNext();
            }
        }
        if(ptr == null || ptr.getCubiculo().getNumero() != item.getNumero()){     
        inserted = true;
        NodeCarga newp = new NodeCarga(item);
        newp.setNext(ptr);
        if(prev == null)
            head = newp;
        else
            prev.setNext(newp);
       }return inserted;
    }
    
    public boolean delete(Cubiculo item){
        boolean deleted = false;
        ptr = head;
        prev = null;
        while(ptr !=null && ptr.getCubiculo().getCarga() < item.getCarga()){
            prev = ptr;
            ptr = ptr.getNext();
        }
        if(ptr==null){
            deleted = false;
        }
        
      while(ptr !=null && ptr.getCubiculo().getNumero() < item.getNumero()){
            prev = ptr;
            ptr = ptr.getNext();
        }
       
        if(ptr.getCubiculo().getNumero()!= item.getNumero()){
            deleted = false;
        }
        
        if(ptr.getCubiculo().getNumero() == item.getNumero()){
           deleted = true;
           if(prev == null){
               head = ptr.getNext();
           }else if(ptr.getNext() == null){
               prev.setNext(null);
           }else{ 
              prev.setNext(ptr.getNext());
              ptr.getNext().setPrev(ptr.getPrev());
        }
        }return deleted;
    }
    
     public Cubiculo dequeue(){
       Cubiculo result = null;
       if(head != null){
             result = head.getCubiculo();
       }return result;
    }
      
    public void printRecursive() { 
        System.out.print("Imprimir lista recursivamente: ");
        printR(head); System.out.println();
    }
    
    private void printR(NodeCarga p) { 
        if(p != null) {
            System.out.print(p.getCubiculo().getCarga()+" "+p.getCubiculo().getNumero());
            printR(p.getNext()); } 
    }
}
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    static LinkedListCarga crearlistaCarga(Cubiculo[] cubiculos){
        LinkedListCarga cargas = new LinkedListCarga();
        for (int i = 0; i < cubiculos.length; i++) {
            cargas.insert(cubiculos[i]);
        }return cargas;
    }
    
    static void insertar(Student estudiante, LinkedListCarga listaCubiculos, LinkedListStudent listaEstudiantes){
        Cubiculo cubi = listaCubiculos.dequeue();
        listaCubiculos.delete(cubi);
        if(cubi.getCarga() == 1){
            System.out.println("limite alcanzado");
        }else{
            Casillero casi = cubi.desocupado();
            casi.setEstudiante(estudiante);
            estudiante.setCasillero(casi);
            listaEstudiantes.insert(estudiante);
            cubi.insertar();
            listaCubiculos.insert(cubi);
            System.out.println(cubi.getNumero()+" " + casi.getIndCas());
        }
    }
    
    static void salir(int cedula, LinkedListStudent listaEstudiantes, LinkedListCarga listaCubiculos, Cubiculo[] cubiculos){
        Student estudiante = listaEstudiantes.delete(cedula);
        Casillero casillero = estudiante.getCasillero();
        casillero.setEstudiante(null);
        int indiceCubiculo = casillero.getIndCub()-1;
        listaCubiculos.delete(cubiculos[indiceCubiculo]);
        cubiculos[indiceCubiculo].sacar();
        listaCubiculos.insert(cubiculos[indiceCubiculo]);
        System.out.println(estudiante.nombre);
    }
    
     public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);
       int casos = s.nextInt();
       Cubiculo[] arrCubiculos;
       s.nextLine();
         for (int i = 0; i < casos; i++) {
             System.out.println("Caso #" + (i+1));
             int cubiculos = s.nextInt();
             s.nextLine();
             arrCubiculos = new Cubiculo[cubiculos];
             for (int j = 0; j < arrCubiculos.length; j++) {
                 arrCubiculos[j] = new Cubiculo(j+1 , s.nextInt());                   
             }        
  
             LinkedListCarga cargaCubiculos = crearlistaCarga(arrCubiculos);
             LinkedListStudent listaEstudiantes = new LinkedListStudent();
             
             int comandos = s.nextInt();
             s.nextLine();
             for (int j = 0; j < comandos; j++) {
                 String[] linea = s.nextLine().split(" ");
                 if(linea[0].equals("ingresar")){
                     Student estudiante = new Student(linea[1], linea[2], Integer.parseInt(linea[3]));
                     insertar(estudiante,cargaCubiculos,listaEstudiantes);
                 }               
                 if(linea[0].equals("salir")){
                     salir(Integer.parseInt(linea[1]),listaEstudiantes,cargaCubiculos,arrCubiculos);
                    
                 }
             }
         }

       
}   

}