package Model;



import java.util.ArrayList;
import java.util.List;
import Socket.Client;
import Socket.abstractMessage;

public class Fan extends Client{
    private int following;
    private String nick;
    private ArrayList<Artist> artistasSeguidos;
    
    public Fan(String nick_){
        super();
        this.following = 0;
        this.artistasSeguidos = new ArrayList<>();
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
    public abstractMessage receive() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void send(abstractMessage a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
