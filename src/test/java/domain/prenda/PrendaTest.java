package domain.prenda;

import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.exceptions.BorradorPrendaPoseeArgumentoInvalidoException;
import domain.exceptions.NoSePuedeCrearPrendaException;
import domain.material.TipoMaterial;
import domain.prenda.BorradorPrenda;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class PrendaTest {

  BorradorPrenda borradorPrenda;

  @BeforeEach
  public void initContext() {
    borradorPrenda = new BorradorPrenda();
  }

  @Test
  public void unaPrendaPoseeUnTipo() {
    Prenda prenda = borradorPrenda.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    Assertions.assertNotNull(prenda.getTipoPrenda());
  }

  @Test
  public void unaPrendaPoseeUnaCategoria() {
    Prenda prenda = borradorPrenda.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    Assertions.assertNotNull(prenda.getTipoPrenda().getCategoria());
  }

  @Test
  public void unaPrendaPoseeUnMaterial() {
    Prenda prenda = borradorPrenda.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    Assertions.assertNotNull(prenda.getTipoMaterial());
  }

  @Test
  public void unTipoDePrendaPoseeUnNombre() {
    Prenda prenda = borradorPrenda.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    Assertions.assertNotNull(prenda.getTipoPrenda().getNombre());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiNoSeLeIndicoSuTipo() {
    Assertions.assertThrows(BorradorPrendaPoseeArgumentoInvalidoException.class,
        () -> borradorPrenda.crearPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSeLeIndicoSuTipoPeroNoSuMaterial() {
    borradorPrenda.configurarTipoPrenda(TipoPrenda.CHOMBA);
    Assertions.assertThrows(BorradorPrendaPoseeArgumentoInvalidoException.class,
        () -> borradorPrenda.crearPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSoloSeLeIndicoElMaterial() {
    borradorPrenda.configurarMaterial("#000000", "#ffffff", TipoMaterial.CUERO, null);
    Assertions.assertThrows(BorradorPrendaPoseeArgumentoInvalidoException.class,
        () -> borradorPrenda.crearPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSeLeIndicoSuTipoYMaterialPeroNoSonConsistentes() {
    borradorPrenda.configurarTipoPrenda(TipoPrenda.CHOMBA);
    borradorPrenda.configurarMaterial("#000000", "#ffffff", TipoMaterial.CUERO, null);
    Assertions.assertThrows(NoSePuedeCrearPrendaException.class, () -> borradorPrenda.crearPrenda());
  }

  @Test
  public void sePuedeCrearUnaPrendaSiSeDanLasCondicionesYTipoConMaterialSonConsistentes() {
    borradorPrenda.configurarTipoPrenda(TipoPrenda.CAMISA);
    borradorPrenda.configurarMaterial("#000000", "#ffffff", TipoMaterial.ALGODON, null);
    Prenda prenda = borradorPrenda.crearPrenda();
    HashSet<Prenda> listaPrenda = new HashSet<>();
    listaPrenda.add(prenda);
    Assertions.assertEquals(listaPrenda.size(), 1);
  }

  @Test
  public void sePuedeGuardarUnBorradorDeUltimaPrendaParaRetomarloLuego() {
    BorradorPrenda borradorPrendaDummy = new BorradorPrenda();
    borradorPrendaDummy.configurarTipoPrenda(TipoPrenda.CAMISA);
    borradorPrenda.configurarTipoPrenda(TipoPrenda.ZAPATILLA);
    borradorPrendaDummy.configurarMaterial("#000000", "#ffffff", TipoMaterial.ALGODON, null);
    borradorPrenda.configurarMaterial("#000000", "#ffffff", TipoMaterial.CAUCHO, null);
    Prenda prendaDummy = borradorPrendaDummy.crearPrenda();
    HashSet<Prenda> listaPrenda = new HashSet<>();
    listaPrenda.add(prendaDummy);
    Prenda prenda = borradorPrenda.crearPrenda();
    listaPrenda.add(prenda);
    Assertions.assertEquals(listaPrenda.size(), 2);
  }

}
