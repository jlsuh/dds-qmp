package domain.exceptions;

public class NoSePuedoCrearPrendaException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NoSePuedoCrearPrendaException(String message) {
    super(message);
  }

}
