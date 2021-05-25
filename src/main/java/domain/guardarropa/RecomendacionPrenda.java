package domain.guardarropa;

import domain.prenda.Prenda;

public class RecomendacionPrenda {

  private TipoRecomendacion tipoRecomendacion;
  private EstadoRecomendacion estadoRecomendacion = EstadoRecomendacion.PENDIENTE;
  private Prenda prendaRecomendada;

  public RecomendacionPrenda(TipoRecomendacion tipoRecomendacion, Prenda prendaRecomendada) {
    this.tipoRecomendacion = tipoRecomendacion;
    this.prendaRecomendada = prendaRecomendada;
  }

  public EstadoRecomendacion getEstadoRecomendacion() {
    return this.estadoRecomendacion;
  }

  public TipoRecomendacion getTipoRecomendacion() {
    return this.tipoRecomendacion;
  }

  public Prenda getPrendaRecomendada() {
    return this.prendaRecomendada;
  }

  public void setEstadoRecomendacion(EstadoRecomendacion estadoRecomendacion) {
    this.estadoRecomendacion = estadoRecomendacion;
  }
}
