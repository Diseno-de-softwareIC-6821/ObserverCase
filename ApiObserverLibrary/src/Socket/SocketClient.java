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
public class SocketClient <T> {
    private Socket socketConnect;
    
    public SocketClient(){
        try{
            socketConnect = new Socket(Settings.getInstance().getHOST(),Settings.getInstance().getPORT());
            System.out.println("Client conected! ");
        }catch(IOException e){
            System.out.println("Error to connect client");
        }   
    }
    public T getMessage(){
        T objectRecieved = null;
        try{
            InputStream entry = socketConnect.getInputStream();
            ObjectInputStream chanel = new ObjectInputStream(entry);
            objectRecieved = (T) chanel.readObject();
            
        }catch(IOException|ClassNotFoundException e){
            System.out.println(e);
        }finally{
            return objectRecieved;
        }
    }
   
}
