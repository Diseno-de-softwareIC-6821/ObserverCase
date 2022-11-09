package Subasta.Classes;

import ApiObserver.Interfaces.IObserver;
import Subasta.Enum.EUsuario;
import Subasta.Interfaces.User;

public class UsuarioFactory {
    public UsuarioFactory(){

    }
    /*
    * Cambio de Clase usuario a interfaz User en Oferente y Subastador
    * */
    public static IObserver getUsuario(EUsuario usuario, String nick){
        IObserver nuevoUsuario;

        switch(usuario){
            case OFERENTE -> nuevoUsuario = new Oferente(nick);
            case SUBASTADOR -> nuevoUsuario = new Subastador(nick);
            default -> nuevoUsuario = null;
        }


        return nuevoUsuario;
    }
}
