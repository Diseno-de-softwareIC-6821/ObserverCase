/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Control.EPostType;
import Control.PostFactory;
import Observer.AbstractObservable;
import Socket.SocketServer;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class Celebrity extends AbstractObservable implements Serializable{
    private String name;
    private ArrayList<Follower> followers;
    private boolean isActive; 
    private ArrayList<Post> posts; 
    private int level; 

    public Celebrity( String name) {
        this.name = name;
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.isActive = true;
        this.level = 0;
    }
    public void setState(boolean newState){
        isActive = newState;
    }
  
    public void createPost(String message) throws IOException{
        Post newPost= PostFactory.createPost(this, EPostType.NEW_POST);
        newPost.setMessage(message);
        sendPost(newPost);
    }
    public void addPost(Post post){
        posts.add(post);
    }
    public void sendPost(Post newpost) throws IOException{
        SocketServer.getInstance().sendMessage(newpost);
        addPost(newpost);
        notifyAllObservers(this);
    }
    
    public void incrementLevel(){
        this.level +=1;
        
    }
    public int getFollowersSize(){
        return followers.size();
    }
    
    public void addFollower(Follower a){
        followers.add(a);
        addObserver(a);
        
    }
    public void moretenFollowers() throws IOException{
        if(followers.size() % 10 == 0){
            Post newPost =PostFactory.createPost(this, EPostType.NEW_POST);
            newPost.setMessage("Level "+level + " by "+String.valueOf(getFollowersSize()) + " followers");
            sendPost(newPost);
        }
    }
   
    
    public void removeFollower(Follower r){
        followers.remove(r);
        removeObserver(r);
    }

    public String getName() {
        return name;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public int getLevel() {
        return level;
    }
            
         
    
    
}
