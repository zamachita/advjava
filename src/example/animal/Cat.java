/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.animal;

/**
 *
 * @author chaiwat
 */
public class Cat extends Animal {

    public Cat() {
        super("..cat..");
    }

    @Override
    public String toString() {
        return "Cat is " + super.getName();
    }

    @Override
    public String species() {
        return "species cat";
    }
    
}
