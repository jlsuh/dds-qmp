package domain.guardarropas;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.exceptions.LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException;
import domain.exceptions.NoExistePrendaEnGuardarropasException;
import domain.guardarropa.CriterioGuardarropa;
import domain.guardarropa.Guardarropas;
import domain.guardarropa.TipoRecomendacion;
import domain.material.TipoMaterial;
import domain.material.Trama;
import domain.prenda.Prenda;
import domain.prenda.TipoPrenda;
import domain.usuario.Usuario;

public class GuardarropaTest {

  private Guardarropas guardarropas1;
  private Guardarropas guardarropas2;
  private Guardarropas guardarropasCompartible;

  private List<Guardarropas> listaGuardarropasUsuario1;
  private List<Guardarropas> listaGuardarropasUsuario2;

  private Prenda pantalonDeVestir;
  private Prenda brazalete;
  private Prenda zapatillas;
  private Prenda remeraMangaLarga;

  private Usuario usuario1;
  private Usuario usuario2;

  @BeforeEach
  public void fixture() {

    // Prendas
    pantalonDeVestir =
        new Prenda(TipoPrenda.PANTALONDEVESTIR, TipoMaterial.ALGODON, null, "#000000", "#5745f3");
    brazalete =
        new Prenda(TipoPrenda.BRAZALETE, TipoMaterial.PLASTICO, Trama.ACUADROS, "#fa32b2", null);
    zapatillas = new Prenda(TipoPrenda.ZAPATILLA, TipoMaterial.CAUCHO, null, "#ffffff", "#0982af");
    remeraMangaLarga = new Prenda(TipoPrenda.REMERAMANGALARGA, TipoMaterial.ALGODON,
        Trama.ESTAMPADO, "#000000", "#fab023");

    // Guardarropas
    guardarropas1 = new Guardarropas(CriterioGuardarropa.ENTRECASA);
    guardarropas2 = new Guardarropas(CriterioGuardarropa.VIAJE);
    guardarropasCompartible = new Guardarropas(CriterioGuardarropa.VIAJE);

    // Lista de Guardarropas
    listaGuardarropasUsuario1 = new ArrayList<>();
    listaGuardarropasUsuario2 = new ArrayList<>();

    // Agregando guardarropas a listas de guardarropas
    listaGuardarropasUsuario1.add(guardarropas1);
    listaGuardarropasUsuario1.add(guardarropas2);

    // Instanciación de usuario
    usuario1 = new Usuario(listaGuardarropasUsuario1);
    usuario2 = new Usuario(listaGuardarropasUsuario2);
  }

