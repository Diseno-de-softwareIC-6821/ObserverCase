package Model;

import Messages.MensagePost;
import Socket.Client;
import java.io.Serializable;


public class Post implements Serializable{
    private String id = String.valueOf(java.util.UUID.randomUUID());
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
    public void addLike(Client cliente){
        likes+=1;
        if(likes % 10 == 0){
            Post nuevoPost = new Post(artist.getNick()+ "ha alcanzado +10 likes", artist);
            artist.notifyAllObservers(new MensagePost(nuevoPost, artist.getSocketKey(),cliente.getSocketKey()));
            //actualizar post
        }
        
    }
    public void addDislike(){
        dislikes+=1;
    }
    public void actualizarLikes(Post post){
        if(id.equals(post.id)){
            likes = post.likes;
            dislikes = post.dislikes;
        }
    }
    
    public String getContent() {
        return content;
    }
    public int getLikes() {
        return likes;
    }
    public int getDislikes() {
        return dislikes;
    }


  
    //_______________ FUNCIONES PROPIAS ________________________________________________
    
    //_______________ FUNCIONES DEL OBSERVABLE__________________________________________

    public Artist getArtist() {
        return artist;
    }

    public String getId() {
        return id;
    }
    

    
}
