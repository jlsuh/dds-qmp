package domain.material;

import domain.exceptions.PrendaPoseeArgumentoInvalidoException;
import domain.prenda.Categoria;

public class Material {

  private String colorPrincipal;
  private String colorSecundario;
  private TipoMaterial tipoMaterial;
  private TramaMaterial tramaMaterial = TramaMaterial.LISA;
  // Convención: color principal y secundario de la forma: "#xxxxxx", siendo x un dígito
  // hexadecimal.
  // Sustento: El color de una prenda se describe gracias a su material.

  public Material(String colorPrincipal, String colorSecundario, TipoMaterial tipoMaterial) {
    if (colorPrincipal == null || tipoMaterial == null) {
      throw new PrendaPoseeArgumentoInvalidoException("La prenda posee argumentos invalidos");
    }
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.tipoMaterial = tipoMaterial;
  }

  public boolean esConsistente(Categoria unaCategoria) {
    return tipoMaterial.esConsistente(unaCategoria);
  }

  public String getColorPrincipal() {
    return this.colorPrincipal;
  }

  public String getColorSecundario() {
    return this.colorSecundario;
  }

  public TramaMaterial getTramaMaterial() {
    return this.tramaMaterial;
  }

  public TipoMaterial getTipoMaterial() {
    return tipoMaterial;
  }

  public void setTramaMaterial(TramaMaterial tramaMaterial) {
    this.tramaMaterial = tramaMaterial;
  }

}
