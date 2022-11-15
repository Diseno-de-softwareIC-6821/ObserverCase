/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Model.Artist;
import Model.Post;
import Socket.abstractMessage;

/**
 *
 * @author Esteb
 */
public class PostNotification extends abstractMessage<Post>{
    private Post post;

    public PostNotification(Post post, String destination) {
        super(post.getArtist().getSocketId(), destination, "");
        this.post = post;
 
    }
    
    
    @Override
    public Post doSomething() {
        return this.post;
    }
    
}
