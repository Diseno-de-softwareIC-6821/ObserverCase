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
    private final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            +"0123456789"
            +"abcdefghijklmnopqrstuvwxyz";
    private static Settings instance;
    private int PORT;
    private String HOST;
    private int hashLenght;
    private boolean isActive;
    private String idReturnedCode;
    private Settings(){
        this.PORT = 5000; 
        this.HOST = "localhost";
        this.isActive = true;
        this.hashLenght = 10;
        idReturnedCode = "000";
    }

    public String getIdReturnedCode() {
        return idReturnedCode;
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

    public boolean isActive() {
        return isActive;
    }

    public void turnOffServer(){
        this.isActive = false;
    }
    
    public String getAlphNumericString(){
        return ALPHA_NUMERIC_STRING;
    }

    public int getHashLenght() {
        return hashLenght;
    }
   
    

    
    
}
