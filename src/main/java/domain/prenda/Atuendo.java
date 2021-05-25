package domain.prenda;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {

  Prenda prendaSuperior;
  Prenda prendaInferior;
  Prenda calzado;
  Prenda accesorio;

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado,
      Prenda accesorio) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
    this.accesorio = accesorio;
  }

  public List<Prenda> getListadoPrenda() {
    List<Prenda> prendas = new ArrayList<>();
    prendas.add(prendaSuperior);
    prendas.add(prendaInferior);
    prendas.add(calzado);
    prendas.add(accesorio);
    return prendas;
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
