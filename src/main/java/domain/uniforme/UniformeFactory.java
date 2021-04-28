package domain.uniforme;

public abstract class UniformeFactory {

  public Uniforme createUniforme() {
    Uniforme uniforme = this.instanceUniforme();
    uniforme.configurarParteSuperior();
    uniforme.configurarParteInferior();
    uniforme.configurarCalzado();
    return uniforme;
  }

  protected abstract Uniforme instanceUniforme();

}
