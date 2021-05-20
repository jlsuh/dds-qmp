package domain.uniforme;

public abstract class UniformeFactory {

  public Uniforme crearUniforme() {
    Uniforme uniforme = this.instanciarUniforme();
    uniforme.configurarParteSuperior();
    uniforme.configurarParteInferior();
    uniforme.configurarCalzado();
    return uniforme;
  }

  protected abstract Uniforme instanciarUniforme();

}
