/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;


import Interfaces.IObservable;
import Interfaces.IObserver;


import java.util.ArrayList;


/**
 *
 * @author Esteb
 */
public abstract class AbstractObservable extends Client implements IObservable{
    private final ArrayList<IObserver> observers = new ArrayList<>();
    @Override       
    public void addObserver(IObserver observer) {           
        this.observers.add(observer);
    }                 
    @Override       
    public void removeObserver(IObserver observer) {           
        this.observers.remove(observer);
    }          
    @Override
    public void notifyAllObservers(Object source) {           
        for (IObserver observer : observers) {               
            observer.notifyObserver(source);
        }
               
    }
    
    
}
