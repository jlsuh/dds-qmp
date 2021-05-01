package domain.prenda;

import domain.material.TipoMaterial;
import domain.material.Trama;

public class Prenda {

  private TipoPrenda tipoPrenda;
  private TipoMaterial tipoMaterial;
  private Trama trama;
  private String colorPrincipal;
  private String colorSecundario;
  // Convención: color principal y secundario de la forma: "#xxxxxx", siendo x un dígito
  // hexadecimal.

  public Prenda(TipoPrenda tipoPrenda, TipoMaterial tipoMaterial, Trama trama,
      String colorPrincipal, String colorSecundario) {
    this.tipoPrenda = tipoPrenda;
    this.tipoMaterial = tipoMaterial;
    this.trama = trama;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public TipoPrenda getTipoPrenda() {
    return this.tipoPrenda;
  }

  public Categoria getCategoria() {
    return this.tipoPrenda.getCategoria();
  }

  public TipoMaterial getTipoMaterial() {
    return this.tipoMaterial;
  }

  public Trama getTrama() {
    return this.trama;
  }

  public String getColorPrincipal() {
    return this.colorPrincipal;
  }

  public String getColorSecundario() {
    return this.colorSecundario;
  }
}
