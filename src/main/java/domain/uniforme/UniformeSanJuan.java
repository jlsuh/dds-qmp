package domain.uniforme;

import domain.material.TipoMaterial;
import domain.prenda.BorradorPrenda;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class UniformeSanJuan extends Uniforme {

  @Override
  public void configurarParteSuperior() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteSuperior = borradorPrenda.configurarTipoPrenda(TipoPrenda.CHOMBA)
        .configurarMaterial("#008f39", null, TipoMaterial.PIQUE, null).crearPrenda();
    super.setParteSuperior(parteSuperior);
  }

  @Override
  public void configurarParteInferior() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteInferior = borradorPrenda.configurarTipoPrenda(TipoPrenda.PANTALON)
        .configurarMaterial("#9b9b9b", null, TipoMaterial.ACETATO, null).crearPrenda();
    super.setParteInferior(parteInferior);
  }

  @Override
  public void configurarCalzado() {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda calzado = borradorPrenda.configurarTipoPrenda(TipoPrenda.ZAPATILLA)
        .configurarMaterial("#ffffff", null, TipoMaterial.CAUCHO, null).crearPrenda();
    super.setCalzado(calzado);
  }

}
