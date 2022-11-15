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
    private String firstserverClient ;
    public Server(){
        manager = new ClientManager();
    }
  
    public void turnOn() throws IOException{
        socketServer=new ServerSocket(Settings.getInstance().getPORT()); // Init the server
        System.out.println("Server started! in port "+ String.valueOf(Settings.getInstance().getPORT()));
        this.start();
    }
    public void turnOff(){
        Settings.getInstance().turnOffServer();
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
            new Thread(newServerClient).start();
            
            doSomething(newServerClient, newClientKey);
          
        
           
        }catch (IOException ex) {
           Logger.getLogger(ServerSingleton.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    /**
     *@@code Do something when new ClientsConected
     */
    private void doSomething(ServerClient newServerClient, String key){
        MessageKeyReturned returnMessage  = new MessageKeyReturned(key); //send their key for whaterver client
        newServerClient.send(returnMessage); //their key
        
        if(manager.getAmountClients()<=1){ //first 
            this.firstserverClient = key; //will be our server
        }else{ //is not the first one
            MessageKeyReturned keyOfServer = new MessageKeyReturned(key); //send our destination 
            keyOfServer.setIdSource(this.firstserverClient);
            newServerClient.send( keyOfServer);
        }
       
        
    }
    
 

    public ClientManager getManager() {
        return manager;
    }
}
