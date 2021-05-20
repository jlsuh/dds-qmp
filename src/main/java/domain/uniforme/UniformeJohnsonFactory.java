package domain.uniforme;

public class UniformeJohnsonFactory extends UniformeFactory {

  @Override
  public Uniforme instanciarUniforme() {
    return new UniformeJohnson();
  }

}
