/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import Interfaces.ISocket;
import Socket.Settings;
import java.io.IOException;

import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Esteb
 */
public abstract class Client implements ISocket, Runnable{
    private Socket socket;
    private boolean isOn;
    private String id;
    private LinkedList<String> idothers;
    
    public Client(){}
    
    public void connect(){
        if(!this.isOn){
            try{
                this.socket = new Socket(Settings.getInstance().getHOST(),Settings.getInstance().getPORT());
                System.out.println("Client connected!");
                isOn = true;
                idothers = new LinkedList<>();
//
            }catch(IOException ex){
                System.out.println("Error to connect the client");
            }
        }else{//the client is already connected
            System.out.println("The client has been connected");
        }
    
    }
    public void setId(String id){
        this.id = id;
    }
    
    public Client(Socket socket, String id){
        this.socket = socket;
        isOn = true;
        this.id = id;
    }
    @Override
    public void turnOff(){
        if(this.socket!=null){
            try {
                this.isOn = false;
                this.socket.close();
            } catch (IOException ex) {
                System.err.println("problem to turn off socket");
            }
        }
    }
    public  void addIdOther(String a){
        if(idothers != null){
            idothers.add(a);
        }else{
            System.out.println("Connect your client first");
        }
       
    }
    public  void removeIdOther(String r){
        if(idothers != null){
            idothers.remove(r);
        }else{
            System.out.println("Connect your client first");
        }
    }
    /**
     * @return A void String if is not connect or empty, otherwise return the clientId
    * @code The first one may be the "server request"
    * 
    */
    public String getServerClient(){
        if(idothers != null){
            if (idothers.isEmpty()) {
                return idothers.get(0);
            }
        }
        return "";
    }
    
    public boolean IsOn() {
        return isOn;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getSocketKey(){
        return this.id;
    }

}
