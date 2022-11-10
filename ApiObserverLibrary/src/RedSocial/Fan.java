package RedSocial;

import ApiObserver.Interfaces.IObserver;
import ApiObserver.Observer.Client;
import java.util.ArrayList;
import java.util.List;


public class Fan extends Client implements IObserver{
    private int following;
    private String nick;
    private ArrayList<Artist> artistasSeguidos;
    
    Fan(String nick_){
        this.following = 0;
        this.artistasSeguidos = new ArrayList<Artist>();
    }
    
    //----------------- SETTERS Y GETTERS ---------------------------------------
    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public ArrayList<Artist> getArtistasSeguidos() {
        return artistasSeguidos;
    }

    public void setArtistasSeguidos(ArrayList<Artist> artistasSeguidos) {
        this.artistasSeguidos = artistasSeguidos;
    }
    
    //---------------------------------------------------------------------------
    //_______________ FUNCIONES PROPIAS__________________________________________
    
    public void darLike(){      
    }
    
    public void darDislike(){  
    }
    
    public void seguirArtista(){
    }
    
    //_______________ FUNCIONES DEL OBSERVER__________________________________________
    @Override
    public Object receive() {
        return null;
    }

    @Override
    public void send(Object message) {
    }

    @Override
    public void run() {
    }

    @Override
    public void notifyObserver(Object source) {
    }
    
}
