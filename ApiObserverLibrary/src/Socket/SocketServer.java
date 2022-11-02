/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

/**
 *
 * @author Esteb
 * @param <T>
 */
public class SocketServer <T> {
    private ServerSocket socketServer;
    private  java.net.Socket socketConnet;
    private static SocketServer instance;

    private SocketServer(){}
    
    
    public static SocketServer getInstance() throws IOException{
        if(instance==null){
            instance = new SocketServer();
            instance.socketServer=new ServerSocket(Settings.getInstance().getPORT());
            instance.socketConnet = instance.socketServer.accept();
        }
        return instance;
    }
    
    public void sendMessage(T message){
        try {
            OutputStream socketExit = socketConnet.getOutputStream();
            ObjectOutputStream chanel = new ObjectOutputStream(socketExit);
            chanel.writeObject(message);
            
            System.out.println("Object send");
        } catch (IOException ex) {
            System.out.println("\n***Error:\n"+ex);
        }
    }
}
