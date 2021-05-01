package domain.uniforme;

public class UniformeJohnsonFactory extends UniformeFactory {

  @Override
  public Uniforme crearUniforme() {
    return new UniformeJohnson();
  }

}
