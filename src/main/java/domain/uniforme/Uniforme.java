package domain.uniforme;

import domain.prenda.Prenda;

public class Uniforme {

  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;

  // Contrato débil: sabemos que siempre un uniforme será instanciado a partir de la fábrica de
  // uniformes.
  public Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
  }

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  // public void setParteSuperior(Prenda parteSuperior) {
  // this.parteSuperior = parteSuperior;
  // }
  //
  // public void setParteInferior(Prenda parteInferior) {
  // this.parteInferior = parteInferior;
  // }
  //
  // public void setCalzado(Prenda calzado) {
  // this.calzado = calzado;
  // }

}
