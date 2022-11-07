package Subasta.Classes;

import Subasta.Enum.EUsuario;

public class UsuarioFactory {
    public UsuarioFactory(){

    }

    public static Usuario getUsuario(EUsuario usuario, String nick){
        Usuario nuevoUsuario;

        switch(usuario){
            case Oferente -> nuevoUsuario = new Oferente(nick);
            case Subastador -> nuevoUsuario = new Subastador(nick);
            default -> nuevoUsuario = null;
        }


        return nuevoUsuario;
    }
}
