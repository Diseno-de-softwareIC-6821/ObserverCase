/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ApiObserver.Interfaces;

/**
 *
 * @author Esteb
 */
public interface ISocket {
    public Object receive();
    public void send(Object message);
    public void turnOff();
    
}
