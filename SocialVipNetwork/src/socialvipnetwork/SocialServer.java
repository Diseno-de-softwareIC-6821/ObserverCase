/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialvipnetwork;

import Model.Artist;
import Model.Fan;
import Socket.Client;

import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class SocialServer extends Client{
    private ArrayList<Artist> listaArtistas = new ArrayList<>(); 
    private ArrayList<Fan> listaFans = new ArrayList<>();
    
    
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
   
    
    

