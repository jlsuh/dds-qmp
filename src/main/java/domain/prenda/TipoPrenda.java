package domain.prenda;

import java.util.Collections;
import java.util.HashSet;
import domain.material.TipoMaterial;

public enum TipoPrenda {

  // TipoPrenda posee impregnado por naturaleza una Categoria.
  // En caso de haber separado TipoPrenda y Categoria, dentro de Prenda, se hubiese superpuesto 2
  // veces la Categoria y hubiese resultado en repetición de valores computables.
  // El dominio permite dar una mayor cohesión, pues el sistema no requiere de cambios constantes.
  ZAPATO("Zapato", Categoria.CALZADO,
      tiposMaterialesValidos(TipoMaterial.CUERO,
                              TipoMaterial.PLASTICO,
                              TipoMaterial.CAUCHO)),
  CAMISAMANGACORTA("Camisa de manga corta", Categoria.PARTESUPERIOR,
      tiposMaterialesValidos(TipoMaterial.PIQUE,
                              TipoMaterial.NYLON)),
  PANTALON("Pantalon", Categoria.PARTEINFERIOR,
      tiposMaterialesValidos(TipoMaterial.GABARDINA,
                              TipoMaterial.ACETATO,
                              TipoMaterial.ALGODON)),
  CHOMBA("Chomba", Categoria.PARTESUPERIOR,
      tiposMaterialesValidos(TipoMaterial.PIQUE)),
  ZAPATILLA("Zapatilla", Categoria.CALZADO,
      tiposMaterialesValidos(TipoMaterial.CAUCHO)),
  CAMISA("Camisa", Categoria.PARTESUPERIOR,
      tiposMaterialesValidos(TipoMaterial.ALGODON,
                              TipoMaterial.NYLON)),
  PANTALONDEVESTIR("Pantalon de vestir", Categoria.PARTEINFERIOR,
      tiposMaterialesValidos(TipoMaterial.ALGODON));
  // Mediante la redundancia mínima procuramos mantener en un solo lugar
  // los valores computables.

  private String nombre;
  private Categoria categoria;
  private HashSet<TipoMaterial> tiposMaterialesValidos = new HashSet<>();

  private TipoPrenda(String nombre, Categoria categoria,
      HashSet<TipoMaterial> tiposMaterialesValidos) {
    this.nombre = nombre;
    this.categoria = categoria;
    this.tiposMaterialesValidos = tiposMaterialesValidos;
  }

  public String getNombre() {
    return this.nombre;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  private static HashSet<TipoMaterial> tiposMaterialesValidos(TipoMaterial... tiposMateriales) {
    HashSet<TipoMaterial> categoriasValidas = new HashSet<>();
    Collections.addAll(categoriasValidas, tiposMateriales);
    return categoriasValidas;
  }

  public boolean esConsistente(TipoMaterial tipoMaterial) {
    return this.tiposMaterialesValidos.contains(tipoMaterial);
  }

}
