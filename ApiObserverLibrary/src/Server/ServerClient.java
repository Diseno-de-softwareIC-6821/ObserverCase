/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Socket.Client;
import Socket.abstractMessage;
import java.io.IOException;
import java.net.Socket;


/**
 *
 * @author Esteb
 */
public class ServerClient extends Client implements Runnable{
    
    public ServerClient(Socket socket, String id) throws IOException{
        super(socket, id); //socket that was recieved by server
    }
    public void sendTo(abstractMessage message){
        ServerClient socketDestination = null; 
        try {
            socketDestination = ServerSingleton.getInstance().getManager().getClient(message.getIdDestination());    
            socketDestination.send(message); //send message to theirselve
        } catch (IOException ex) {
            System.out.println("No socket found, message has not been sended");
        }
    }

    @Override
    public void run() {
        while (this.IsOn()) {            
            abstractMessage message = receive();
            System.out.print(message.getIdSource()+"send to -> Server send to ->"+message.getIdDestination());
            sendTo(message);
        }
    }
    
}
