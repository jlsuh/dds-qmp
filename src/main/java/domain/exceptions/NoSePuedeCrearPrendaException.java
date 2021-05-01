package domain.exceptions;

public class NoSePuedeCrearPrendaException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NoSePuedeCrearPrendaException(String message) {
    super(message);
  }

}
