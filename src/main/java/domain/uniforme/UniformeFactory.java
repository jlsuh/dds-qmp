package domain.uniforme;

import domain.prenda.Prenda;

public abstract class UniformeFactory { // Un engendro de factory

  public Uniforme crearUniforme() {
    return new Uniforme(this.configurarParteSuperior(), this.configurarParteInferior(),
        this.configurarCalzado());
    // Antes: el uniforme tenía la responsabilidad de crearse a sí mismo.
    // Ahora: las propias fábricas poseen la responsabilidad de configurar a uniforme.
  }
  // TODO Detractores: hay lógica repetida en los métodos de configuración (parteSuperior,
  // parteInferior & calzado). La lógica repetida yace en que los 3 métodos poseen el mismo orden de
  // llamada a los métodos.

  public abstract Prenda configurarParteSuperior();

  public abstract Prenda configurarParteInferior();

  public abstract Prenda configurarCalzado();

}
