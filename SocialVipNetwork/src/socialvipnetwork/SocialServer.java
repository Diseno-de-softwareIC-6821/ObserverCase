/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialvipnetwork;

import Model.Artist;
import Model.Fan;
import Model.Post;
import Server.ClientManager;
import Server.ServerSingleton;
import Socket.Client;
import Socket.Settings;
import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteb
 */
public class SocialServer extends Client{
    private ArrayList<Artist> listaArtistas = new ArrayList<>(); 
    private ArrayList<Fan> listaFans = new ArrayList<>();
    private LinkedList<Post> listaPost  = new LinkedList<>();
    
    
    private static SocialServer instance;
    private SocialServer(){}
    
    private static SocialServer getInstance(){
        if(instance!=null){
            instance = new SocialServer();
            
        }
        return instance;
    }
    
    public void addArtist(Artist a){
        listaArtistas.add(a);
    }
    public void removeArtist(Artist a){ // cuando el artista se da de baja
        listaArtistas.remove(a); 
    }

    @Override
    public void run() {
        while(Settings.getInstance().isActive()){
            try {
                ClientManager manager = ServerSingleton.getInstance().getManager();
            } catch (IOException ex) {
                Logger.getLogger(SocialServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public static void main(String[] args){
        Settings.getInstance().setPORT(5432);
        try {
            ServerSingleton.getInstance().turnOn();
            String id = SocialServer.getInstance().connect();
            System.out.println("ID server "+id);
           
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al encender el servidor");
        } 
        
    
    }

}
   
    
    

