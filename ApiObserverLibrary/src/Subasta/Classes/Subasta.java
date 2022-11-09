package Subasta.Classes;

import ApiObserver.Interfaces.IObservable;
import ApiObserver.Interfaces.IObserver;
import ApiObserver.Observer.Client;
import Subasta.Enum.EStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Subasta implements IObservable {
    private String nombre;
    private String descripcion;
    private String imagen;
    private Producto producto;
    private Date inicio;
    private Date finalProg;
    private EStatus status;
    private Oferente oferenteGanador;

    private HashMap<String, Float> HashOferentes = new HashMap<>();
    private ArrayList<IObserver> Observables;

    public Subasta(String nombre, String descripcion, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.Observables = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFinalProg() {
        return finalProg;
    }

    public void setFinalProg(Date finalProg) {
        this.finalProg = finalProg;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public Oferente getOferenteGanador() {
        return oferenteGanador;
    }

    public void setOferenteGanador(Oferente oferenteGanador) {
        this.oferenteGanador = oferenteGanador;
    }

    public HashMap<String, Float> getHashOferentes() {
        return HashOferentes;
    }

    public void setHashOferentes(HashMap<String, Float> hashOferentes) {
        HashOferentes = hashOferentes;
    }

    public void updateOferente(String oferente, float oferta){
        this.HashOferentes.put(oferente, oferta);
    }

    @Override
    public void addObserver(IObserver observer) {
        this.Observables.add(observer);

        Oferente oferente = (Oferente) observer;
        this.HashOferentes.put(oferente.getId(), 0.0f);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.Observables.remove(observer);

        Oferente oferente = (Oferente) observer;
        this.HashOferentes.remove(oferente.getId());
    }

    @Override
    public void notifyAllObservers(Object source) {
        for (IObserver client : this.Observables) {
            System.out.println(this.producto.getPrecioFin());
        }
    }
}
