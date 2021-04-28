package domain.uniforme;

public class UniformeSanJuanFactory extends UniformeFactory {

  @Override
  public Uniforme instanceUniforme() {
    return new UniformeSanJuan();
  }

}
