package domain.usuario;

import java.util.ArrayList;
import java.util.List;
import domain.guardarropa.Guardarropas;
import domain.prenda.Atuendo;
import domain.prenda.GeneradorSugerencias;
import domain.suscripciones.AlertaMeteorologicaMailSuscriber;
import domain.suscripciones.SugerenciaDiariaSuscriber;

public class Usuario implements SugerenciaDiariaSuscriber, AlertaMeteorologicaMailSuscriber {

  private List<Guardarropas> guardarropas;
  private Atuendo sugerenciaDiaria;
  private String email;

  public Usuario(List<Guardarropas> guardarropas, String email) {
    this.guardarropas = guardarropas;
    this.email = email;
  }

  public void agregarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.add(guardarropas);
  }

  public void removerGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.remove(guardarropas);
  }

  @Override
  public void actualizarSugerenciaDiaria(GeneradorSugerencias generadorSugerencias) {
    List<Atuendo> sugerenciasGeneradas = new ArrayList<>();
    this.guardarropas.forEach(guardarropas -> sugerenciasGeneradas
        .addAll(generadorSugerencias.generarSugerenciasDesde(guardarropas.getPrendas())));
    this.sugerenciaDiaria = sugerenciasGeneradas.get(0);
  }

  @Override
  public void recibirMailAlertaMeteorologica() {
    // TODO: Implementar
  }

  public Guardarropas getGuardarropasEnIndice(Integer index) {
    return this.guardarropas.get(index);
  }

  public List<Guardarropas> getGuardarropas() {
    return this.guardarropas;
  }

  public Atuendo getSugerenciaDiaria() {
    return this.sugerenciaDiaria;
  }

  public String getAdress() {
    return this.email;
  }

}
