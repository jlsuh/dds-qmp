package domain.publishers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import apisDelClima.StubServicioMeteorologicoAccuWeather;
import domain.guardarropa.CriterioGuardarropa;
import domain.guardarropa.Guardarropas;
import domain.material.TipoMaterial;
import domain.material.Trama;
import domain.prenda.BorradorPrenda;
import domain.prenda.Prenda;
import domain.prenda.StubGeneradorSugerencias;
import domain.prenda.TipoPrenda;
import domain.suscripciones.AlertaGranizo;
import domain.suscripciones.AlertaMeteorologicaMailSuscriber;
import domain.suscripciones.AlertaTormenta;
import domain.suscripciones.UltimaAlertaMeteorologicaSuscriber;
import domain.usuario.Usuario;
import service.MailSender;
import service.NotificationService;
import static org.mockito.Mockito.*;

public class SugerenciaDiariaPublisherTest {

  private SugerenciaDiariaPublisher sugerenciaDiariaPublisher;

  private StubGeneradorSugerencias generadorSugerencias;

  private StubServicioMeteorologicoAccuWeather accuWeatherAPI;

  private Usuario suscriptor1;
  private Usuario suscriptor2;

  private Guardarropas guardarropas1;
  private Guardarropas guardarropas2;

  private List<Guardarropas> listaGuardarropasUsuario1;
  private List<Guardarropas> listaGuardarropasUsuario2;

  private Prenda remeraMangaLarga;
  private Prenda camisa;
  private Prenda pantalonDeVestir;
  private Prenda zapatilla;
  private Prenda brazalete;
  private Prenda zapato;

