/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.collection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chaiwat
 */
public class ListExample {
    
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            l.add(i + 10);
        }
        
        for (Integer i : l) {
            System.out.println(": " + i);
        }
        
        System.out.println(l.get(9));
    }
    
}
