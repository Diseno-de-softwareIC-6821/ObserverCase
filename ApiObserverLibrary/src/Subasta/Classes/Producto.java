package Subasta.Classes;

public class Producto {
    private String nombre;
    private String descripcion;
    private String imagen;
    private float precioIni;
    private float precioFin = 0;

    public Producto(String nombre, String descripcion, String imagen) {
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

    public float getPrecioIni() {
        return precioIni;
    }

    public void setPrecioIni(float precioIni) {
        this.precioIni = precioIni;
        this.precioFin = precioIni;
    }

    public float getPrecioFin() {
        return precioFin;
    }

    public void setPrecioFin(float precioFin) {
        this.precioFin = precioFin;
    }
}
