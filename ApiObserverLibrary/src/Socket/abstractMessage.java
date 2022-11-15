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
public abstract class abstractMessage <T> implements Serializable{
    private String idSource;
    private String idDestination;
    private String codeRequest;

    public abstractMessage(String idSource, String idDestination, String codeRequest){
        this.idSource = idSource;
        this.idDestination = idDestination;
        this.codeRequest = codeRequest;
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

    public String getCodeRequest() {
        return codeRequest;
    }
    
    public abstract T doSomething();
    
    //request builder 
}
