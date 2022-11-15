/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socialvipnetwork;

import Server.ServerSingleton;
import Socket.Settings;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteb
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Settings.getInstance().setPORT(6666);
            ServerSingleton.getInstance().turnOn();
        } catch (IOException ex) {
            System.out.println("Cannot turn on server");
        }
    }
    
}
