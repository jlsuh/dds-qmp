package domain.material;

import java.util.Collections;
import java.util.HashSet;
import domain.prenda.Categoria;

public enum TipoMaterial {

  // Sustento: en vez de ver si el tipo de prenda y el material son consistentes, debido a que
  // podría surgir un número de combinatoria alta y a medida que se vaya añadiéndolas al sistema,
  // nos queden todas las combinatorias posibles, se ha relacionado el tipo de prenda y la Categoria
  // de la prenda. De esta forma el tipo de prenda posee una mayor flexibilidad al momento de
  // agregar más tipos de materiales y no se necesitará crear combinatorias: Ejemplo:
  // CUERO(Categoria.CALZADO), CUERO(Categoria.PARTESUPERIOR), CUERO(Categoria.ACCESORIO), entre
  // otras combinaciones.
  // También: ZAPATO("Zapato", Categoria.CALZADO, TipoMaterial.CUERO), ZAPATO("Zapato",
  // Categoria.CALZADO, TipoMaterial.GOMA), ZAPATO("Zapato", Categoria.CALZADO,
  // TipoMaterial.ALGODON), entre otras combinaciones.
  CUERO(setCategoriasValidas(Categoria.CALZADO)),
  PLASTICO(setCategoriasValidas(Categoria.CALZADO, Categoria.ACCESORIO)),
  GABARDINA(setCategoriasValidas(Categoria.PARTEINFERIOR)),
  PIQUE(setCategoriasValidas(Categoria.PARTESUPERIOR)),
  ACETATO(setCategoriasValidas(Categoria.PARTEINFERIOR)),
  CAUCHO(setCategoriasValidas(Categoria.CALZADO)),
  NYLON(setCategoriasValidas(Categoria.PARTESUPERIOR)),
  ALGODON(setCategoriasValidas(Categoria.PARTEINFERIOR));

  private HashSet<Categoria> categoriasValidas = new HashSet<>();

  private TipoMaterial(HashSet<Categoria> categoriasValidas) {
    this.categoriasValidas = categoriasValidas;
  }

  private static HashSet<Categoria> setCategoriasValidas(Categoria... categorias) {
    HashSet<Categoria> categoriasValidas = new HashSet<>();
    Collections.addAll(categoriasValidas, categorias);
    return categoriasValidas;
  }

  public boolean esConsistente(Categoria unaCategoria) {
    return this.categoriasValidas.contains(unaCategoria);
  }

}
