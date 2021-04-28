package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.exceptions.NoSePuedoCrearPrendaException;
import domain.material.Material;
import domain.material.TipoMaterial;
import domain.prenda.Categoria;
import domain.prenda.Prenda;
import domain.prenda.Ropero;
import domain.prenda.SesionConstruccionPrenda;
import domain.prenda.TipoPrenda;

public class PrendaTest {

  @Test
  public void unaPrendaPoseeUnTipo() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO);
    Assertions.assertEquals(prenda.getTipoPrenda(), TipoPrenda.ZAPATO);
  }

  @Test
  public void unaPrendaPoseeUnaCategoria() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO);
    Assertions.assertEquals(prenda.getTipoPrenda().getCategoria(), Categoria.CALZADO);
  }

  @Test
  public void unaPrendaPoseeUnMaterial() {
    Prenda prenda = new Prenda(TipoPrenda.ZAPATO);
    Material material = new Material("#804000", null, TipoMaterial.CUERO);
    prenda.setMaterial(material);
    Assertions.assertNotNull(prenda.getMaterial());
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
  public void unTipoDePrendaPoseeUnNombre() {
    Prenda prenda = new Prenda(TipoPrenda.CAMISAMANGACORTA);
    Assertions.assertEquals(prenda.getTipoPrenda().getNombre(), "Camisa de manga corta");
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiNoSeLeIndicoSuTipo() {
    SesionConstruccionPrenda scp = new SesionConstruccionPrenda();
    Assertions.assertThrows(NoSePuedoCrearPrendaException.class, () -> scp.createPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSeLeIndicoSuTipoPeroNoSuMaterial() {
    SesionConstruccionPrenda scp = new SesionConstruccionPrenda();
    scp.setTipoPrendaEnSesion(TipoPrenda.CAMISAMANGACORTA);
    Assertions.assertThrows(NoSePuedoCrearPrendaException.class, () -> scp.createPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSoloSeLeIndicoElMaterial() {
    SesionConstruccionPrenda scp = new SesionConstruccionPrenda();
    scp.setMaterialEnSesion(new Material("#000000", null, TipoMaterial.CUERO));
    Assertions.assertThrows(NoSePuedoCrearPrendaException.class, () -> scp.createPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSeLeIndicoSuTipoYMaterialPeroNoSonConsistentes() {
    SesionConstruccionPrenda scp = new SesionConstruccionPrenda();
    scp.setTipoPrendaEnSesion(TipoPrenda.CAMISAMANGACORTA);
    scp.setMaterialEnSesion(new Material("#000000", null, TipoMaterial.CUERO));
    Assertions.assertThrows(NoSePuedoCrearPrendaException.class, () -> scp.createPrenda());
  }

  @Test
  public void sePuedeCrearUnaPrendaSiSeDanLasCondicionesYTipoConMaterialSonConsistentes() {
    SesionConstruccionPrenda scp = new SesionConstruccionPrenda();
    scp.setTipoPrendaEnSesion(TipoPrenda.ZAPATO);
    scp.setMaterialEnSesion(new Material("#000000", null, TipoMaterial.CUERO));
    Ropero r = new Ropero();
    r.addPrenda(scp.createPrenda());
    Assertions.assertEquals(r.getCantidadPrendas(), 1);
  }

  @Test
  public void sePuedeGuardarUnBorradorDeUltimaPrendaParaRetomarloLuego() {
    Ropero r = new Ropero();

    SesionConstruccionPrenda scp1 = new SesionConstruccionPrenda();
    SesionConstruccionPrenda scp2 = new SesionConstruccionPrenda();

    SesionConstruccionPrenda sesionActual = scp1;
    sesionActual.setTipoPrendaEnSesion(TipoPrenda.ZAPATO);

    sesionActual = scp2;
    sesionActual.setTipoPrendaEnSesion(TipoPrenda.PANTALON);

    sesionActual = scp1;
    sesionActual.setMaterialEnSesion(new Material("#000000", null, TipoMaterial.CUERO));
    Prenda p1 = sesionActual.createPrenda();
    r.addPrenda(p1);

    sesionActual = scp2;
    sesionActual.setMaterialEnSesion(new Material("#000000", null, TipoMaterial.GABARDINA));
    Prenda p2 = sesionActual.createPrenda();
    r.addPrenda(p2);

    Assertions.assertEquals(r.getCantidadPrendas(), 2);
  }

}
