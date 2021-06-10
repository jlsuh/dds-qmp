package domain.guardarropa;

import domain.prenda.Prenda;

public class AgregarPrenda implements RecomendacionPrenda {

  private Prenda prendaSugerida;

  public AgregarPrenda(Prenda prendaSugerida) {
    this.prendaSugerida = prendaSugerida;
  }

  @Override
  public void aceptarRecomendacion(Guardarropas guardarropas) {
    guardarropas.agregarPrendaAGuardarropas(this.prendaSugerida);
  }

  @Override
  public void deshacerRecomendacion(Guardarropas guardarropas) {
    guardarropas.quitarPrendaDeGuardarropas(this.prendaSugerida);
  }

  public Prenda getPrendaSugerida() {
    return this.prendaSugerida;
  }

}
