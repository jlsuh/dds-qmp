package domain.uniforme;

import domain.material.Material;
import domain.material.TipoMaterial;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class UniformeJohnson extends Uniforme {

  @Override
  public void configurarParteSuperior() {
    Prenda parteSuperior = new Prenda(TipoPrenda.CAMISA);
    Material material = new Material("#ffffff", null, TipoMaterial.NYLON);
    parteSuperior.setMaterial(material);
    super.setParteSuperior(parteSuperior);
  }

  @Override
  public void configurarParteInferior() {
    Prenda parteInferior = new Prenda(TipoPrenda.PANTALONDEVESTIR);
    Material material = new Material("#000000", null, TipoMaterial.ALGODON);
    parteInferior.setMaterial(material);
    super.setParteInferior(parteInferior);
  }

  @Override
  public void configurarCalzado() {
    Prenda calzado = new Prenda(TipoPrenda.ZAPATO);
    Material material = new Material("#000000", null, TipoMaterial.CAUCHO);
    calzado.setMaterial(material);
    super.setCalzado(calzado);
  }

}
