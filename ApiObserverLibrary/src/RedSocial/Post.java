package RedSocial;

import ApiObserver.Interfaces.IObservable;
import ApiObserver.Interfaces.IObserver;
import java.util.ArrayList;


public class Post implements IObservable {
    String content;
    int likes;
    int dislikes;
    private ArrayList<IObserver> Observables;
    
    Post(String content_){
        this.content = content_;
        this.likes = 0;
        this.dislikes = 0;
        this.Observables = new ArrayList<>();
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

    public ArrayList<IObserver> getObservables() {
        return Observables;
    }

    public void setObservables(ArrayList<IObserver> Observables) {
        this.Observables = Observables;
    }
    //_______________ FUNCIONES PROPIAS ________________________________________________
    
    //_______________ FUNCIONES DEL OBSERVABLE__________________________________________
    @Override
    public void addObserver(IObserver observer) {
    }

    @Override
    public void removeObserver(IObserver observer) {
    }

    @Override
    public void notifyAllObservers(Object source) {
    }
    
}
