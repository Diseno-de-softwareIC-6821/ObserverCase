/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Interfaces.IObservable;
import Interfaces.IObserver;
import Socket.IRecieve;
import Socket.SocketClient;
import java.io.Serializable;

/**
 *
 * @author Esteb
 */
public abstract class AbstractObserver implements IObserver, Serializable, IRecieve<Object>{
    private final SocketClient client =new SocketClient();
    //esta clase implementería de cierta forma el proxy
    
    @Override
    public Object getMessage(){ //de esta forma el cliente no se toca
        return client.getMessage(); 
    }
    
}
