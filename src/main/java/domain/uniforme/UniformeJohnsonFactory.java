package domain.uniforme;

import domain.material.TipoMaterial;
import domain.prenda.BorradorPrenda;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class UniformeJohnsonFactory extends UniformeFactory {

  @Override
  public Prenda configurarParteSuperior() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteSuperior = borradorPrenda.configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#ffffff", null, TipoMaterial.NYLON, null).crearPrenda();
    return parteSuperior;
  }

  @Override
  public Prenda configurarParteInferior() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteInferior = borradorPrenda.configurarTipoPrenda(TipoPrenda.PANTALONDEVESTIR)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, null).crearPrenda();
    return parteInferior;
  }

  @Override
  public Prenda configurarCalzado() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda calzado = borradorPrenda.configurarTipoPrenda(TipoPrenda.ZAPATO)
        .configurarMaterial("#000000", null, TipoMaterial.CAUCHO, null).crearPrenda();
    return calzado;
  }

}
