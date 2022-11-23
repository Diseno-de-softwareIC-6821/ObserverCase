/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;


import Socket.abstractMessage;


/**
 *
 * @author Esteb
 */
public interface ISocket {
    public abstractMessage receive();
    public void send(abstractMessage message);
    public void turnOff();
    
}
