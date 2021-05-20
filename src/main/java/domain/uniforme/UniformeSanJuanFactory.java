package domain.uniforme;

public class UniformeSanJuanFactory extends UniformeFactory {

  @Override
  public Uniforme instanciarUniforme() {
    return new UniformeSanJuan();
  }

}
