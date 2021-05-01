package domain.uniforme;

import domain.material.TipoMaterial;
import domain.prenda.BorradorPrenda;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class UniformeJohnson extends Uniforme {

  @Override
  public void configurarParteSuperior() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteSuperior = borradorPrenda.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#ffffff", null, TipoMaterial.NYLON, null).crearPrenda();
    super.setParteSuperior(parteSuperior);
  }

  @Override
  public void configurarParteInferior() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteInferior = borradorPrenda.configurarTipoPrenda(TipoPrenda.PANTALONDEVESTIR)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    super.setParteInferior(parteInferior);
  }

  @Override
  public void configurarCalzado() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda calzado = borradorPrenda.configurarTipoPrenda(TipoPrenda.ZAPATO)
        .configurarMaterial("#000000", null, TipoMaterial.CAUCHO, null).crearPrenda();
    super.setCalzado(calzado);
  }

}
