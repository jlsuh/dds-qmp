package domain.exceptions;

public class TipoPrendaNoEsConsistenteConSuMaterialException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public TipoPrendaNoEsConsistenteConSuMaterialException(String message) {
    super(message);
  }

}
