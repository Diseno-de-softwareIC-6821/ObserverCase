package Subasta.Classes;



import Subasta.Enum.EStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Subasta   {
    private String nombre;
    private String descripcion;
    private String imagen;
    private Producto producto;
    private Date inicio;
    private Date finalProg;
    private EStatus status;
    private Oferente oferenteGanador;

    private HashMap<String, Float> HashOferentes = new HashMap<>();


    public Subasta(String nombre, String descripcion, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;

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

   
}
