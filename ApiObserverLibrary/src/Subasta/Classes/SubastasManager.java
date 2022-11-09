package Subasta.Classes;

import ApiObserver.Interfaces.IObserver;
import ApiObserver.Observer.Client;
import ApiObserver.Server.Server;
import ApiObserver.Socket.Request;
import Subasta.Enum.EStatus;

import java.util.ArrayList;
import java.util.Date;

public class SubastasManager extends Server{

    private static ArrayList<Subasta> listaSubastas = new ArrayList<>();
    private static ArrayList<Client> clientes = new ArrayList<>();

//    public SubastasManager(){
//
//    }

    public static void agregarSubastador(String nombre, String descripcion, String imagen, Subastador subastador, Producto producto, Date finalProg){
        Subasta nuevaSubasta = new Subasta(nombre, descripcion, imagen);
        nuevaSubasta.setProducto(producto);
        subastador.setSubasta(nuevaSubasta);
        listaSubastas.add(nuevaSubasta);
    }

    public static void aceptarOferta(float precio, Oferente oferente, Subasta subasta){
        subasta.setOferenteGanador(oferente);
        subasta.getProducto().setPrecioFin(precio);
        subasta.setStatus(EStatus.Vendida);
    }

    public static void cerrarSubasta(Subasta subasta){
        subasta.setStatus(EStatus.Cerrada);
    }

    public static void cancelarSubasta(Subasta subasta){
        subasta.setOferenteGanador(null);
        subasta.setHashOferentes(null);
        subasta.setStatus(EStatus.Cancelada);
    }

    public static void enviarFelicitacion(String felicitacion, Oferente oferente){
        System.out.println("Código de la api para enviar la felicitación");
    }

    public static void ingresarOferente(IObserver oferente, Subasta subasta){
        subasta.addObserver(oferente);
    }

    public static void ofertarProducto(String oferente, float oferta, Subasta subasta){
        subasta.updateOferente(oferente, oferta);
    }



}
