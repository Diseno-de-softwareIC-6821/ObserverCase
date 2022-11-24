package Model;



import Interfaces.IObserver;
import Messages.Suscribirse;
import java.util.ArrayList;
import Socket.Client;
import Socket.abstractMessage;
import java.io.Serializable;
import java.util.LinkedList;

public class Fan extends Client implements Serializable, IObserver<abstractMessage>{
    private int following = 0;
    private String nick = "";
    private ArrayList<Artist> artistasSeguidos= new ArrayList<>();
    private ArrayList<Artist> todosArtistas =  new ArrayList<>();
    private LinkedList<Post> listaPosts = new LinkedList<>();
    
    public Fan(String nick_){
        super();
        this.nick=nick_;
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
    public void addArtista(Artist a){
        todosArtistas.add(a);
    }
    public void addPost(Post a){
        listaPosts.add(a);
    }
    
    
    
    //---------------------------------------------------------------------------
    //_______________ FUNCIONES PROPIAS__________________________________________
    
    public void darLike(){      
    }
    
    public void darDislike(Post unpost){
        unpost.addDislike();
        
    }
    
    public void seguirArtista(Artist a){
        artistasSeguidos.add(a);
        Suscribirse mensage = new Suscribirse(this, this.getSocketKey(), a.getSocketKey());
        this.send(mensage);
    }
    public void actualizar(Post post){
        for(Post unpost :listaPosts){
            if(unpost.getId().equals(post.getId())){
                unpost.actualizarLikes(post);
            }
        }
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

    @Override
    public void notifyObserver(abstractMessage t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Artist> getTodosArtistas() {
        return todosArtistas;
    }



}
