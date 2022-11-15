package Model;

import java.util.ArrayList;


public class Post   {
    private String content;
    private int likes;
    private int dislikes;
    private Artist artist;
    
    Post(String content, Artist artist){
        this.content = content;
        this.likes = 0;
        this.dislikes = 0;
        this.artist = artist;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

  
    //_______________ FUNCIONES PROPIAS ________________________________________________
    
    //_______________ FUNCIONES DEL OBSERVABLE__________________________________________

    public Artist getArtist() {
        return artist;
    }

    
}
