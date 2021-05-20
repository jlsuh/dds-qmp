package domain.uniforme;

import domain.material.TipoMaterial;
import domain.prenda.BorradorPrenda;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class UniformeSanJuanFactory extends UniformeFactory {

  @Override
  public void configurarParteSuperior(Uniforme uniforme) {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteSuperior = borradorPrenda.configurarTipoPrenda(TipoPrenda.CHOMBA)
        .configurarMaterial("#008f39", null, TipoMaterial.PIQUE, null).crearPrenda();
    uniforme.setParteSuperior(parteSuperior);
  }

  @Override
  public void configurarParteInferior(Uniforme uniforme) {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda parteInferior = borradorPrenda.configurarTipoPrenda(TipoPrenda.PANTALON)
        .configurarMaterial("#9b9b9b", null, TipoMaterial.ACETATO, null).crearPrenda();
    uniforme.setParteInferior(parteInferior);
  }

  @Override
  public void configurarCalzado(Uniforme uniforme) {
    BorradorPrenda borradorPrenda = new BorradorPrenda();
    Prenda calzado = borradorPrenda.configurarTipoPrenda(TipoPrenda.ZAPATILLA)
        .configurarMaterial("#ffffff", null, TipoMaterial.CAUCHO, null).crearPrenda();
    uniforme.setCalzado(calzado);
  }

}
