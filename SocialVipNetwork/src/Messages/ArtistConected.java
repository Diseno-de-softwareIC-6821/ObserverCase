/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Model.Artist;
import Model.Fan;
import Socket.abstractMessage;

/**
 *
 * @author Esteb
 */
public class ArtistConected extends abstractMessage<String, Fan>{
    private Artist artist;
    
    public ArtistConected(String idSource, String idDestination, Artist art) {
        super(idSource, idDestination);
        artist = art;
    }
    @Override
    public String doSomething(Fan a) {
        a.addArtista(artist);
        return "Artista agregado";
    }
    
}
