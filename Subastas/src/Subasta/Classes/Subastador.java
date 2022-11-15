package Subasta.Classes;


import Subasta.Interfaces.User;

import java.util.ArrayList;
import java.util.Date;

public class Subastador{

    private Subasta subasta;
    private String nick;

    public Subastador(String nick) {
        super();
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }
    public void setNick(String nick){
        this.nick = nick;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta listaSubastas) {
        this.subasta = listaSubastas;
    }

    public void colocarProducto(String nombre, String descripcion, String imagen, Producto producto, Date finalProg){
        SubastasManager.agregarSubastador(nombre, descripcion, imagen, this, producto, finalProg);
    }
    public void aceptarOferta(float precio, Oferente oferente){
        SubastasManager.aceptarOferta(precio, oferente, this.subasta);
    }

    public void cerrarSubasta(){
        SubastasManager.cerrarSubasta(this.subasta);
    }

    public void cancelarSubasta(){
        SubastasManager.cancelarSubasta(this.subasta);
    }

    public void enviarFelicitacion(String felicitacion, Oferente oferente){
        SubastasManager.enviarFelicitacion(felicitacion, oferente);
    }


}
