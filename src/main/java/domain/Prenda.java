package domain;

public class Prenda {

  private TipoPrenda tipo;
  private Material material;
  private String colorPrincipal;
  private String colorSecundario;
  // Convención: color principal y secundario de la forma: "#xxxxxx", siendo x un dígito
  // hexadecimal.

  public Prenda(TipoPrenda tipo, Material material, String colorPrincipal, String colorSecundario) {
    if (tipo == null || material == null || colorPrincipal == null) {
      throw new PrendaPoseeArgumentoInvalidoException("La prenda posee argumentos invalidos");
    }
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public TipoPrenda getTipoPrenda() {
    return this.tipo;
  }

  public Categoria getCategoria() {
    return this.tipo.getCategoria();
  }

  public Material getMaterial() {
    return this.material;
  }

  public String getColorPrincipal() {
    return this.colorPrincipal;
  }

  public String getColorSecundario() {
    return this.colorSecundario;
  }
}
