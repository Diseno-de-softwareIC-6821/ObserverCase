/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Messages;

import Model.Artist;
import Model.Fan;
import Socket.abstractMessage;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class ActualizarArtistas extends abstractMessage<String, Fan>{
    private ArrayList<Artist> lista;
    
    public ActualizarArtistas(String idSource, String idDestination, ArrayList<Artist> lista) {
        super(idSource, idDestination);
        this.lista = lista;
    }    
    @Override
    public String doSomething(Fan a) {
        a.getTodosArtistas().clear();
        for(Artist unartista : lista){
            a.addArtista(unartista);
        }
        return "Artista agregado";
    }
    
}