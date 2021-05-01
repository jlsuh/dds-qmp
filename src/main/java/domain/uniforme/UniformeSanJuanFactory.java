package domain.uniforme;

public class UniformeSanJuanFactory extends UniformeFactory {

  @Override
  public Uniforme crearUniforme() {
    return new UniformeSanJuan();
  }

}
