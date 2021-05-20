package domain.prenda;

public class Sugerencia {

  Prenda prendaSuperior;
  Prenda prendaInferior;
  Prenda calzado;
  Prenda accesorio;

  public Sugerencia(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado,
      Prenda accesorio) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
    this.accesorio = accesorio;
  }

  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  public Prenda getAccesorio() {
    return accesorio;
  }

}
