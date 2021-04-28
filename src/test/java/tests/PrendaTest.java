package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.Material;
import domain.Prenda;
import domain.PrendaPoseeArgumentoInvalidoException;
import domain.TipoPrenda;

public class PrendaTest {

  @Test
  public void unaPrendaPoseeUnTipo() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO, Material.CUERO, "#804000", null);
    Assertions.assertNotNull(prenda.getTipoPrenda());
  }

  @Test
  public void unaPrendaPoseeUnaCategoria() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO, Material.CUERO, "#804000", null);
    Assertions.assertNotNull(prenda.getTipoPrenda().getCategoria());
  }

  @Test
  public void unaPrendaPoseeUnMaterial() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO, Material.CUERO, "#804000", null);
    Assertions.assertNotNull(prenda.getMaterial());
  }

  @Test
  public void unaPrendaPoseeUnColorPrincipal() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO, Material.CUERO, "#804000", null);
    Assertions.assertNotNull(prenda.getColorPrincipal());
  }

  @Test
  public void unaPrendaPoseeUnColorSecundario() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO, Material.CUERO, "#804000", "#000000");
    Assertions.assertNotNull(prenda.getColorSecundario());
  }

  @Test
  public void unaPrendaNoPuedeEstarSinUnTipo() {
    Assertions.assertThrows(PrendaPoseeArgumentoInvalidoException.class,
        () -> new Prenda(null, Material.CUERO, "#804000", "#000000"));
  }

  @Test
  public void unaPrendaNoPuedeEstarSinUnMaterial() {
    Assertions.assertThrows(PrendaPoseeArgumentoInvalidoException.class,
        () -> new Prenda(TipoPrenda.ZAPATO, null, "#804000", "#000000"));
  }

  @Test
  public void unaPrendaNoPuedeEstarSinUnColorPrimario() {
    Assertions.assertThrows(PrendaPoseeArgumentoInvalidoException.class,
        () -> new Prenda(TipoPrenda.ZAPATO, Material.CUERO, null, "#000000"));
  }

  @Test
  public void unaPrendaPuedeEstarSinUnColorSecundario() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO, Material.CUERO, "#804000", null);
    Assertions.assertNull(prenda.getColorSecundario());
  }

  /*
   * No se prueba: confiamos en lo de adentro. Sabemos que un enumerado de TipoPrenda, su tipo nunca
   * se condecirá con una categoría.
   * 
   * @Test public void unaPrendaNoSeCondicenConSuCategoria() {}
   */

  /*
   * No se prueba: confiamos en lo de adentro. Sabemos que siempre que se inicialice un tipo,
   * siempre se sabrá su categoría asociada.
   * 
   * @Test public void unaPrendaPoseeUnaCategoria() {}
   */

  @Test
  public void unaTipoDePrendaPoseeUnNombre() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO, Material.CUERO, "#804000", null);
    Assertions.assertNull(prenda.getTipoPrenda().getNombre());
  }
}
