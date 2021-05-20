package domain.uniforme;

import domain.material.TipoMaterial;
import domain.prenda.BorradorPrenda;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class UniformeSanJuanFactory extends UniformeFactory {

  @Override
  public Prenda configurarParteSuperior() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteSuperior = borradorPrenda.configurarTipoPrenda(TipoPrenda.CHOMBA)
        .configurarMaterial("#008f39", null, TipoMaterial.PIQUE, null).crearPrenda();
    return parteSuperior;
  }

  @Override
  public Prenda configurarParteInferior() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteInferior = borradorPrenda.configurarTipoPrenda(TipoPrenda.PANTALON)
        .configurarMaterial("#9b9b9b", null, TipoMaterial.ACETATO, null).crearPrenda();
    return parteInferior;
  }

  @Override
  public Prenda configurarCalzado() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda calzado = borradorPrenda.configurarTipoPrenda(TipoPrenda.ZAPATILLA)
        .configurarMaterial("#ffffff", null, TipoMaterial.CAUCHO, null).crearPrenda();
    return calzado;
  }

}
