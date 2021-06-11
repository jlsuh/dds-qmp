package domain.publishers;

import java.util.ArrayList;
import java.util.List;
import domain.prenda.GeneradorSugerencias;
import domain.suscripciones.SugerenciaDiariaSuscriber;

public class SugerenciaDiariaPublisher {

  private List<SugerenciaDiariaSuscriber> suscriptores = new ArrayList<>();
  private GeneradorSugerencias generadorSugerencias;

  public SugerenciaDiariaPublisher(GeneradorSugerencias generadorSugerencias) {
    this.generadorSugerencias = generadorSugerencias;
  }

  public void actualizarSugerenciaDiaria() {
    suscriptores
        .forEach(suscriptor -> suscriptor.actualizarSugerenciaDiaria(this.generadorSugerencias));
  }

  public void suscribirASugerenciaDiaria(SugerenciaDiariaSuscriber suscriptor) {
    this.suscriptores.add(suscriptor);
  }

  public void desuscribirASugerenciaDiaria(SugerenciaDiariaSuscriber suscriptor) {
    this.suscriptores.remove(suscriptor);
  }

  public List<SugerenciaDiariaSuscriber> getSuscriptores() {
    return this.suscriptores;
  }

}
