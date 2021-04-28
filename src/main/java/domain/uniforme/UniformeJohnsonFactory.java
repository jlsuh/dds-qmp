package domain.uniforme;

public class UniformeJohnsonFactory extends UniformeFactory {

  @Override
  public Uniforme instanceUniforme() {
    return new UniformeJohnson();
  }

}
