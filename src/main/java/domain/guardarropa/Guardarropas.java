package domain.guardarropa;

import java.util.ArrayList;
import java.util.List;
import domain.exceptions.LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException;
import domain.prenda.Prenda;

public class Guardarropas {

  private List<Prenda> prendas = new ArrayList<>();
  private CriterioGuardarropa criterioGuardarropas;
  private List<RecomendacionPrenda> recomendacionesPrenda = new ArrayList<>();

  public Guardarropas(CriterioGuardarropa criterioGuardarropas) {
    this.criterioGuardarropas = criterioGuardarropas;
  }

  public void recomendarPrenda(Prenda prenda, TipoRecomendacion tipoRecomendacion) {
    RecomendacionPrenda nuevaRecomendacion = tipoRecomendacion.crearRecomendacion(prenda); // TODO: Eliminar
    recomendacionesPrenda.add(nuevaRecomendacion);
  }

  public void aceptarRecomendacion(RecomendacionPrenda recomendacion) {
    Prenda prendaRecomendada = recomendacion.getPrendaRecomendada();
    recomendacion.getTipoRecomendacion().responderAAceptacionDeRecomendacion(this,
        prendaRecomendada);
    recomendacion.setEstadoRecomendacion(EstadoRecomendacion.ACEPTADA);
  }

  public boolean contienePrenda(Prenda prenda) {
    return this.prendas.contains(prenda);
  }

  public void deshacerRecomendacionAceptada(RecomendacionPrenda recomendacionPrenda) {
    EstadoRecomendacion estadoRecomendacion = recomendacionPrenda.getEstadoRecomendacion();
    if (!estadoRecomendacion.equals(EstadoRecomendacion.ACEPTADA)) {
      throw new LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException(
          "La recomendación no es una recomendación que se haya aceptado previamente");
    }
    this.deshacerRecomendacion(recomendacionPrenda);
  }

  public void deshacerRecomendacion(RecomendacionPrenda recomendacionADeshacer) {
    Prenda prendaARevertir = recomendacionADeshacer.getPrendaRecomendada();
    recomendacionADeshacer.getTipoRecomendacion().responderADeshacerRecomendacion(this,
        prendaARevertir);
  }

  public void rechazarRecomendacion(RecomendacionPrenda recomendacionAQuitar) {
    this.quitarRecomendacion(recomendacionAQuitar);
    recomendacionAQuitar.setEstadoRecomendacion(EstadoRecomendacion.RECHAZADA);
  }

  private void quitarRecomendacion(RecomendacionPrenda recomendacionAQuitar) {
    this.recomendacionesPrenda.remove(recomendacionAQuitar);
  }

  public void agregarPrendaAGuardarropas(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void quitarPrendaDeGuardarropas(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public CriterioGuardarropa getCriterioGuardarropa() {
    return this.criterioGuardarropas;
  }

  public List<Prenda> getPrendas() {
    return this.prendas;
  }

  public List<RecomendacionPrenda> getRecomendacionesPrenda() {
    return this.recomendacionesPrenda;
  }
}
