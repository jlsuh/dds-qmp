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
    Assertions.assertEquals(uniformeSanJuan.getParteSuperior().getMaterial().getColorPrincipal(),
        "#008f39");
  }

  @Test
  public void laPrendaSuperiorDelColegioSanJuanEstaHechaDePique() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteSuperior().getMaterial().getTipoMaterial(),
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
    Assertions.assertEquals(uniformeSanJuan.getParteInferior().getMaterial().getColorPrincipal(),
        "#9b9b9b");
  }

  @Test
  public void laPrendaInferiorDelColegioSanJuanEstaHechaDeAcetato() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteInferior().getMaterial().getTipoMaterial(),
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
    Assertions.assertEquals(uniformeSanJuan.getCalzado().getMaterial().getColorPrincipal(),
        "#ffffff");
  }

  @Test
  public void elCalzadoDelColegioSanJuanEstaHechaDeCaucho() {
    UniformeSanJuanFactory usjf = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = usjf.createUniforme();
    Assertions.assertEquals(uniformeSanJuan.getCalzado().getMaterial().getTipoMaterial(),
        TipoMaterial.CAUCHO);
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
    Assertions.assertEquals(uniformeJohnson.getParteSuperior().getMaterial().getColorPrincipal(),
        "#ffffff");
  }

  @Test
  public void laPrendaSuperiorDelColegioJohnsonEstaHechaDeNylon() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteSuperior().getMaterial().getTipoMaterial(),
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
    Assertions.assertEquals(uniformeJohnson.getParteInferior().getMaterial().getColorPrincipal(),
        "#000000");
  }

  @Test
  public void laPrendaInferiorDelColegioJohnsonEstaHechaDeAlgodon() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteInferior().getMaterial().getTipoMaterial(),
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
    Assertions.assertEquals(uniformeJohnson.getCalzado().getMaterial().getColorPrincipal(),
        "#000000");
  }

  @Test
  public void elCalzadoDelColegioJohnsonEstaHechaDeCaucho() {
    UniformeJohnsonFactory ujf = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = ujf.createUniforme();
    Assertions.assertEquals(uniformeJohnson.getCalzado().getMaterial().getTipoMaterial(),
        TipoMaterial.CAUCHO);
  }

}
