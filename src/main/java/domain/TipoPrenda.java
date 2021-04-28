package domain;

public enum TipoPrenda {

  // TipoPrenda posee impregnado por naturaleza una Categoria.
  // En caso de haber separado TipoPrenda y Categoria, dentro de Prenda, se hubiese superpuesto 2
  // veces la Categoria y hubiese resultado en repetición de valores computables.
  // El dominio permite dar una mayor cohesión, pues el sistema no requiere de cambios constantes.
  ZAPATO("Zapato", Categoria.CALZADO), CAMISAMANGACORTA("Camisa de manga corta",
      Categoria.PARTESUPERIOR), PANTALON("Pantalon", Categoria.PARTEINFERIOR);

  private String nombre;
  private Categoria categoria;

  private TipoPrenda(String nombre, Categoria categoria) {
    this.nombre = nombre;
    this.categoria = categoria;
  }

  public String getNombre() {
    return this.nombre;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }
}
