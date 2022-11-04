/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Esteb
 */
public class Request implements Serializable{
    private Socket source;
    private Object message;
    private Socket destination;

    public Request(Socket source, Object message, Socket destination) {
        this.source = source;
        this.message = message;
        this.destination = destination;
    }

    public Socket getSource() {
        return source;
    }

    public void setSource(Socket source) {
        this.source = source;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Socket getDestination() {
        return destination;
    }

    public void setDestination(Socket destination) {
        this.destination = destination;
    }

    


}
