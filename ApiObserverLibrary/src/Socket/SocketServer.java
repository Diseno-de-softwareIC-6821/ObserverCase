/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteb
 * @param <T>
 */
public class SocketServer extends Thread implements ISend<Object>{
    private ServerSocket socketServer;
    private  java.net.Socket socketConnet;
    private static SocketServer instance;

    private SocketServer() throws IOException{
        socketServer=new ServerSocket(Settings.getInstance().getPORT());
        
    }

    public static SocketServer getInstance() throws IOException{
        if(instance==null){
            instance = new SocketServer();
            System.out.println("Server started! in port "+ String.valueOf(Settings.getInstance().getPORT()));
            
            instance.start();
        }
        return instance;
    }
    @Override
    public void run(){
        while (Settings.getInstance().isActive()) {
            try {
                socketConnet = instance.socketServer.accept();
            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //--------------
        System.out.println("Servidor apagado");
        try {
            socketServer.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void sendMessage(Object message){
        if(this.socketConnet != null){
            try {
                OutputStream socketExit = socketConnet.getOutputStream();
                ObjectOutputStream chanel = new ObjectOutputStream(socketExit);
                chanel.writeObject(message);
                socketExit.close();
                chanel.close();
                System.out.println("Object send");
            } catch (IOException ex) {
                System.out.println("\n***Error:\n"+ex);
            }
        }else{
            System.out.println("No clients connected");
        }
        
    }
   
    
}
