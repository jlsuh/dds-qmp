package domain.prenda;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import domain.material.TipoMaterial;

public enum TipoPrenda {

  // TipoPrenda posee impregnado por naturaleza una Categoria.
  // En caso de haber separado TipoPrenda y Categoria, dentro de Prenda, se hubiese superpuesto 2
  // veces la Categoria y hubiese resultado en repetición de valores computables.
  // El dominio permite dar una mayor cohesión, pues el sistema no requiere de cambios constantes.
  /*
   * Correcciones recibidas respecto a lo enunciado anteriormente: OJO que cohesión es la capacidad
   * que tiene un componente de resolver una única cosa. Se dice que mientras más cosas sepa hacer
   * un componente es menos cohesivo. Creo que lo que vos querés decir ahí es sobre consistencia o
   * redundancia de datos. Tampoco entiendo bien cómo se relaciona con los "cambios constantes".
   * Aclaramos que con "cambios constantes" nos referimos a que el requerimiento no es volátil.
   */
  ZAPATO("Zapato", Categoria.CALZADO,
      tiposMaterialesValidos(TipoMaterial.CUERO, TipoMaterial.PLASTICO, TipoMaterial.CAUCHO),
      new BigDecimal("30")),
  CAMISAMANGACORTA("Camisa de manga corta", Categoria.PARTESUPERIOR,
      tiposMaterialesValidos(TipoMaterial.PIQUE, TipoMaterial.NYLON),
      new BigDecimal("30")),
  PANTALON("Pantalon", Categoria.PARTEINFERIOR,
      tiposMaterialesValidos(TipoMaterial.GABARDINA, TipoMaterial.ACETATO, TipoMaterial.ALGODON),
      new BigDecimal("12")),
  CHOMBA("Chomba", Categoria.PARTESUPERIOR,
      tiposMaterialesValidos(TipoMaterial.PIQUE),
      new BigDecimal("14")),
  ZAPATILLA("Zapatilla", Categoria.CALZADO,
      tiposMaterialesValidos(TipoMaterial.CAUCHO),
      new BigDecimal("10")),
  CAMISA("Camisa", Categoria.PARTESUPERIOR,
      tiposMaterialesValidos(TipoMaterial.ALGODON, TipoMaterial.NYLON),
      new BigDecimal("10")),
  PANTALONDEVESTIR("Pantalon de vestir",
      Categoria.PARTEINFERIOR,tiposMaterialesValidos(TipoMaterial.ALGODON),
      new BigDecimal("12")),
  REMERAMANGALARGA("Remera de mangas largas",
      Categoria.PARTESUPERIOR,
      tiposMaterialesValidos(TipoMaterial.ALGODON),
      new BigDecimal("20")),
  BRAZALETE("Brazalete", Categoria.ACCESORIO,
      tiposMaterialesValidos(TipoMaterial.PLASTICO),
      new BigDecimal("11"));

  // Mediante la redundancia mínima procuramos mantener en un solo lugar
  // los valores computables.

  private String nombre;
  private Categoria categoria;
  private HashSet<TipoMaterial> tiposMaterialesValidos = new HashSet<>();
  private BigDecimal temperaturaAdecuada;

  private TipoPrenda(String nombre, Categoria categoria,
      HashSet<TipoMaterial> tiposMaterialesValidos, BigDecimal temperaturaAdecuada) {
    this.nombre = nombre;
    this.categoria = categoria;
    this.tiposMaterialesValidos = tiposMaterialesValidos;
    this.temperaturaAdecuada = temperaturaAdecuada;
  }

  public String getNombre() {
    return this.nombre;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public BigDecimal getTemperaturaAdecuadaEnCelsius() {
    return this.temperaturaAdecuada;
  }

  private static HashSet<TipoMaterial> tiposMaterialesValidos(TipoMaterial... tiposMateriales) {
    HashSet<TipoMaterial> categoriasValidas = new HashSet<>();
    Collections.addAll(categoriasValidas, tiposMateriales);
    return categoriasValidas;
  }

  public boolean esConsistente(TipoMaterial tipoMaterial) {
    return this.tiposMaterialesValidos.contains(tipoMaterial);
  }

  public boolean esAdecuadoParaElClima(BigDecimal valorTemperatura) {
    return this.temperaturaAdecuada.compareTo(valorTemperatura) == -1 // temperatura adecuada < valor temperatura
        || this.temperaturaAdecuada.compareTo(valorTemperatura) == 0; // temperatura adecuada == valor temperatura
  }

}
