package domain.guardarropa;

public enum TipoPrivacidadGuardarropa {
  PUBLICO(true), PRIVADO(false);

  private boolean compartible;

  private TipoPrivacidadGuardarropa(boolean compartible) {
    this.compartible = compartible;
  }

  public boolean esCompartible() {
    return compartible;
  }
}