  @Test
  public void unGuardarropasPublicoPoseeCriterioEntreCasa() {
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getCriterioGuardarropa(),
        CriterioGuardarropa.ENTRECASA);
  }

  @Test
  public void unGuardarropasPublicoPoseeCriterioViaje() {
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(1).getCriterioGuardarropa(),
        CriterioGuardarropa.VIAJE);
  }

  @Test
  public void sePuedeManejarVariasGuardarropasALaVez() {
    usuario1.getGuardarropasEnIndice(0).agregarPrendaAGuardarropas(pantalonDeVestir);
    usuario1.getGuardarropasEnIndice(1).agregarPrendaAGuardarropas(brazalete);
    Assertions.assertEquals(
        usuario1.getGuardarropas().stream().map(g -> g.getPrendas().size()).count(), 2);
  }

  @Test
  public void sePuedenAgregarYQuitarPrendasDeUnGuardarropas() {
    usuario1.getGuardarropasEnIndice(1).agregarPrendaAGuardarropas(pantalonDeVestir);
    usuario1.getGuardarropasEnIndice(1).agregarPrendaAGuardarropas(brazalete);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(1).getPrendas().size(), 2);
    usuario1.getGuardarropasEnIndice(1).quitarPrendaDeGuardarropas(brazalete);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(1).getPrendas().size(), 1);
  }

  @Test
  public void sePuedeCompartirGuardarropas() {
    guardarropasCompartible.agregarPrendaAGuardarropas(brazalete);
    guardarropasCompartible.agregarPrendaAGuardarropas(pantalonDeVestir);
    usuario1.agregarGuardarropas(guardarropasCompartible);
    usuario2.agregarGuardarropas(guardarropasCompartible);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(2),
        usuario2.getGuardarropasEnIndice(0));
  }

  @Test
  public void seProponeTentativamenteAgregarUnaPrendaAlGuardarropasPublico() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(zapatillas, TipoRecomendacion.AGREGAR);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().size(),
        1);
  }

  @Test
  public void seProponeTentativamenteAgregarUnaPrendaAlGuardarropasPrivado() {
    usuario1.getGuardarropasEnIndice(1).recomendarPrenda(remeraMangaLarga,
        TipoRecomendacion.AGREGAR);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(1).getRecomendacionesPrenda().size(),
        1);
  }

  @Test
  public void seProponeTentativamenteQuitarUnaPrendaDelGuardarropasPublico() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(pantalonDeVestir,
        TipoRecomendacion.QUITAR);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().size(),
        1);
  }

  @Test
  public void seProponeTentativamenteQuitarUnaPrendaDelGuardarropasPrivado() {
    usuario1.getGuardarropasEnIndice(1).recomendarPrenda(brazalete, TipoRecomendacion.QUITAR);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(1).getRecomendacionesPrenda().size(),
        1);
  }

  @Test
  public void enUnGuardarropasQueNoTieneNingunaPrendaTerminaConDosPrendasPorRecomendaciones() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(brazalete, TipoRecomendacion.AGREGAR);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(remeraMangaLarga,
        TipoRecomendacion.AGREGAR);
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(0));
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(1));
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 2);
  }

  @Test
  public void enUnGuardarropasSeAceptanDosYSeRechazanDosRecomendaciones() {
    usuario1.getGuardarropasEnIndice(0).agregarPrendaAGuardarropas(pantalonDeVestir);
    usuario1.getGuardarropasEnIndice(0).agregarPrendaAGuardarropas(zapatillas);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(remeraMangaLarga,
        TipoRecomendacion.AGREGAR);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(brazalete, TipoRecomendacion.AGREGAR);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(pantalonDeVestir,
        TipoRecomendacion.QUITAR);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(zapatillas, TipoRecomendacion.QUITAR);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().size(),
        4);
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(0));
    usuario1.getGuardarropasEnIndice(0).rechazarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(1));
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(1));
    usuario1.getGuardarropasEnIndice(0).rechazarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(2));
  }

  @Test
  public void noSePuedeAceptarRecomendacionesDeQuitarUnaPrendaSiDichaPrendaNoExisteEnElGuardarropas() {
    listaGuardarropasUsuario1.get(0).recomendarPrenda(pantalonDeVestir, TipoRecomendacion.QUITAR);
    Assertions.assertThrows(NoExistePrendaEnGuardarropasException.class,
        () -> usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
            usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(0)));
  }

  @Test
  public void seDeshaceUnAgregadoDePrendaEnGuardarropa() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(remeraMangaLarga,
        TipoRecomendacion.AGREGAR);
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(0));
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 1);
    usuario1.getGuardarropasEnIndice(0).deshacerRecomendacionAceptada(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(0));
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 0);
  }

  @Test
  public void seDeshaceUnQuitadoDePrendaEnGuardarropa() {
    usuario1.getGuardarropasEnIndice(0).agregarPrendaAGuardarropas(remeraMangaLarga);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 1);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(remeraMangaLarga,
        TipoRecomendacion.QUITAR);
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(0));
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 0);
  }

  @Test
  public void noSePuedeDeshacerUnaRecomendacionDeAgregadoQueNoHayaSidoAceptadaPreviamente() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(remeraMangaLarga,
        TipoRecomendacion.AGREGAR);
    Assertions.assertThrows(LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException.class,
        () -> usuario1.getGuardarropasEnIndice(0).deshacerRecomendacionAceptada(
            usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(0)));
  }

  @Test
  public void noSePuedeDeshacerUnaRecomendacionDeQuitadoQueNoHayaSidoAceptadaPreviamente() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(remeraMangaLarga,
        TipoRecomendacion.QUITAR);
    Assertions.assertThrows(LaRecomendacionNoEsUnaRecomendacionAceptadaPreviamenteException.class,
        () -> usuario1.getGuardarropasEnIndice(0).deshacerRecomendacionAceptada(
            usuario1.getGuardarropasEnIndice(0).getRecomendacionesPrenda().get(0)));
  }
}
