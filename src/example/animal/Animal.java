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
public abstract class Animal implements Kingdom {
    
    private String name = "";

    public Animal() {
    }

    protected Animal(String name) {
        this.name = name;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
//    public void setName(String name) {
//        this.name = name;
//    }
    @Override
    public String toString() {
        return "Name = " + name; //To change body of generated methods, choose Tools | Templates.
    }
    
}
