package Subasta.Classes;

import ApiObserver.Interfaces.IObserver;
import ApiObserver.Observer.Client;
import Subasta.Interfaces.User;

public class Oferente extends Client implements IObserver {

    private String nick;
    private String id;

    public Oferente(String nick) {
        super();
        this.nick = nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return this.nick;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public void ingresarSubasta(Subasta subasta){
        SubastasManager.ingresarOferente(this, subasta);
    }



    @Override
    public Object receive() {
        return null;
    }

    @Override
    public void send(Object message) {

    }

    @Override
    public void run() {

    }


    @Override
    public void notifyObserver(Object source) {
        System.out.println("notificacion");
    }
}
