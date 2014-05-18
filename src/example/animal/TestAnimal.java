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
public class TestAnimal {
    
    public static void main(String[] args) {
        Animal cat = new Cat();
//        cat.name = "cat";
//        
        Animal chick = new Chicken();
//        chick.name = "chicken";
//        
        Animal fish = new Fish();
//        fish.name = "fish";
        
        System.out.println(cat);
        System.out.println(chick);
        System.out.println(fish);
    }

}