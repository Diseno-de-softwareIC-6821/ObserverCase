/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Interfaces.ISocket;
import Socket.Settings;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Esteb
 * @param <T>
 */
public abstract class Client implements ISocket, Runnable{
    private Socket socket;
    private boolean isOn;
    
    public Client(){
        try {
            this.socket = new Socket(Settings.getInstance().getHOST(),Settings.getInstance().getPORT());
            System.out.println("Client connected!");
            isOn = true;
        } catch (IOException ex) {
            System.out.println("Error to connect the client");
        }
        
    }
    
    public Client(Socket socket){
        this.socket = socket;
        isOn = true;
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
