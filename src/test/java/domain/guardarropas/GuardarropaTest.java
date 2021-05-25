package domain.guardarropas;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.exceptions.LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException;
import domain.exceptions.NoExistePrendaEnGuardaRropasException;
import domain.guardarropa.CriterioGuardarropa;
import domain.guardarropa.Guardarropas;
import domain.guardarropa.TipoPrivacidadGuardarropa;
import domain.guardarropa.TipoRecomendacion;
import domain.material.TipoMaterial;
import domain.material.Trama;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;

public class GuardarropaTest {

  private Guardarropas guardarropasPublico;
  private Guardarropas guardarropasPrivado;
  private List<Guardarropas> listaGuardarropas;
  private Prenda pantalonDeVestir;
  private Prenda brazalete;
  private Prenda zapatillas;
  private Prenda remeraMangaLarga;
  private Guardarropas guardarropas;

  @BeforeEach
  public void fixture() {
    guardarropasPublico =
        new Guardarropas(CriterioGuardarropa.ENTRECASA, TipoPrivacidadGuardarropa.PUBLICO);
    guardarropasPrivado =
        new Guardarropas(CriterioGuardarropa.VIAJE, TipoPrivacidadGuardarropa.PRIVADO);
    listaGuardarropas = new ArrayList<>();
    pantalonDeVestir =
        new Prenda(TipoPrenda.PANTALONDEVESTIR, TipoMaterial.ALGODON, null, "#000000", "#5745f3");
    brazalete =
        new Prenda(TipoPrenda.BRAZALETE, TipoMaterial.PLASTICO, Trama.ACUADROS, "#fa32b2", null);
    zapatillas = new Prenda(TipoPrenda.ZAPATILLA, TipoMaterial.CAUCHO, null, "#ffffff", "#0982af");
    remeraMangaLarga = new Prenda(TipoPrenda.REMERAMANGALARGA, TipoMaterial.ALGODON,
        Trama.ESTAMPADO, "#000000", "#fab023");
    listaGuardarropas.add(guardarropasPublico);
    listaGuardarropas.add(guardarropasPrivado);
    guardarropas = listaGuardarropas.get(0);
  }

  @Test
  public void unGuardarropasPublicoPoseeCriterioEntreCasa() {
    Assertions.assertEquals(listaGuardarropas.get(0).getCriterioGuardarropa(),
        CriterioGuardarropa.ENTRECASA);
  }

  @Test
  public void unGuardarropasPublicoPoseeCriterioViaje() {
    Assertions.assertEquals(listaGuardarropas.get(1).getCriterioGuardarropa(),
        CriterioGuardarropa.VIAJE);
  }

  @Test
  public void sePuedeManejarVariasGuardarropasALaVez() {
    listaGuardarropas.get(0).agregarPrendaAGuardarropas(pantalonDeVestir);
    listaGuardarropas.get(1).agregarPrendaAGuardarropas(brazalete);
    Assertions.assertEquals(listaGuardarropas.stream().map(g -> g.getPrendas().size()).count(), 2);
  }

  @Test
  public void sePuedenAgregarYQuitarPrendasDeUnGuardarropas() {
    listaGuardarropas.get(1).agregarPrendaAGuardarropas(pantalonDeVestir);
    listaGuardarropas.get(1).agregarPrendaAGuardarropas(brazalete);
    Assertions.assertEquals(listaGuardarropas.get(1).getPrendas().size(), 2);
    listaGuardarropas.get(1).quitarPrendaDeGuardarropas(brazalete);
    Assertions.assertEquals(listaGuardarropas.get(1).getPrendas().size(), 1);
  }

  @Test
  public void unGuardarropasPublicoEsCompartible() {
    Assertions.assertTrue(listaGuardarropas.get(0).esCompartible());
  }

  @Test
  public void unGuardarropasPrivadoNoEsCompartible() {
    Assertions.assertFalse(listaGuardarropas.get(1).esCompartible());
  }

  @Test
  public void seProponeTentativamenteAgregarUnaPrendaAlGuardarropasPublico() {
    listaGuardarropas.get(0).recomendarPrenda(zapatillas, TipoRecomendacion.AGREGAR);
    Assertions.assertEquals(listaGuardarropas.get(0).getRecomendacionesPrenda().size(), 1);
  }

  @Test
  public void seProponeTentativamenteAgregarUnaPrendaAlGuardarropasPrivado() {
    listaGuardarropas.get(1).recomendarPrenda(remeraMangaLarga, TipoRecomendacion.AGREGAR);
    Assertions.assertEquals(listaGuardarropas.get(1).getRecomendacionesPrenda().size(), 1);
  }

  @Test
  public void seProponeTentativamenteQuitarUnaPrendaDelGuardarropasPublico() {
    listaGuardarropas.get(0).recomendarPrenda(pantalonDeVestir, TipoRecomendacion.QUITAR);
    Assertions.assertEquals(listaGuardarropas.get(0).getRecomendacionesPrenda().size(), 1);
  }

