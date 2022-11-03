/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Interfaces.IObservable;
import Interfaces.IObserver;
import Interfaces.IReceive;
import Socket.SocketClient;
import java.io.Serializable;

/**
 *
 * @author Esteb
 */
public abstract class AbstractObserver implements IObserver, Serializable, IReceive<Object>{
    private final SocketClient client =new SocketClient();
    //esta clase se implementería de cierta forma como un proxy
    
    
    @Override 
    public Object receive(){
        return client.receive();
    }
    
}
