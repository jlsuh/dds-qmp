package domain.uniforme;

import domain.prenda.Prenda;

public abstract class Uniforme {

  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  public void setParteSuperior(Prenda parteSuperior) {
    this.parteSuperior = parteSuperior;
  }

  public void setParteInferior(Prenda parteInferior) {
    this.parteInferior = parteInferior;
  }

  public void setCalzado(Prenda calzado) {
    this.calzado = calzado;
  }

  public abstract void configurarParteSuperior();

  public abstract void configurarParteInferior();

  public abstract void configurarCalzado();

}
