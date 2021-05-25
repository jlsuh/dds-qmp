package domain.uniforme;

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
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteSuperior().getTipoPrenda(), TipoPrenda.CHOMBA);
  }

  @Test
  public void laPrendaSuperiorDelColegioSanJuanEsDeColorVerde() {
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteSuperior().getColorPrincipal(), "#008f39");
  }

  @Test
  public void laPrendaSuperiorDelColegioSanJuanEstaHechaDePique() {
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteSuperior().getTipoMaterial(),
        TipoMaterial.PIQUE);
  }

  @Test
  public void laPrendaInferiorDelColegioSanJuanEsUnPantalon() {
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteInferior().getTipoPrenda(),
        TipoPrenda.PANTALON);
  }

  @Test
  public void laPrendaInferiorDelColegioSanJuanEsDeColorGris() {
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteInferior().getColorPrincipal(), "#9b9b9b");
  }

  @Test
  public void laPrendaInferiorDelColegioSanJuanEstaHechaDeAcetato() {
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();
    Assertions.assertEquals(uniformeSanJuan.getParteInferior().getTipoMaterial(),
        TipoMaterial.ACETATO);
  }

  @Test
  public void elCalzadoDelColegioSanJuanEsUnParDeZapatillas() {
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();
    Assertions.assertEquals(uniformeSanJuan.getCalzado().getTipoPrenda(), TipoPrenda.ZAPATILLA);
  }

  @Test
  public void elCalzadoDelColegioSanJuanEsDeColorBlanco() {
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();

    Assertions.assertEquals(uniformeSanJuan.getCalzado().getColorPrincipal(), "#ffffff");
  }

  @Test
  public void elCalzadoDelColegioSanJuanEstaHechaDeCaucho() {
    UniformeSanJuanFactory uniformeSanJuanFactory = new UniformeSanJuanFactory();
    Uniforme uniformeSanJuan = uniformeSanJuanFactory.crearUniforme();
    Assertions.assertEquals(uniformeSanJuan.getCalzado().getTipoMaterial(), TipoMaterial.CAUCHO);
  }

  @Test
  public void laPrendaSuperiorDelColegioJohnsonEsDeTipoCamisa() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteSuperior().getTipoPrenda(), TipoPrenda.CAMISA);
  }

  @Test
  public void laPrendaSuperiorDelColegioJohnsonEsDeColorBlanco() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteSuperior().getColorPrincipal(), "#ffffff");
  }

  @Test
  public void laPrendaSuperiorDelColegioJohnsonEstaHechaDeNylon() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteSuperior().getTipoMaterial(),
        TipoMaterial.NYLON);
  }

  @Test
  public void laPrendaInferiorDelColegioJohnsonEsDeTipoPantalonDeVestir() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteInferior().getTipoPrenda(),
        TipoPrenda.PANTALONDEVESTIR);
  }

  @Test
  public void laPrendaInferiorDelColegioJohnsonEsDeColorNegro() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteInferior().getColorPrincipal(), "#000000");
  }

  @Test
  public void laPrendaInferiorDelColegioJohnsonEstaHechaDeAlgodon() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getParteInferior().getTipoMaterial(),
        TipoMaterial.ALGODON);
  }

  @Test
  public void elCalzadoDelColegioJohnsonEsUnParDeZapatos() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getCalzado().getTipoPrenda(), TipoPrenda.ZAPATO);
  }

  @Test
  public void elCalzadoDelColegioJohnsonEsDeColorNegro() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getCalzado().getColorPrincipal(), "#000000");
  }

  @Test
  public void elCalzadoDelColegioJohnsonEstaHechaDeCaucho() {
    UniformeJohnsonFactory uniformeJohnsonFactory = new UniformeJohnsonFactory();
    Uniforme uniformeJohnson = uniformeJohnsonFactory.crearUniforme();
    Assertions.assertEquals(uniformeJohnson.getCalzado().getTipoMaterial(), TipoMaterial.CAUCHO);
  }
}
