/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.net.Socket;

/**
 *
 * @author Esteb
 */
public interface ISendSocket  {
    public void send(Object message,Socket toClient);
}
