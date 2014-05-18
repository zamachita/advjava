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
public class Fish extends Animal {
    
    public Fish() {
        super("fish");
    }

    @Override
    public String species() {
        return "species fish";
    }
    
}
