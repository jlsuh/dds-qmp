package domain.prenda;

import domain.exceptions.PrendaPoseeArgumentoInvalidoException;
import domain.exceptions.TipoPrendaNoEsConsistenteConSuMaterialException;
import domain.material.Material;

public class Prenda {

  private TipoPrenda tipoPrenda;
  private Material material;

  public Prenda(TipoPrenda tipo) {
    if (tipo == null) {
      throw new PrendaPoseeArgumentoInvalidoException("La prenda posee argumentos invalidos");
    }
    this.tipoPrenda = tipo;
  }

  public void setMaterial(Material material) {
    if (material == null) {
      throw new PrendaPoseeArgumentoInvalidoException("Material posee argumento null");
    } if (!material.esConsistente(this.tipoPrenda.getCategoria())) {
      throw new TipoPrendaNoEsConsistenteConSuMaterialException(
          "La prenda posee un tipo y material inconsistentes entre sí");
    }
    this.material = material;
  }

  public TipoPrenda getTipoPrenda() {
    return this.tipoPrenda;
  }

  public Categoria getCategoria() {
    return this.tipoPrenda.getCategoria();
  }

  public Material getMaterial() {
    return this.material;
  }
}
