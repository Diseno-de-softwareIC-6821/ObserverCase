package Subasta.Classes;

import Subasta.Interfaces.User;

public class Oferente  {

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

   // public void ingresarSubasta(Subasta subasta){
   //    // SubastasManager.ingresarOferente(this, subasta);
    //}



}
