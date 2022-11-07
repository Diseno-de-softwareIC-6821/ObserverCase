package Subasta.Classes;

public class Oferente extends Usuario{

    public Oferente(String nick) {
        super(nick);
    }

    public void ingresarSubasta(Subasta subasta){
        SubastasManager.ingresarOferente(this, subasta);
    }

    public void ofertar(float oferta, Subasta subasta){
        SubastasManager.ofertarProducto(this, oferta, subasta);
    }
}
