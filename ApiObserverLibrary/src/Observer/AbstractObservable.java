/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;


import Interfaces.IObservable;
import Interfaces.IObserver;
import Interfaces.ISend;
import Socket.SocketServer;
import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;


/**
 *
 * @author Esteb
 */
public abstract class AbstractObservable implements IObservable, Serializable, ISend<Object>{
    private final ArrayList<AbstractObserver> observers = new ArrayList<>();
    @Override       
    public void addObserver(AbstractObserver observer) {           
        this.observers.add(observer);
    }                 
    @Override       
    public void removeObserver(AbstractObserver observer) {           
        this.observers.remove(observer);
    }          
    @Override
    public void notifyAllObservers(Object source) {           
        for (IObserver observer : observers) {               
            observer.notifyObserver(source);
        }
               
    }
    
    
}
