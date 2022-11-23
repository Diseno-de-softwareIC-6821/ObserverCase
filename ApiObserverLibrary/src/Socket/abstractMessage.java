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
public abstract class abstractMessage <T, A> implements Serializable{
    private String idSource="";
    private String idDestination="";

    public abstractMessage(String idSource, String idDestination){
        this.idSource = idSource;
        this.idDestination = idDestination;
    }
    public abstractMessage(String idDestination){
        this.idDestination = idDestination;
    }
    public void setIdSource(String idSource) {
        this.idSource = idSource;
    }
    
    public String getIdSource() {
        return idSource;
    }
    public String getIdDestination() {
        return idDestination;
    }

    public abstract T doSomething(A toChange);
    
    //request builder 
}
