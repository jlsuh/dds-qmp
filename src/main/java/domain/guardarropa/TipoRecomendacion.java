package domain.guardarropa;

import domain.exceptions.NoExistePrendaEnGuardarropasException;
import domain.prenda.Prenda;

public enum TipoRecomendacion {
  AGREGAR {
    @Override
    public RecomendacionPrenda crearRecomendacion(Prenda prenda) {
      return new RecomendacionPrenda(this, prenda);
    }

    @Override
    public void responderAAceptacionDeRecomendacion(Guardarropas guardarropas, Prenda prenda) {
      guardarropas.agregarPrendaAGuardarropas(prenda);
    }

    @Override
    public void responderADeshacerRecomendacion(Guardarropas guardarropas, Prenda prenda) {
      guardarropas.quitarPrendaDeGuardarropas(prenda);
    }
  },
  QUITAR {
    @Override
    public RecomendacionPrenda crearRecomendacion(Prenda prenda) {
      return new RecomendacionPrenda(this, prenda);
    }

    @Override
    public void responderAAceptacionDeRecomendacion(Guardarropas guardarropas, Prenda prenda) {
      if (!guardarropas.contienePrenda(prenda)) {
        throw new NoExistePrendaEnGuardarropasException(
            "La prenda que se desea quitar no existe en el guardarropas");
      }
      guardarropas.quitarPrendaDeGuardarropas(prenda);
    }

    @Override
    public void responderADeshacerRecomendacion(Guardarropas guardarropas, Prenda prenda) {
      guardarropas.agregarPrendaAGuardarropas(prenda);
    }
  };

  public abstract RecomendacionPrenda crearRecomendacion(Prenda prenda);

  public abstract void responderAAceptacionDeRecomendacion(Guardarropas guardarropas,
      Prenda prenda); // TODO: Huele a misplaced method

  public abstract void responderADeshacerRecomendacion(Guardarropas guardarropas, Prenda prenda);
}
