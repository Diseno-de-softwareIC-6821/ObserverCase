/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import Interfaces.ISend;
import Interfaces.ISendSocket;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Esteb
 * @param <T>
 */
public class SocketServer extends Thread implements ISendSocket{
    private ServerSocket socketServer;
    private Socket socketConnet;
    private ArrayList<Socket> clientsList;
    private static SocketServer instance;
    private SocketServer() throws IOException{
        socketServer=new ServerSocket(Settings.getInstance().getPORT()); // Init the server
    }
    /*
    Applying singleton in server because we need only one of this
    */
    public static SocketServer getInstance() throws IOException{
        if(instance==null){
            instance = new SocketServer();
            System.out.println("Server started! in port "+ String.valueOf(Settings.getInstance().getPORT()));
            
            instance.start();
        }
        return instance;
    }
    /*
    *Reading for every new socket is connected
    */
    @Override
    public void run(){
        while (Settings.getInstance().isActive()) { //while server is on
            try {
                Socket newClient = instance.socketServer.accept(); //waiting client
                if(!newClient.equals(this.socketConnet)){ //if diferents of current client
                    System.out.println("new Client connected!"); 
                    this.socketConnet = newClient; //set current the new client
                }
            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //--------------
        System.out.println("Server off");  
        try {
            socketServer.close();//close server
        } catch (IOException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*Method to send message, every Object */
  
    public void send(Object message){
        if(this.socketConnet != null){ //only if have client
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
