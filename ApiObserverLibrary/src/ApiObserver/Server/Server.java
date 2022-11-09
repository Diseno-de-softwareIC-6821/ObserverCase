/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiObserver.Server;


import ApiObserver.Socket.Settings;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 * @param <T>
 */
public class Server extends Thread{
    private ServerSocket socketServer;
    private ArrayList<ClientManager> listManager;
    private static Server instance;
    private Server(){
        listManager = new ArrayList<>();
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
        socketServer = new ServerSocket(Settings.getInstance().getPORT()); // Init the server
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
        System.out.println("Server off");  
        try {
            socketServer.close();//close server
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /*Method to send message, every request */
    private void startToListen(){
        try {
            Socket newClient = instance.socketServer.accept(); //waiting client
            System.out.println("new Client connected!"); 
            ClientManager newManager = new ClientManager(newClient); //set socket of client 
            new Thread(newManager).start();
            this.listManager.add(newManager);
        }catch (IOException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    

    
   
    
}
