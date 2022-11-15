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
    private String generateRandomKey(){
        StringBuilder sbuilder = new StringBuilder(Settings.getInstance().getHashLenght());
        for(int i = 0; i<Settings.getInstance().getHashLenght(); i++){
            String chain = Settings.getInstance().getAlphNumericString();
            int random = (int) (chain.length() * Math.random());
            sbuilder.append(chain.charAt(random));
        }
       return sbuilder.toString();
    }
    public String getValidKey(){
        String newKey = generateRandomKey();
        while(mapManager.get(newKey) != null){
            newKey = generateRandomKey();
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

