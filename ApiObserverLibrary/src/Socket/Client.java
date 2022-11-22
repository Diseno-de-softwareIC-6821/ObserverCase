/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import Interfaces.ISocket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author Esteb
 */
public abstract class Client implements ISocket, Runnable{
    private Socket socket;
    private boolean isOn = false;
    private String id= "";
    private LinkedList<String> idOthersSockets;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    
    public Client(){}
    
    public void connect(){
        if(!this.isOn){
            try{
                this.socket = new Socket(Settings.getInstance().getHOST(),Settings.getInstance().getPORT());
                System.out.println("Client connected!");
                isOn = true;
                idOthersSockets = new LinkedList<>();
                in = new ObjectInputStream(this.socket.getInputStream());
                out = new ObjectOutputStream(this.socket.getOutputStream());
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
    
    
    public Client(Socket socket, String id) throws IOException{
        this.socket = socket;
        isOn = true;
        this.id = id;
        idOthersSockets = new LinkedList<>();
        in = new ObjectInputStream(this.socket.getInputStream());
        out = new ObjectOutputStream(this.socket.getOutputStream());
    }
    @Override
    public void turnOff(){
        if(this.socket!=null){
            try {
                this.isOn = false;
                this.out.close();
                this.in.close();
                this.socket.close();       
            } catch (IOException ex) {
                System.err.println("problem to turn off socket");
            }
        }
    }
    public  void addIdOther(String a){
        if(idOthersSockets != null){
            idOthersSockets.add(a);
        }else{
            System.out.println("Be connected first");
        }
       
    }
    public  void removeIdOther(String r){
        if(idOthersSockets != null){
            idOthersSockets.remove(r);
        }else{
            System.out.println("be Connected first");
        }
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
    @Override
    public void send(abstractMessage message){
        if(this.IsOn()){
            try{
                out.writeObject(message);
                System.out.print(this.id+" send->");
            }catch(IOException ex ){
                System.out.println("Cannot send message");
            }
        }
    }
    @Override
    public abstractMessage receive( ){
        abstractMessage objectRecieved = null;
        try{
           objectRecieved = (abstractMessage) in.readObject();
           System.out.println(this.id+ " received sucessfully");
           return objectRecieved;
        }catch(IOException|ClassNotFoundException e){
           System.out.println(e);
           return objectRecieved;
       }
    
    }
}
