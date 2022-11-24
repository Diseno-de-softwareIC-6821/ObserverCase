/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Socket.Client;
import Socket.abstractMessage;

/**
 *
 * @author Esteb
 */
public class SocialServerKey extends abstractMessage<String, Client>{

    public SocialServerKey(String idSource, String idDestination) {
        super(idSource, idDestination);
    }
    @Override
    public String doSomething(Client a) {
        a.addIdOther(this.getIdSource());
        return this.getIdSource();
    }
    
}
