/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import Interfaces.ISocket;
import Socket.Message;
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
public class Server extends Thread{
    private ServerSocket socketServer;
    private ClientManager manager;
    private static Server instance;
    private Server(){
        manager = new ClientManager();
    }
    /*
    Applying singleton in server because we need only one of this
    */
    public static Server getInstance() throws IOException{
        if(instance==null){
            instance = new Server();
        }
        return instance;
    }
    public void turnOn() throws IOException{
        socketServer=new ServerSocket(Settings.getInstance().getPORT()); // Init the server
        System.out.println("Server started! in port "+ String.valueOf(Settings.getInstance().getPORT()));
        instance.start();
    }

    /*
    *Reading for every new socket is connected
    */
    @Override
    public void run(){
        while (Settings.getInstance().isActive()) { //while server is on
            startToListen();
        }
        //--------------
        try {
            socketServer.close();//close server
            System.out.println("Server off");  
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /*Method to send message, every request */
    private void startToListen(){
        try {
            Socket newClient = instance.socketServer.accept(); //waiting client
            System.out.println("new Client connected!"); 
            String newClientKey = manager.getValidKey();
            ServerClient newServerClient = new ServerClient(newClient, newClientKey);
            manager.addClient(newClientKey, newServerClient);
            Message returnMessage = new Message.MessageBuilder()
                    .setCodeRequest(Settings.getInstance().getIdReturnedCode())
                    .setDestination(newClientKey).setBody(newClient).build();
            newServerClient.send(returnMessage);
            new Thread(newServerClient).start();

        }catch (IOException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }

    public ClientManager getManager() {
        return manager;
    }
    
    

    
   
    
}
