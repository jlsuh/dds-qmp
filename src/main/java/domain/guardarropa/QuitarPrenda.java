package domain.guardarropa;

import domain.prenda.Prenda;

public class QuitarPrenda implements RecomendacionPrenda {

  private Prenda prendaSugerida;

  public QuitarPrenda(Prenda prendaSugerida) {
    this.prendaSugerida = prendaSugerida;
  }

  @Override
  public void aceptarRecomendacion(Guardarropas guardarropas) {
    guardarropas.quitarPrendaDeGuardarropas(this.prendaSugerida);
  }

  @Override
  public void deshacerRecomendacion(Guardarropas guardarropas) {
    guardarropas.agregarPrendaAGuardarropas(this.prendaSugerida);
  }

  public Prenda getPrendaSugerida() {
    return this.prendaSugerida;
  }

}
