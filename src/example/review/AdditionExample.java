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
public class AdditionExample {
    
    int a;
    int b;

    public AdditionExample() {
        a = 1;
        b = 2;
    }
    
    public int addition() {
        return a + b;
    }
    
    public int addition(int a, int b) {
        return a + b;
    }
    
    public void testAddition() {
        a = 10;
        b = 20;
        int r1 = addition();
        int r2 = addition(5, 10);
        System.out.println("Add()    = " + r1);
        System.out.println("Add(a,b) = " + r2);
    }
    
    public static void main(String[] args) {
        AdditionExample obj = new AdditionExample();
        int r1 = obj.addition();
        System.out.println("main Add() = " + r1);
        obj.testAddition();
    }
    
}
