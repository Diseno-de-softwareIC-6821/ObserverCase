/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

/**
 *
 * @author Esteb
 */
public class Settings {
    private static Settings instance;
    private int PORT;
    private String HOST;
    private Settings(){
        this.PORT = 5000; 
        this.HOST = "localhost";
    }
    
    public static Settings getInstance(){
        if(instance ==null){
            instance = new Settings();
        }
        return instance;
    }

    public int getPORT() {
        return PORT;
    }

    public void setPORT(int PORT) {
        this.PORT = PORT;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }
    

    
    
}
