package Subasta.Classes;

import Subasta.Enum.EUsuario;
import Subasta.Interfaces.User;

public class UsuarioFactory {
    public UsuarioFactory(){

    }

    public static User getUsuario(EUsuario usuario, String nick){
        User nuevoUsuario;

        switch(usuario){
            case OFERENTE -> nuevoUsuario = new Oferente(nick);
            case SUBASTADOR -> nuevoUsuario = new Subastador(nick);
            default -> nuevoUsuario = null;
        }


        return nuevoUsuario;
    }
}
