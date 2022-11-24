/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Model.Fan;
import Model.Post;
import Socket.abstractMessage;

/**
 *
 * @author Esteb
 */
public class MensagePost extends abstractMessage<String, Fan>{
    public Post post;

    public MensagePost(Post post, String idSource, String idDestination) {
        super(idSource, idDestination);
        this.post = post;
    }
    
    @Override
    public String doSomething(Fan a) {
        a.addPost(post);
        return "Nuevo post añadido";
    }
    
}
