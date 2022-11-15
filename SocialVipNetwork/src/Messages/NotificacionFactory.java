/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

/**
 *
 * @author Esteb
 */
public class NotificacionFactory {
    public static String createCuerpo(TipoNotificacion tipo){
        switch(tipo){
            case NEW_POST:
                return "Ha publicado un nuevo post";
                
            case META_FOLLOWERS:
                return "ha sumado +10 seguidores";
            case META_POST_LIKES:
                return "Este post ha alcanzadp +10 likes";
            default:
                return "";
        }
    }
}
