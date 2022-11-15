/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socialvipnetwork;

import Messages.ArtistToFansUpdate;
import Messages.RequestArtists;
import Messages.ReturnArtists;
import Model.Artist;
import Model.Fan;
import Socket.Client;
import Socket.MessageKeyReturned;
import Socket.abstractMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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
    public abstractMessage receive() {
        abstractMessage objectRecieved = null; 
        try{
            InputStream entry = this.getSocket().getInputStream();
            ObjectInputStream chanel = new ObjectInputStream(entry);
            objectRecieved= (abstractMessage) chanel.readObject();
            return objectRecieved;
        }catch(IOException | ClassNotFoundException e ){
            return objectRecieved;
        }
       
    }

    @Override
    public void send(abstractMessage a) {
        

    }

    @Override
    public void run() {
        while(IsOn()){
            abstractMessage amessage = receive();
            
        }

    }
    public void doSomething(abstractMessage message){
        if(message instanceof MessageKeyReturned){
            this.setId((String) message.doSomething());
        }else if(message instanceof RequestArtists){
            String keyRequest = ((RequestArtists) message).getIdSource();
            ReturnArtists returnedArtist = new ReturnArtists(this.getSocketKey(), keyRequest, listaArtistas);
            send(returnedArtist);
        }else if(message instanceof ArtistToFansUpdate){
            ArtistToFansUpdate pmessage = (ArtistToFansUpdate) message;
            artistToFanUpdate(pmessage );
            removeArtist(pmessage.doSomething());
        }else if(message instanceof )
    }
    
    private void artistToFanUpdate(ArtistToFansUpdate message){
        Artist artist = ((ArtistToFansUpdate) message).doSomething();
        for(Fan artisFan : artist.getFans()){
            String key = artisFan.getSocketKey();
            ArtistToFansUpdate messageUpdate = new ArtistToFansUpdate(artist, key);
            send(messageUpdate);
        }
        
    }
   
    
    
}
