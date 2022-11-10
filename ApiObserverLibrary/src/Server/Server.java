/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Socket.MessageKeyReturned;
import Socket.Settings;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteb
 */
public class Server extends Thread{
    private ServerSocket socketServer;
    private ClientManager manager;
   
    public Server(){
        manager = new ClientManager();
    }
  
    public void turnOn() throws IOException{
        socketServer=new ServerSocket(Settings.getInstance().getPORT()); // Init the server
        System.out.println("Server started! in port "+ String.valueOf(Settings.getInstance().getPORT()));
        this.start();
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
            Logger.getLogger(ServerSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /*Method to send message, every request */
    private void startToListen(){
        try {
            Socket newClient = socketServer.accept(); //waiting client
            System.out.println("new Client connected!"); 
            String newClientKey = manager.getValidKey();
            ServerClient newServerClient = new ServerClient(newClient, newClientKey);
            manager.addClient(newClientKey, newServerClient);
            MessageKeyReturned returnMessage  = new MessageKeyReturned(newClientKey);
            newServerClient.send(returnMessage);
            new Thread(newServerClient).start();
        }catch (IOException ex) {
           Logger.getLogger(ServerSingleton.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }

    public ClientManager getManager() {
        return manager;
    }
}
