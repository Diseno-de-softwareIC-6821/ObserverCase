/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Celebrity;
import Model.Post;

/**
 *
 * @author Esteb
 */
public class PostFactory {
    
    public static Post createPost(Celebrity celebrity, EPostType type){
    
        switch (type) {
            case GOT_MORE_TEN_FOLLOWERS:
                return new Post(celebrity, celebrity.getName()+" new level!");
                
            case NEW_POST:
                return new Post(celebrity, celebrity.getName()+ " send a new post!");
            
            case GOT_MORE_TEN_LIKES:
                return new Post(celebrity, "Got more ten likes in a post");
            default:
                throw new AssertionError();
        }
    }
    
}
