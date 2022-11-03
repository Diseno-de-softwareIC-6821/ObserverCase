/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Esteb
 */
public class SocketClient extends Thread{
    private Socket socketConnect;
    
    public SocketClient(){
        try{      
            System.out.println("Client connected!");
            socketConnect = new Socket(Settings.getInstance().getHOST(),Settings.getInstance().getPORT());
        }catch(IOException e){
            System.out.println("Error to connect client");
        }   
    }
    public Object getMessage(){
        Object objectRecieved = null;
        try{
            InputStream entry = socketConnect.getInputStream();
            ObjectInputStream chanel = new ObjectInputStream(entry);
            objectRecieved = chanel.readObject();
            return objectRecieved;
        }catch(IOException|ClassNotFoundException e){
            System.out.println(e);
            return objectRecieved;
        }
    }
   
}
