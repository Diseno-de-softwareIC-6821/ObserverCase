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
public abstract class Server extends Thread{
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
    public void turnOff() throws IOException{
        Settings.getInstance().turnOffServer();
        socketServer.close();
        System.out.println("Server off");  
    }
    /*
    *Reading for every new socket is connected
    */
    @Override
    public void run(){
        
        while (Settings.getInstance().isActive()) { //while server is on
            startToListen();
            
        }
    }
    /*Method to send message, every request */
    private void startToListen(){
        try {
            Socket newClient = socketServer.accept(); //waiting client
            System.out.println("new Client connected!"); 
            String key = manager.getRandKey();
            ServerClient newServerClient = new ServerClient(newClient, key);
            manager.addClient(key, newServerClient);
            new Thread(newServerClient).start();
            MessageKeyReturned returnKey  = new MessageKeyReturned(key);
            newServerClient.send(returnKey);
        
           
        }catch (IOException ex) {
           Logger.getLogger(ServerSingleton.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    /**
     * @return return ClientsManager
     *@@code Do something when new ClientsConected
     */
    public ClientManager getManager() {
        return manager;
    }
}
