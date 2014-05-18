/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.review;

/**
 *
 * @author chaiwat
 */
public class HelloWorld {

    int a;
    int b;
    
    public HelloWorld() {
        System.out.println("Hello Contructor");
    }
    
    public static void printStaticMethod() {
        System.out.println("Hello Static Method");
    }
    
    public void printMethod() {
        System.out.println("Hello Simple Method");
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World");
        HelloWorld obj = new HelloWorld();
        HelloWorld.printStaticMethod();
        obj.printMethod();
    }
    
}
