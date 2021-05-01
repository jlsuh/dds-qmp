package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.material.TipoMaterial;
import domain.prenda.TipoPrenda;
import domain.uniforme.Uniforme;
import domain.uniforme.UniformeJohnsonFactory;
import domain.uniforme.UniformeSanJuanFactory;

public class UniformeTest {

  @Test
  public void elTipoDePrendaSuperiorDelColegioSanJuanEsUnaChomba() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteSuperior().getTipoPrenda(), TipoPrenda.CHOMBA);
  }

  @Test
  public void laPrendaSuperiorDelColegioSanJuanEsDeColorVerde() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteSuperior().getColorPrincipal(), "#008f39");
  }

  @Test
  public void laPrendaSuperiorDelColegioSanJuanEstaHechaDePique() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteSuperior().getTipoMaterial(),
        TipoMaterial.PIQUE);
  }

  @Test
  public void laPrendaInferiorDelColegioSanJuanEsUnPantalon() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteInferior().getTipoPrenda(),
        TipoPrenda.PANTALON);
  }

  @Test
  public void laPrendaInferiorDelColegioSanJuanEsDeColorGris() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteInferior().getColorPrincipal(), "#9b9b9b");
  }

  @Test
  public void laPrendaInferiorDelColegioSanJuanEstaHechaDeAcetato() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteInferior().getTipoMaterial(),
        TipoMaterial.ACETATO);
  }

  @Test
  public void elCalzadoDelColegioSanJuanEsUnParDeZapatillas() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getCalzado().getTipoPrenda(), TipoPrenda.ZAPATILLA);
  }

  @Test
  public void elCalzadoDelColegioSanJuanEsDeColorBlanco() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();

    Assertions.assertEquals(uniformeSanJuan.getCalzado().getColorPrincipal(), "#ffffff");
  }

  @Test
  public void elCalzadoDelColegioSanJuanEstaHechaDeCaucho() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getCalzado().getTipoMaterial(), TipoMaterial.CAUCHO);
  }

  @Test
  public void laPrendaSuperiorDelColegioJohnsonEsDeTipoCamisa() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteSuperior().getTipoPrenda(), TipoPrenda.CAMISA);
  }

  @Test
  public void laPrendaSuperiorDelColegioJohnsonEsDeColorBlanco() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteSuperior().getColorPrincipal(), "#ffffff");
  }

  @Test
  public void laPrendaSuperiorDelColegioJohnsonEstaHechaDeNylon() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteSuperior().getTipoMaterial(),
        TipoMaterial.NYLON);
  }

  @Test
  public void laPrendaInferiorDelColegioJohnsonEsDeTipoPantalonDeVestir() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteInferior().getTipoPrenda(),
        TipoPrenda.PANTALONDEVESTIR);
  }

  @Test
  public void laPrendaInferiorDelColegioJohnsonEsDeColorNegro() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteInferior().getColorPrincipal(), "#000000");
  }

  @Test
  public void laPrendaInferiorDelColegioJohnsonEstaHechaDeAlgodon() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteInferior().getTipoMaterial(),
        TipoMaterial.ALGODON);
  }

  @Test
  public void elCalzadoDelColegioJohnsonEsUnParDeZapatos() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getCalzado().getTipoPrenda(), TipoPrenda.ZAPATO);
  }

  @Test
  public void elCalzadoDelColegioJohnsonEsDeColorNegro() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getCalzado().getColorPrincipal(), "#000000");
  }

  @Test
  public void elCalzadoDelColegioJohnsonEstaHechaDeCaucho() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getCalzado().getTipoMaterial(), TipoMaterial.CAUCHO);
  }

}
