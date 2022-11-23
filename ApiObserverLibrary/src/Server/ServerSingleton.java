/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import Interfaces.ISocket;
import Socket.MessageKeyReturned;
import Socket.Settings;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import java.util.HashMap;


/**
 *
 * @author Esteb
 * @param <T>
 */
public class ServerSingleton extends Server{
   
    private static ServerSingleton instance;
    private ServerSingleton(){

    }
    /*
    Applying singleton in server because we need only one of this
    */
    public static ServerSingleton getInstance() throws IOException{
        if(instance==null){
            instance = new ServerSingleton();
        }
        return instance;
    }
}
