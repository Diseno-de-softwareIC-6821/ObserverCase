package RedSocial;

import ApiObserver.Interfaces.IObserver;
import ApiObserver.Observer.Client;
import java.util.ArrayList;
import java.util.List;


public class Artist extends Client implements IObserver{
    private int followers;
    private int level;
    private String nick;
    private ArrayList<Fan> fans;
    private ArrayList<Post> posts;
    
    Artist(String nick_){
        this.followers = 0;
        this.level = 0;
        this.nick = nick_;
        this.fans = new ArrayList<Fan>();
        this.posts = new ArrayList<Post>();  
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
