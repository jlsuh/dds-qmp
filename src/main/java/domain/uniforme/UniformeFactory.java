package domain.uniforme;

public abstract class UniformeFactory {

  public Uniforme createUniforme() {
    Uniforme uniforme = this.crearUniforme();
    uniforme.configurarParteSuperior();
    uniforme.configurarParteInferior();
    uniforme.configurarCalzado();
    return uniforme;
  }

  protected abstract Uniforme crearUniforme();

}
