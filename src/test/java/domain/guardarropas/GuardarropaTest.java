package domain.guardarropas;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.guardarropa.AgregarPrenda;
import domain.guardarropa.CriterioGuardarropa;
import domain.guardarropa.Guardarropas;
import domain.guardarropa.QuitarPrenda;
import domain.guardarropa.RecomendacionPrenda;
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

  private RecomendacionPrenda recomendacionAgregarBrazalete;
  private RecomendacionPrenda recomendacionAgregarZapatillas;
  private RecomendacionPrenda recomendacionAgregarRemeraMangaLarga;

  private RecomendacionPrenda recomendacionQuitarPantalonDeVestir;
  private RecomendacionPrenda recomendacionQuitarBrazalete;
  private RecomendacionPrenda recomendacionQuitarZapatillas;
  private RecomendacionPrenda recomendacionQuitarRemeraMangaLarga;

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

    // Recomendaciones
    recomendacionAgregarBrazalete = new AgregarPrenda(brazalete);
    recomendacionAgregarZapatillas = new AgregarPrenda(zapatillas);
    recomendacionAgregarRemeraMangaLarga = new AgregarPrenda(remeraMangaLarga);

    recomendacionQuitarPantalonDeVestir = new QuitarPrenda(pantalonDeVestir);
    recomendacionQuitarBrazalete = new QuitarPrenda(brazalete);
    recomendacionQuitarZapatillas = new QuitarPrenda(zapatillas);
    recomendacionQuitarRemeraMangaLarga = new QuitarPrenda(remeraMangaLarga);

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
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionAgregarZapatillas);
    Assertions
        .assertEquals(usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().size(), 1);
  }

  @Test
  public void seProponeTentativamenteAgregarUnaPrendaAlGuardarropasPrivado() {
    usuario1.getGuardarropasEnIndice(1).recomendarPrenda(recomendacionAgregarRemeraMangaLarga);
    Assertions
        .assertEquals(usuario1.getGuardarropasEnIndice(1).getRecomendacionesPendientes().size(), 1);
  }

  @Test
  public void seProponeTentativamenteQuitarUnaPrendaDelGuardarropasPublico() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionQuitarPantalonDeVestir);
    Assertions
        .assertEquals(usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().size(), 1);
  }

  @Test
  public void seProponeTentativamenteQuitarUnaPrendaDelGuardarropasPrivado() {
    usuario1.getGuardarropasEnIndice(1).recomendarPrenda(recomendacionQuitarBrazalete);
    Assertions
        .assertEquals(usuario1.getGuardarropasEnIndice(1).getRecomendacionesPendientes().size(), 1);
  }

  @Test
  public void enUnGuardarropasQueNoTieneNingunaPrendaTerminaConDosPrendasPorRecomendaciones() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionAgregarBrazalete);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionAgregarRemeraMangaLarga);
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().get(0));
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().get(0));
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 2);
  }

  @Test
  public void enUnGuardarropasSeAceptanDosYSeRechazanDosRecomendaciones() {
    usuario1.getGuardarropasEnIndice(0).agregarPrendaAGuardarropas(pantalonDeVestir);
    usuario1.getGuardarropasEnIndice(0).agregarPrendaAGuardarropas(zapatillas);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionAgregarRemeraMangaLarga);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionAgregarBrazalete);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionQuitarPantalonDeVestir);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionQuitarZapatillas);
    Assertions
        .assertEquals(usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().size(), 4);
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().get(0));
    usuario1.getGuardarropasEnIndice(0).quitarRecomendacionDePendientes(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().get(0));
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().get(0));
    usuario1.getGuardarropasEnIndice(0).quitarRecomendacionDePendientes(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().get(0));
    Assertions
        .assertEquals(usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().size(), 0);
    Assertions
        .assertEquals(usuario1.getGuardarropasEnIndice(0).getRecomendacionesAceptadas().size(), 2);
  }

  @Test
  public void seDeshaceUnAgregadoDePrendaEnGuardarropa() {
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionAgregarRemeraMangaLarga);
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().get(0));
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 1);
    usuario1.getGuardarropasEnIndice(0).deshacerRecomendacionAceptada(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesAceptadas().get(0));
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 0);
  }

  @Test
  public void seDeshaceUnQuitadoDePrendaEnGuardarropa() {
    usuario1.getGuardarropasEnIndice(0).agregarPrendaAGuardarropas(remeraMangaLarga);
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 1);
    usuario1.getGuardarropasEnIndice(0).recomendarPrenda(recomendacionQuitarRemeraMangaLarga);
    usuario1.getGuardarropasEnIndice(0).aceptarRecomendacion(
        usuario1.getGuardarropasEnIndice(0).getRecomendacionesPendientes().get(0));
    Assertions.assertEquals(usuario1.getGuardarropasEnIndice(0).getPrendas().size(), 0);
  }

}
