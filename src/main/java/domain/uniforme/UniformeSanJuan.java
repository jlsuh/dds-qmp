package domain.uniforme;

import domain.material.Material;
import domain.material.TipoMaterial;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class UniformeSanJuan extends Uniforme {

  @Override
  public void configurarParteSuperior() {
    Prenda parteSuperior = new Prenda(TipoPrenda.CHOMBA);
    Material material = new Material("#008f39", null, TipoMaterial.PIQUE);
    parteSuperior.setMaterial(material);
    super.setParteSuperior(parteSuperior);
  }

  @Override
  public void configurarParteInferior() {
    Prenda parteInferior = new Prenda(TipoPrenda.PANTALON);
    Material material = new Material("#9b9b9b", null, TipoMaterial.ACETATO);
    parteInferior.setMaterial(material);
    super.setParteInferior(parteInferior);
  }

  @Override
  public void configurarCalzado() {
    Prenda calzado = new Prenda(TipoPrenda.ZAPATILLA);
    Material material = new Material("#ffffff", null, TipoMaterial.CAUCHO);
    calzado.setMaterial(material);
    super.setCalzado(calzado);
  }


}
