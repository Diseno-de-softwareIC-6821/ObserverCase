package Subasta.Classes;

import ApiObserver.Observer.Client;
import Subasta.Interfaces.User;

public class Oferente extends Client implements User {

    private String nick;

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

    public void ingresarSubasta(Subasta subasta){
        SubastasManager.ingresarOferente(this, subasta);
    }

    public void ofertar(float oferta, Subasta subasta){
        SubastasManager.ofertarProducto(this, oferta, subasta);
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



}
