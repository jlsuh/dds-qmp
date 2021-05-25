package domain.guardarropa;

import java.util.ArrayList;
import java.util.List;
import domain.exceptions.LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException;
import domain.exceptions.NoExistePrendaEnGuardaRropasException;
import domain.prenda.Prenda;

public class Guardarropas {

  private List<Prenda> prendas = new ArrayList<>();
  private CriterioGuardarropa criterioGuardarropas;
  private TipoPrivacidadGuardarropa tipoPrivacidadGuardarropa;
  private List<RecomendacionPrenda> recomendacionesPrenda = new ArrayList<>();

  public Guardarropas(CriterioGuardarropa criterioGuardarropas,
      TipoPrivacidadGuardarropa tipoPrivacidadGuardarropa) {
    this.criterioGuardarropas = criterioGuardarropas;
    this.tipoPrivacidadGuardarropa = tipoPrivacidadGuardarropa;
  }

  public void recomendarPrenda(Prenda prenda, TipoRecomendacion tipoRecomendacion) {
    RecomendacionPrenda nuevaRecomendacion = tipoRecomendacion == TipoRecomendacion.AGREGAR
        ? new RecomendacionPrenda(TipoRecomendacion.AGREGAR, prenda)
        : new RecomendacionPrenda(TipoRecomendacion.QUITAR, prenda);
    recomendacionesPrenda.add(nuevaRecomendacion);
  }

  public void aceptarRecomendacion(RecomendacionPrenda recomendacion) {
    Prenda prendaRecomendada = recomendacion.getPrendaRecomendada();
    if (sonDeIgualTipoDeRecomendacion(recomendacion.getTipoRecomendacion(),
        TipoRecomendacion.AGREGAR)) {
      this.agregarPrendaAGuardarropas(prendaRecomendada);
    } else if (sonDeIgualTipoDeRecomendacion(recomendacion.getTipoRecomendacion(),
        TipoRecomendacion.QUITAR)) {
      if (!this.prendas.contains(prendaRecomendada)) {
        throw new NoExistePrendaEnGuardaRropasException(
            "La prenda que se quiere quitar no existe en el guardarropas");
      }
      this.quitarPrendaDeGuardarropas(prendaRecomendada);
    }
    recomendacion.setEstadoRecomendacion(EstadoRecomendacion.ACEPTADA);
  }

  public void deshacerRecomendacionAceptada(RecomendacionPrenda recomendacionPrenda) {
    EstadoRecomendacion estadoRecomendacion = recomendacionPrenda.getEstadoRecomendacion();
    if (estadoRecomendacion != EstadoRecomendacion.ACEPTADA) {
      throw new LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException(
          "La recomendación no es una recomendación aceptada previamente");
    }
    this.deshacerSegunTipo(recomendacionPrenda);
  }

  public void deshacerSegunTipo(RecomendacionPrenda recomendacionADeshacer) {
    Prenda prendaARevertir = recomendacionADeshacer.getPrendaRecomendada();
    if (this.sonDeIgualTipoDeRecomendacion(recomendacionADeshacer.getTipoRecomendacion(),
        TipoRecomendacion.AGREGAR)) {
      this.quitarPrendaDeGuardarropas(prendaARevertir);
    } else {
      this.agregarPrendaAGuardarropas(prendaARevertir);
    }
  }

  private boolean sonDeIgualTipoDeRecomendacion(TipoRecomendacion unaRecomendacion,
      TipoRecomendacion otraRecomendacion) {
    return unaRecomendacion.equals(otraRecomendacion);
  }

  public void rechazarRecomendacion(RecomendacionPrenda recomendacionAQuitar) {
    this.quitarRecomendacion(recomendacionAQuitar);
    recomendacionAQuitar.setEstadoRecomendacion(EstadoRecomendacion.RECHAZADA);
  }

  private void quitarRecomendacion(RecomendacionPrenda recomendacionAQuitar) {
    this.recomendacionesPrenda.remove(recomendacionAQuitar);
  }

  public boolean esCompartible() {
    return this.tipoPrivacidadGuardarropa.esCompartible();
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

  public TipoPrivacidadGuardarropa getTipoPrivacidadGuardarropa() {
    return this.tipoPrivacidadGuardarropa;
  }

  public List<Prenda> getPrendas() {
    return this.prendas;
  }

  public List<RecomendacionPrenda> getRecomendacionesPrenda() {
    return this.recomendacionesPrenda;
  }
}
