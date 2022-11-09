/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Socket.Message;


/**
 *
 * @author Esteb
 */
public interface ISocket {
    public Message receive();
    public void send(Message message);
    public void turnOff();
    
}
