package domain.uniforme;

public abstract class UniformeFactory {

  public Uniforme crearUniforme() {
    Uniforme uniforme = this.instanciarUniforme();
    this.configurarParteSuperior(uniforme);
    this.configurarParteInferior(uniforme);
    this.configurarCalzado(uniforme);
    return uniforme;
    // Antes: el uniforme parecía que tenía la responsabilidad de crearse a sí mismo.
    // Ahora: las propias fábricas poseen la responsabilidad de configurar a uniforme.
  }

  private Uniforme instanciarUniforme() {
    return new Uniforme();
    // Se eliminaron UniformeJohnson&UniformeSanJuan. En definitiva es un Uniforme, lo que varía es
    // la configuración interna (parteInferior, parteSuperior y calzado).
    // Si hubiésemos dejado UniformeJohnson&UniformeSanJuan en existencia, se hubiesen vuelto en
    // objetos anémicos.
  }

  // No sé qué tan correcto sea pasarle como parámetro a un objeto que va a configurar
  public abstract void configurarParteSuperior(Uniforme uniforme);

  public abstract void configurarParteInferior(Uniforme uniforme);

  public abstract void configurarCalzado(Uniforme uniforme);

}
