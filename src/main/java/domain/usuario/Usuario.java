package domain.usuario;

import java.util.List;
import domain.guardarropa.Guardarropas;

public class Usuario {

  private List<Guardarropas> guardarropas;

  public Usuario(List<Guardarropas> guardarropas) {
    this.guardarropas = guardarropas;
  }

  public void agregarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.add(guardarropas);
  }

  public void removerGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.remove(guardarropas);
  }

  public Guardarropas getGuardarropasEnIndice(Integer index) {
    return this.guardarropas.get(index);
  }

  public List<Guardarropas> getGuardarropas() {
    return this.guardarropas;
  }

}
