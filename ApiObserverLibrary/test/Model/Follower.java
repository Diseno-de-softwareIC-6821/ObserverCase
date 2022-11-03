/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import Observer.AbstractObserver;
import Screen.FrFollower;
import java.util.ArrayList;
 

/**
 *
 * @author Esteb
 */
public class Follower extends AbstractObserver{
    private String name;
    private ArrayList<Post> myCelebritiesPost ;
    private int currentPostIndex;
    private ArrayList<Celebrity> myCelebrites;
    private FrFollower sscreen;
    
    public Follower(String name) {
        
       this.name = name;
       myCelebritiesPost = new ArrayList<>();
       currentPostIndex = 0;
       myCelebrites = new ArrayList<>();
    }
    public void addPost(Post onePost){
        myCelebritiesPost.add(onePost);
        
    }
    public void addCelebrity(Celebrity a){
        myCelebrites.add(a);
    }
    public void removeCelebrity(Celebrity r){
        myCelebrites.remove(r);
    }
    public Celebrity searchCelebrity(Celebrity s ){
        for(Celebrity oneCelebrity: myCelebrites){
            if(s.getName().equals(oneCelebrity.getName())){
                return  oneCelebrity;
            }
        }
        return null;
    }
    public Post nextPost(){
        if(this.currentPostIndex+1 < myCelebritiesPost.size()){
            return myCelebritiesPost.get(currentPostIndex+1);
        }
        return new Post(new Celebrity("No more post"), "no more post"); //aplicando el null object
    }

    @Override
    public void notifyObserver( Object source) {
        Post post = (Post) this.client.getMessage();
        Celebrity celebrity = (Celebrity) source;
        if(searchCelebrity(celebrity) != null){
            //si son iguales es porque el post es para este follower
            addPost(post);
            System.out.println(name +" has recibido un nuevo post !");
            this.sscreen.addNotification(post);
        }
        
    }

    public String getName() {
        return name;
    }

    public void setSscreen(FrFollower sscreen) {
        this.sscreen = sscreen;
    }

    
    
    
}
