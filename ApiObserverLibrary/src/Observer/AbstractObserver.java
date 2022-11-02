/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Interfaces.IObservable;
import Interfaces.IObserver;
import Socket.SocketClient;

/**
 *
 * @author Esteb
 */
public abstract class AbstractObserver implements IObserver{
    public final SocketClient client =new SocketClient();;
    
    
}
