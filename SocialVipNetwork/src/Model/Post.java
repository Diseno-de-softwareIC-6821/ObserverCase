package Model;

import java.util.ArrayList;


public class Post   {
    String content;
    int likes;
    int dislikes;
    
    Post(String content_){
        this.content = content_;
        this.likes = 0;
        this.dislikes = 0;

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

    
}
