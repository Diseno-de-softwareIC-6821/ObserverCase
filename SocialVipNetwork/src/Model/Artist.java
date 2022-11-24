package Model;




import Interfaces.IObservable;
import Interfaces.IObserver;
import Socket.Client;
import Socket.abstractMessage;
import java.util.ArrayList;
import java.util.List;


public class Artist extends Client implements IObservable{
    private int followers;
    private int level;
    private String nick;
    private ArrayList<Fan> fans;
    private ArrayList<Post> posts;
    private boolean isActive;
    
    public Artist(String nick_){
        super();
        this.followers = 0;
        this.level = 0;
        this.nick = nick_;
        this.fans = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.isActive = true;
    }
    
    //----------------- SETTERS Y GETTERS ---------------------------------------

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public ArrayList<Fan> getFans() {
        return fans;
    }

    public void setFans(ArrayList<Fan> fans) {
        this.fans = fans;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
    
    
    //---------------------------------------------------------------------------
    //_______________ FUNCIONES PROPIAS__________________________________________
    
    public void sharePost(){     
    }
    
    public void retire(){
    }
    
    public void notificarFans(){
    }
    
    
    //_______________ FUNCIONES DEL OBSERVER_____________________________________

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
    public void addObserver(IObserver io) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeObserver(IObserver io) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyAllObservers(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}