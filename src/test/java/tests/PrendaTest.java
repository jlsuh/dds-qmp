package tests;

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

  BorradorPrenda bp;

  @BeforeEach
  public void initContext() {
    bp = new BorradorPrenda();
  }

  @Test
  public void unaPrendaPoseeUnTipo() {
    Prenda p = bp.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    Assertions.assertNotNull(p.getTipoPrenda());
  }

  @Test
  public void unaPrendaPoseeUnaCategoria() {
    Prenda p = bp.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    Assertions.assertNotNull(p.getTipoPrenda().getCategoria());
  }

  @Test
  public void unaPrendaPoseeUnMaterial() {
    Prenda p = bp.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    Assertions.assertNotNull(p.getTipoMaterial());
  }

  @Test
  public void unTipoDePrendaPoseeUnNombre() {
    Prenda p = bp.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    Assertions.assertNotNull(p.getTipoPrenda().getNombre());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiNoSeLeIndicoSuTipo() {
    Assertions.assertThrows(BorradorPrendaPoseeArgumentoInvalidoException.class,
        () -> bp.crearPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSeLeIndicoSuTipoPeroNoSuMaterial() {
    bp.configurarTipoPrenda(TipoPrenda.CHOMBA);
    Assertions.assertThrows(BorradorPrendaPoseeArgumentoInvalidoException.class,
        () -> bp.crearPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSoloSeLeIndicoElMaterial() {
    bp.configurarMaterial("#000000", "#ffffff", TipoMaterial.CUERO, null);
    Assertions.assertThrows(BorradorPrendaPoseeArgumentoInvalidoException.class,
        () -> bp.crearPrenda());
  }

  @Test
  public void noSePuedeCrearUnaPrendaSiSeLeIndicoSuTipoYMaterialPeroNoSonConsistentes() {
    bp.configurarTipoPrenda(TipoPrenda.CHOMBA);
    bp.configurarMaterial("#000000", "#ffffff", TipoMaterial.CUERO, null);
    Assertions.assertThrows(NoSePuedeCrearPrendaException.class, () -> bp.crearPrenda());
  }

  @Test
  public void sePuedeCrearUnaPrendaSiSeDanLasCondicionesYTipoConMaterialSonConsistentes() {
    bp.configurarTipoPrenda(TipoPrenda.CAMISA);
    bp.configurarMaterial("#000000", "#ffffff", TipoMaterial.ALGODON, null);
    Prenda p = bp.crearPrenda();
    HashSet<Prenda> listaPrenda = new HashSet<>();
    listaPrenda.add(p);
    Assertions.assertEquals(listaPrenda.size(), 1);
  }

  @Test
  public void sePuedeGuardarUnBorradorDeUltimaPrendaParaRetomarloLuego() {
    BorradorPrenda bpDummy = new BorradorPrenda();
    bpDummy.configurarTipoPrenda(TipoPrenda.CAMISA);
    bp.configurarTipoPrenda(TipoPrenda.ZAPATILLA);
    bpDummy.configurarMaterial("#000000", "#ffffff", TipoMaterial.ALGODON, null);
    bp.configurarMaterial("#000000", "#ffffff", TipoMaterial.CAUCHO, null);
    Prenda pDummy = bpDummy.crearPrenda();
    HashSet<Prenda> listaPrenda = new HashSet<>();
    listaPrenda.add(pDummy);
    Prenda p = bp.crearPrenda();
    listaPrenda.add(p);
    Assertions.assertEquals(listaPrenda.size(), 2);
  }

}
