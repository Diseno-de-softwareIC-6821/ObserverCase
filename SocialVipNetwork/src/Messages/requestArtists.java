/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Model.Fan;
import Socket.abstractMessage;

/**
 *
 * @author Esteb
 */
public class RequestArtists extends abstractMessage<Request> {

    public RequestArtists(String idSource, String idDestination, String codeRequest) {
        super(idSource, idDestination, codeRequest);
    }

    @Override
    public Request doSomething() {
        return Request.REQUEST_ARTIST ;
    }
    
}
