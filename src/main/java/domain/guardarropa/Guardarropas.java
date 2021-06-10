package domain.guardarropa;

import java.util.ArrayList;
import java.util.List;
import domain.prenda.Prenda;

public class Guardarropas {

  private List<Prenda> prendas = new ArrayList<>();
  private CriterioGuardarropa criterioGuardarropas;
  private List<RecomendacionPrenda> recomendacionesAceptadas = new ArrayList<>();
  private List<RecomendacionPrenda> recomendacionesPendientes = new ArrayList<>();

  public Guardarropas(CriterioGuardarropa criterioGuardarropas) {
    this.criterioGuardarropas = criterioGuardarropas;
  }

  public void recomendarPrenda(RecomendacionPrenda recomendacionPrenda) {
    recomendacionesPendientes.add(recomendacionPrenda);
  }

  public void aceptarRecomendacion(RecomendacionPrenda recomendacion) {
    recomendacion.aceptarRecomendacion(this);
    this.quitarRecomendacionDePendientes(recomendacion);
    this.recomendacionesAceptadas.add(recomendacion);
  }

  public void deshacerRecomendacionAceptada(RecomendacionPrenda recomendacionAceptada) {
    recomendacionAceptada.deshacerRecomendacion(this);
    this.recomendacionesAceptadas.remove(recomendacionAceptada);
  }

  // TODO: Este es el método que permite no aceptar las recomendaciones
  public void quitarRecomendacionDePendientes(RecomendacionPrenda recomendacionAQuitar) {
    this.recomendacionesPendientes.remove(recomendacionAQuitar);
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

  public List<RecomendacionPrenda> getRecomendacionesPendientes() {
    return this.recomendacionesPendientes;
  }

  public List<RecomendacionPrenda> getRecomendacionesAceptadas() {
    return this.recomendacionesAceptadas;
  }
}
