package domain.prenda;

import domain.exceptions.NoSePuedoCrearPrendaException;
import domain.exceptions.PrendaPoseeArgumentoInvalidoException;
import domain.exceptions.TipoPrendaNoEsConsistenteConSuMaterialException;
import domain.material.Material;

public class SesionConstruccionPrenda {

  private TipoPrenda tipoPrenda;
  private Material material;

  public Prenda createPrenda() {
    Prenda prenda;
    try {
      prenda = new Prenda(this.tipoPrenda);
      prenda.setMaterial(this.material);
    } catch (PrendaPoseeArgumentoInvalidoException
        | TipoPrendaNoEsConsistenteConSuMaterialException e) {
      throw new NoSePuedoCrearPrendaException("Hubo un error a la hora de crear una prenda");
    }
    return prenda;
  }

  public void setTipoPrendaEnSesion(TipoPrenda tipoPrenda) {
    this.tipoPrenda = tipoPrenda;
  }

  public void setMaterialEnSesion(Material material) {
    this.material = material;
  }

}
