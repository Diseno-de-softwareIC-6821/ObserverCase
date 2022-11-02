/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Control.EPostType;
import Control.PostFactory;
import Socket.SocketServer;
import java.io.IOException;

/**
 *
 * @author Esteb
 */
public class Post {
    private String title;
    private String message;
    private Celebrity celebrity;
    private int likes; 
    private int dislikes;

    public Post(Celebrity celebrity, String title) {
        this.celebrity = celebrity;
        this.title = title;
        likes= 0;
        dislikes = 0;
    }
    
    public void incrementLikes( ){
        likes+=1;
    }
    public void incrementeDislikes(){
        dislikes+=1;
    }
    public void moreThenLikes() throws IOException{
        if(likes % 10 == 0 ){
            Post newPost = PostFactory.createPost(celebrity, EPostType.GOT_MORE_TEN_LIKES);
            newPost.setMessage(" ha alcanzado "+ String.valueOf(likes)+ " likes");
            celebrity.sendPost(newPost);
        }
    }
    
    private void decrementLikes(){
        if(likes>0){
            likes-=1;
        }
    }
    private void decrementeDislikes(){
        if(dislikes>0){
            dislikes-=1;
        }
    }

    public String getMessage() {
        return message;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
   
    
    
    
}
