/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Observer.Client;
import Socket.Message;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteb
 */
public class ServerClient extends Client implements Runnable{
    
    public ServerClient(Socket socket, String id){
        super(socket, id); //socket that was recieved by server
    }
    
    @Override
    public Message receive() {
        Message objectRecieved = null;
        try{
           InputStream entry = this.getSocket().getInputStream();
           ObjectInputStream chanel = new ObjectInputStream(entry);
           objectRecieved = (Message) chanel.readObject();
           return objectRecieved;
        }catch(IOException|ClassNotFoundException e){
           System.out.println(e);
           return objectRecieved;
       }
    }

    @Override
    public void send(Message message) {
        ServerClient socketDestination = null; 
        try {
            socketDestination = Server.getInstance().getManager().getClient(message.getIdDestination());
        } catch (IOException ex) {
            System.out.println("No socket found");
        }
        if(socketDestination!= null){        
            try {
                OutputStream socketExit = socketDestination.getSocket().getOutputStream();
                ObjectOutputStream chanel = new ObjectOutputStream(socketExit);
                chanel.writeObject(message);
                socketExit.close();
                chanel.close();
                System.out.println("Object send");
            } catch (IOException ex) {
                    System.out.println("\n***Error:\n"+ex);
                }
            }
    }
    

    @Override
    public void run() {
        while (this.IsOn()) {            
            Message message = receive();
            Message buildedMessage = new Message.MessageBuilder()
                        .setBody(message.getBody())
                        .setCodeRequest(message.getCodeRequest()).setDestination(message.getIdDestination()).build();
            send(buildedMessage);
 
        }
    }
    
}
