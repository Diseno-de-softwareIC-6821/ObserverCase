/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Interfaces.IObserver;
import Observer.AbstractObservable;
import Socket.abstractMessage;

/**
 *
 * @author Esteb
 */
public class Suscribirse extends abstractMessage <String, AbstractObservable>{

    public IObserver observer;

    public Suscribirse(IObserver observer, String idSource, String idDestination) {
        super(idSource, idDestination);
        this.observer = observer;
        
    }
    
    
    @Override
    public String doSomething(AbstractObservable a) {
        a.addObserver(observer);
        return "Artista suscrito";
    }
    
}
