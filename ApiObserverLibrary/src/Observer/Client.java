/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Interfaces.ISocket;
import Socket.Settings;
import java.io.IOException;

import java.net.Socket;

/**
 *
 * @author Esteb
 */
public abstract class Client implements ISocket, Runnable{
    private Socket socket;
    private boolean isOn;
    private String id;
    
    public Client(){}
    
    public void connect(){
        if(!this.isOn){
            try{
                this.socket = new Socket(Settings.getInstance().getHOST(),Settings.getInstance().getPORT());
                System.out.println("Client connected!");
                isOn = true;
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
    public boolean IsOn() {
        return isOn;
    }

    public Socket getSocket() {
        return socket;
    }
}