  @Test
  public void seProponeTentativamenteQuitarUnaPrendaDelGuardarropasPrivado() {
    listaGuardarropas.get(1).recomendarPrenda(brazalete, TipoRecomendacion.QUITAR);
    Assertions.assertEquals(listaGuardarropas.get(1).getRecomendacionesPrenda().size(), 1);
  }

  @Test
  public void enUnGuardarropasQueNoTieneNingunaPrendaTerminaConDosPrendasPorRecomendaciones() {
    guardarropas.recomendarPrenda(brazalete, TipoRecomendacion.AGREGAR);
    guardarropas.recomendarPrenda(remeraMangaLarga, TipoRecomendacion.AGREGAR);
    guardarropas.aceptarRecomendacion(guardarropas.getRecomendacionesPrenda().get(0));
    guardarropas.aceptarRecomendacion(guardarropas.getRecomendacionesPrenda().get(1));
    Assertions.assertEquals(guardarropas.getPrendas().size(), 2);
  }

  @Test
  public void enUnGuardarropasSeAceptanDosYSeRechazanDosRecomendaciones() {
    guardarropas.agregarPrendaAGuardarropas(pantalonDeVestir);
    guardarropas.agregarPrendaAGuardarropas(zapatillas);
    guardarropas.recomendarPrenda(remeraMangaLarga, TipoRecomendacion.AGREGAR);
    guardarropas.recomendarPrenda(brazalete, TipoRecomendacion.AGREGAR);
    guardarropas.recomendarPrenda(pantalonDeVestir, TipoRecomendacion.QUITAR);
    guardarropas.recomendarPrenda(zapatillas, TipoRecomendacion.QUITAR);
    Assertions.assertEquals(guardarropas.getRecomendacionesPrenda().size(), 4);
    guardarropas.aceptarRecomendacion(guardarropas.getRecomendacionesPrenda().get(0));
    guardarropas.rechazarRecomendacion(guardarropas.getRecomendacionesPrenda().get(1));
    guardarropas.aceptarRecomendacion(guardarropas.getRecomendacionesPrenda().get(1));
    guardarropas.rechazarRecomendacion(guardarropas.getRecomendacionesPrenda().get(2));
  }

  @Test
  public void noSePuedeAceptarRecomendacionesDeQuitarUnaPrendaSiDichaPrendaNoExisteEnElGuardarropas() {
    listaGuardarropas.get(0).recomendarPrenda(pantalonDeVestir, TipoRecomendacion.QUITAR);
    Assertions.assertThrows(NoExistePrendaEnGuardaRropasException.class,
        () -> guardarropas.aceptarRecomendacion(guardarropas.getRecomendacionesPrenda().get(0)));
  }

  @Test
  public void seDeshaceUnAgregadoDePrendaEnGuardarropa() {
    guardarropas.recomendarPrenda(remeraMangaLarga, TipoRecomendacion.AGREGAR);
    guardarropas.aceptarRecomendacion(guardarropas.getRecomendacionesPrenda().get(0));
    Assertions.assertEquals(guardarropas.getPrendas().size(), 1);
    guardarropas.deshacerRecomendacionAceptada(guardarropas.getRecomendacionesPrenda().get(0));
    Assertions.assertEquals(guardarropas.getPrendas().size(), 0);
  }

  @Test
  public void seDeshaceUnQuitadoDePrendaEnGuardarropa() {
    guardarropas.agregarPrendaAGuardarropas(remeraMangaLarga);
    Assertions.assertEquals(guardarropas.getPrendas().size(), 1);
    guardarropas.recomendarPrenda(remeraMangaLarga, TipoRecomendacion.QUITAR);
    guardarropas.aceptarRecomendacion(guardarropas.getRecomendacionesPrenda().get(0));
    Assertions.assertEquals(guardarropas.getPrendas().size(), 0);
  }

  @Test
  public void noSePuedeDeshacerUnaRecomendacionDeAgregadoQueNoHayaSidoAceptadaPreviamente() {
    guardarropas.recomendarPrenda(remeraMangaLarga, TipoRecomendacion.AGREGAR);
    Assertions.assertThrows(LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException.class,
        () -> guardarropas
            .deshacerRecomendacionAceptada(guardarropas.getRecomendacionesPrenda().get(0)));
  }

  @Test
  public void noSePuedeDeshacerUnaRecomendacionDeQuitadoQueNoHayaSidoAceptadaPreviamente() {
    guardarropas.recomendarPrenda(remeraMangaLarga, TipoRecomendacion.QUITAR);
    Assertions.assertThrows(LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException.class,
        () -> guardarropas
            .deshacerRecomendacionAceptada(guardarropas.getRecomendacionesPrenda().get(0)));
  }
}
