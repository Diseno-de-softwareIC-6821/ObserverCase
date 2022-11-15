/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Model.Artist;
import Socket.abstractMessage;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class ReturnArtists extends abstractMessage<ArrayList<Artist>>{
    ArrayList<Artist> artistList; 
    public ReturnArtists(String idSource, String idDestination, String codeRequest, ArrayList<Artist> list) {
        super(idSource, idDestination, codeRequest);
        artistList = list;
        
    }
    public void addArtistToSend(Artist a ){
        artistList.add(a);
    }
    
    @Override
    public ArrayList<Artist> doSomething() {
       return artistList; //Aquí va la lista de clientes también
    }
    
}
