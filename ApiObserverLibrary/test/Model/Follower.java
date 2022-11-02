/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import Observer.AbstractObserver;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class Follower extends AbstractObserver{
    private String name;
    
   
    public Follower(String name) {
        
       this.name = name;
    }

    @Override
    public void notifyObserver( Object source) {
        
    }

    public String getName() {
        return name;
    }

    
    
    
}
