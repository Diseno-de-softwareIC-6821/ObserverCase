/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Socket.abstractMessage;

/**
 *
 * @author Esteb
 */
public class Notification extends abstractMessage<String>{
    private String cuerpo;

    public Notification(String cuerpo, String idSource, String idDestination) {
        super(idSource, idDestination, "");
        this.cuerpo = cuerpo;
    }
    
    @Override
    public String doSomething() {
        return cuerpo;
    }
    
}