  @BeforeEach
  public void fixture() {

    // Prendas
    remeraMangaLarga = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.REMERAMANGALARGA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, Trama.ACUADROS).crearPrenda();
    camisa = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.NYLON, Trama.ESTAMPADO).crearPrenda();
    pantalonDeVestir = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.PANTALONDEVESTIR)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, Trama.RAYADA).crearPrenda();
    zapatilla = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.ZAPATILLA)
        .configurarMaterial("#000000", null, TipoMaterial.CAUCHO, null).crearPrenda();
    brazalete = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.BRAZALETE)
        .configurarMaterial("#000000", null, TipoMaterial.PLASTICO, null).crearPrenda();
    zapato = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.ZAPATO)
        .configurarMaterial("#000000", null, TipoMaterial.CUERO, null).crearPrenda();

    // APIs del clima
    accuWeatherAPI = new StubServicioMeteorologicoAccuWeather();

    // Generador sugerencias
    generadorSugerencias = new StubGeneradorSugerencias(accuWeatherAPI);

    // Sugerencia diaria publisher
    sugerenciaDiariaPublisher = new SugerenciaDiariaPublisher(generadorSugerencias);

    // Guardarropas
    guardarropas1 = new Guardarropas(CriterioGuardarropa.VIAJE);
    guardarropas2 = new Guardarropas(CriterioGuardarropa.ENTRECASA);

    // Inicialización listas
    listaGuardarropasUsuario1 = new ArrayList<>();
    listaGuardarropasUsuario2 = new ArrayList<>();

    // List de guardarropas
    listaGuardarropasUsuario1.add(guardarropas1);
    listaGuardarropasUsuario2.add(guardarropas2);
  }

  // TODO: Req. 1 y 2. Esperar puesta en común
  /*
   * @Test public void sePuedeDispararElCalculoDeSugerenciasDiariasParaUsuarios() { Guardarropas
   * guardarropasUno = new Guardarropas(CriterioGuardarropa.ENTRECASA);
   * guardarropasUno.agregarPrendaAGuardarropas(remeraMangaLarga);
   * guardarropasUno.agregarPrendaAGuardarropas(camisa);
   * guardarropasUno.agregarPrendaAGuardarropas(pantalonDeVestir);
   * guardarropasUno.agregarPrendaAGuardarropas(zapatilla);
   * guardarropasUno.agregarPrendaAGuardarropas(brazalete);
   * guardarropasUno.agregarPrendaAGuardarropas(zapato);
   * System.out.println(guardarropasUno.getPrendas().size());
   * 
   * Guardarropas guardarropasDos = new Guardarropas(CriterioGuardarropa.ENTRECASA);
   * guardarropasDos.agregarPrendaAGuardarropas(remeraMangaLarga);
   * guardarropasDos.agregarPrendaAGuardarropas(camisa);
   * guardarropasDos.agregarPrendaAGuardarropas(pantalonDeVestir);
   * guardarropasDos.agregarPrendaAGuardarropas(zapatilla);
   * guardarropasDos.agregarPrendaAGuardarropas(brazalete);
   * guardarropasDos.agregarPrendaAGuardarropas(zapato);
   * System.out.println(guardarropasDos.getPrendas().size());
   * 
   * Atuendo atuendo = new Atuendo(camisa, pantalonDeVestir, zapatilla, brazalete);
   * 
   * List<Guardarropas> listaGuardarropas1 = new ArrayList<>(); List<Guardarropas>
   * listaGuardarropas2 = new ArrayList<>();
   * 
   * listaGuardarropas1.add(guardarropas1); System.out.println(listaGuardarropas1.size());
   * listaGuardarropas2.add(guardarropas2); System.out.println(listaGuardarropas2.size());
   * 
   * Usuario usuario1 = new Usuario(listaGuardarropas1); Usuario usuario2 = new
   * Usuario(listaGuardarropas2);
   * 
   * SugerenciaDiariaPublisher sdp = new SugerenciaDiariaPublisher(generadorSugerencias);
   * 
   * sdp.suscribirASugerenciaDiaria(usuario1); sdp.suscribirASugerenciaDiaria(usuario2);
   * System.out.println(sugerenciaDiariaPublisher.getSuscriptores().size());
   * 
   * sdp.actualizarSugerenciaDiaria();
   * 
   * Assertions.assertEquals(usuario1.getSugerenciaDiaria(), atuendo);
   * Assertions.assertEquals(usuario2.getSugerenciaDiaria(), atuendo);
   * 
   * }
   */

  @Test
  public void sePuedenConocerLasUltimasAlertasMeteorologicas() {
    List<UltimaAlertaMeteorologicaSuscriber> suscriptores =
        Arrays.asList(new AlertaTormenta(), new AlertaGranizo());

    NotificationService ns = mock(NotificationService.class);
    MailSender ms = mock(MailSender.class);
    List<AlertaMeteorologicaMailSuscriber> listaAlertaMeteorologicaMailSuscribers =
        new ArrayList<>();

    UltimaAlertaMeteorologicaPublisher am =
        new UltimaAlertaMeteorologicaPublisher(new StubServicioMeteorologicoAccuWeather(), ns, ms,
            suscriptores, listaAlertaMeteorologicaMailSuscribers);
    am.actualizarAlertaMeteorologica("Buenos Aires");
    List<String> alertasMeteorologicas = am.getUltimasAlertasMeteorologicas();
    Assertions.assertEquals(alertasMeteorologicas.get(0), "STORM");
    Assertions.assertEquals(alertasMeteorologicas.get(1), "HAIL");
  }

  // TODO: Esperar puesta en común. Como usuarie de QuéMePongo quiero que se actualice mi sugerencia
  // diaria con las condiciones climáticas actualizadas cuando se genere algún alerta durante el
  // día.

  @Test
  public void alRecibirUnaAlertaDeTormentaSeNotificaQueSeLleveParaguas() {

    List<UltimaAlertaMeteorologicaSuscriber> listaSuscriptores = new ArrayList<>();
    List<AlertaMeteorologicaMailSuscriber> listaAlertaMeteorologicaMailSuscribers =
        new ArrayList<>();
    NotificationService ns = mock(NotificationService.class);
    MailSender ms = mock(MailSender.class);

    UltimaAlertaMeteorologicaPublisher am =
        mock(new UltimaAlertaMeteorologicaPublisher(new StubServicioMeteorologicoAccuWeather(), ns,
            ms, listaSuscriptores, listaAlertaMeteorologicaMailSuscribers).getClass());

    when(am.getUltimasAlertasMeteorologicas()).thenReturn(Arrays.asList("STORM"));

    am.actualizarAlertaMeteorologica("Buenos Aires");
    List<String> alertasMeteorologicas = am.getUltimasAlertasMeteorologicas();
    Assertions.assertEquals(alertasMeteorologicas.get(0), "STORM");
  }

  @Test
  public void alRecibirUnaAlertaDeGranizoSeNotificaQueNoSalgaEnAuto() {

    List<UltimaAlertaMeteorologicaSuscriber> listaSuscriptores = new ArrayList<>();
    List<AlertaMeteorologicaMailSuscriber> listaAlertaMeteorologicaMailSuscribers =
        new ArrayList<>();
    NotificationService ns = mock(NotificationService.class);
    MailSender ms = mock(MailSender.class);

    UltimaAlertaMeteorologicaPublisher am =
        mock(new UltimaAlertaMeteorologicaPublisher(new StubServicioMeteorologicoAccuWeather(), ns,
            ms, listaSuscriptores, listaAlertaMeteorologicaMailSuscribers).getClass());

    when(am.getUltimasAlertasMeteorologicas()).thenReturn(Arrays.asList("HAIL"));

    am.actualizarAlertaMeteorologica("Buenos Aires");
    List<String> alertasMeteorologicas = am.getUltimasAlertasMeteorologicas();
    Assertions.assertEquals(alertasMeteorologicas.get(0), "HAIL");
  }

  @Test
  public void sePuedeRecibirUnMailDeUnaNuevaAlertaMeteorologica() {
    Usuario user = new Usuario(listaGuardarropasUsuario1, "example@gmail.com");
    NotificationService ns = mock(NotificationService.class);
    MailSender ms = mock(MailSender.class);

    List<UltimaAlertaMeteorologicaSuscriber> listaSuscriptores =
        Arrays.asList(new AlertaTormenta());
    List<AlertaMeteorologicaMailSuscriber> amsus = Arrays.asList(user);

    UltimaAlertaMeteorologicaPublisher uams = new UltimaAlertaMeteorologicaPublisher(
        new StubServicioMeteorologicoAccuWeather(), ns, ms, listaSuscriptores, amsus);

    uams.actualizarAlertaMeteorologica("Buenos Aires");
    verify(ms, times(1)).send("example@gmail.com", "Alerta meteorológico");
  }

  // TODO: Como usuarie de QuéMePongo quiero poder configurar cuáles de estas acciones
  // (notificaciones, mail, recálculo) quiero que se ejecuten y cuáles no, además de soportar nuevas
  // acciones a futuro. (No nos interesará, sin embargo, soportar nuevas alertas). Esperar a puesta
  // en común.
}
