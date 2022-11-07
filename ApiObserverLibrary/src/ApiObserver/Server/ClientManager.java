/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApiObserver.Server;

import ApiObserver.Observer.Client;
import ApiObserver.Socket.Request;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Esteb
 */
public class ClientManager extends Client{
    public ClientManager(Socket client){
        super(client);
    }
    
    @Override
    public void run() {
        if(this.IsOn()){
            Object objectRequest = receive(); //el deberá recibir un objeto de tipo request
            if(objectRequest!=null){
                send(objectRequest); //object of type request
            }
        }
        
    }
    //Manager in client
    @Override
    public void send(Object message) {
        Request request = (Request) message; //convert to client
        Socket destinationSocket = request.getDestination();
        Object body = request.getMessage();
        try {
            OutputStream socketExit = destinationSocket.getOutputStream();
            ObjectOutputStream chanel = new ObjectOutputStream(socketExit);
            chanel.writeObject(body);
            socketExit.close();
            chanel.close();
            System.out.println("Object send");
            } catch (IOException ex) {
                System.out.println("\n***Error:\n"+ex);
            }
    }
    @Override
    public Object receive() {
        Object objectRecieved = null;
        try{
           InputStream entry = this.getSocket().getInputStream();
           ObjectInputStream chanel = new ObjectInputStream(entry);
           objectRecieved = chanel.readObject();
           return objectRecieved;
        }catch(IOException|ClassNotFoundException e){
           System.out.println(e);
           return objectRecieved;
       }
    }
    

}  

