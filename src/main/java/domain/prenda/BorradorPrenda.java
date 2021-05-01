package domain.prenda;

import domain.exceptions.BorradorPrendaPoseeArgumentoInvalidoException;
import domain.exceptions.NoSePuedeCrearPrendaException;
import domain.material.TipoMaterial;
import domain.material.Trama;

public class BorradorPrenda {
  private TipoPrenda tipoPrenda;
  private TipoMaterial tipoMaterial;
  private Trama tramaPorDefecto = Trama.LISA;
  private Trama trama;
  private String colorPrincipal;
  private String colorSecundario;

  public BorradorPrenda configurarTipoPrenda(TipoPrenda tipoPrenda) {
    validarTipoPrenda(tipoPrenda);
    this.tipoPrenda = tipoPrenda;
    return this;
  }

  public BorradorPrenda configurarMaterial(String colorPrincipal, String colorSecundario,
      TipoMaterial tipoMaterial, Trama trama) {
    validarMaterial(colorPrincipal, tipoMaterial);
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.tipoMaterial = tipoMaterial;
    this.trama = trama == null ? tramaPorDefecto : trama;
    return this;
  }

  public Prenda crearPrenda() {
    validarPrenda(tipoPrenda, colorPrincipal, tipoMaterial);
    if (!tipoPrenda.esConsistente(tipoMaterial)) {
      throw new NoSePuedeCrearPrendaException(
          "El tipo de prenda no es consistente con el tipo material");
    }
    return new Prenda(this.tipoPrenda, this.tipoMaterial, this.trama, this.colorPrincipal,
        this.colorSecundario);
  }

  private static void validarPrenda(TipoPrenda tipoPrenda, String colorPrincipal,
      TipoMaterial tipoMaterial) {
    validarTipoPrenda(tipoPrenda);
    validarMaterial(colorPrincipal, tipoMaterial);
  }

  private static void validarMaterial(String colorPrincipal, TipoMaterial tipoMaterial) {
    if (esNulo(colorPrincipal) || esNulo(tipoMaterial)) {
      throw new BorradorPrendaPoseeArgumentoInvalidoException(
          "Los valores relacionados a los aspectos del material son inválidos");
    }
  }

  private static void validarTipoPrenda(TipoPrenda tipoPrenda) {
    if (esNulo(tipoPrenda)) {
      throw new BorradorPrendaPoseeArgumentoInvalidoException(
          "El valor del tipo de prenda es inválido");
    }
  }

  private static boolean esNulo(Object o) {
    return o == null;
  }

}
