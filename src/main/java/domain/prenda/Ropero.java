package domain.prenda;

import java.util.HashSet;

public class Ropero {

  private HashSet<Prenda> prendas = new HashSet<>();

  public void addPrenda(Prenda unaPrenda) {
    prendas.add(unaPrenda);
  }

  public int getCantidadPrendas() {
    return prendas.size();
  }

}
