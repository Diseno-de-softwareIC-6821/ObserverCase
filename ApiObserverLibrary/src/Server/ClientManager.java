/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import Socket.Settings;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author Esteb
 */
public class ClientManager {
    private HashMap<String, ServerClient> mapManager;
    
    public ClientManager(){
        mapManager = new HashMap<>();
    }
  
    public String getRandKey(){
        String newKey = String.valueOf(java.util.UUID.randomUUID());
        while(mapManager.get(newKey) != null){ //this is a high improbably but we need to prevent
            newKey = String.valueOf(java.util.UUID.randomUUID());
        }
        return newKey;
    }
    public void addClient(String key, ServerClient client){
        mapManager.put(key, client);
    }
    public void removeClient(String key){
        mapManager.remove(key);
    }
    
    public ServerClient getClient(String key){
        return mapManager.get(key);
    }
    public int getAmountClients(){
        return this.mapManager.size();
    }

    

}  

