/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Model.Artist;
import Socket.abstractMessage;

/**
 *
 * @author Esteb
 */
public class ArtistToFansUpdate extends abstractMessage<Artist>{
    Artist artist; 

    public ArtistToFansUpdate(Artist artist, String idDestination) {
        super(idDestination);
        this.artist = artist;
    }
    
    @Override
    public Artist doSomething() {
        return this.artist;
    }
    
}
