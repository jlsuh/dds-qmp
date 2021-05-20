package domain.prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.material.TipoMaterial;
import domain.material.Trama;
import service.ServiciosDelClimaLocator;

public class StubGeneradorSugerenciasTest {

  StubGeneradorSugerencias sgs;
  String buenosAiresArgentina;

  @BeforeEach
  public void inicializarContexto() {
    sgs = new StubGeneradorSugerencias(new ServiciosDelClimaLocator());
    buenosAiresArgentina = "Buenos Aires, Argentina";
  }

  @Test // TODO: Empleado con Stub
  public void generadorDeSugerenciasPermiteConocerCondicionesClimaticasDeBuenosAires() {
    List<Map<String, Object>> condicionesClimaticasBsAs =
        sgs.getCondicionesClimaticasCiudad(buenosAiresArgentina);
    Assertions.assertEquals(condicionesClimaticasBsAs.get(0).get("Link"),
        "http://www.accuweather.com/en/ar/villa-vil/7984");
  } // TODO: Los tests afectan al requerimiento 5? Muy probablemente se deba emplear un stub?

  @Test
  public void enBuenosAiresHacenCincuentaYSieteGradosFahrenheit() {
    Assertions.assertEquals(sgs.getTipoDetalleTemperaturaCiudad(buenosAiresArgentina, "Value"),
        "57");
  }

  @Test
  public void generadorDeSugerenciasFiltraPrendasParaBuenosAires() {
    List<Prenda> prendasNoFiltradas = new ArrayList<>();
    prendasNoFiltradas.add(new BorradorPrenda().configurarTipoPrenda(TipoPrenda.REMERAMANGALARGA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, Trama.ACUADROS).crearPrenda());
    prendasNoFiltradas.add(new BorradorPrenda().configurarTipoPrenda(TipoPrenda.PANTALONDEVESTIR)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, Trama.RAYADA).crearPrenda());
    prendasNoFiltradas.add(new BorradorPrenda().configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.NYLON, Trama.ESTAMPADO).crearPrenda());
    Assertions.assertEquals(
        sgs.filtrarPrendasAcordeATemperaturaCiudad(prendasNoFiltradas, buenosAiresArgentina).size(),
        2);
  }

  @Test // TODO: Stub reloaded
  public void generadorDeSugerenciasDaSugerenciasParaBuenosAires() {
    List<Prenda> prendasNoFiltradas = new ArrayList<>();
    Prenda remeraMangaLarga = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.REMERAMANGALARGA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, Trama.ACUADROS).crearPrenda();
    Prenda camisa = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.NYLON, Trama.ESTAMPADO).crearPrenda();
    Prenda pantalonDeVestir = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.PANTALONDEVESTIR)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, Trama.RAYADA).crearPrenda();
    Prenda zapatilla = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.ZAPATILLA)
        .configurarMaterial("#000000", null, TipoMaterial.CAUCHO, null).crearPrenda();
    Prenda brazalete = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.BRAZALETE)
        .configurarMaterial("#000000", null, TipoMaterial.PLASTICO, null).crearPrenda();
    Prenda zapato = new BorradorPrenda().configurarTipoPrenda(TipoPrenda.ZAPATO)
        .configurarMaterial("#000000", null, TipoMaterial.CUERO, null).crearPrenda();
    prendasNoFiltradas.add(remeraMangaLarga);
    prendasNoFiltradas.add(camisa);
    prendasNoFiltradas.add(pantalonDeVestir);
    prendasNoFiltradas.add(zapatilla);
    prendasNoFiltradas.add(brazalete);
    prendasNoFiltradas.add(zapato);

    List<Prenda> prendasElectas = new ArrayList<>();
    prendasElectas.add(camisa);
    prendasElectas.add(pantalonDeVestir);
    prendasElectas.add(zapatilla);
    prendasElectas.add(brazalete);

    Assertions.assertTrue(sgs.generarSugerenciasDesde(prendasNoFiltradas).get(0).getListadoPrenda()
        .containsAll(prendasElectas));
  }

  /*
   * @Test public void algo() { ServiciosDelClimaLocator sdcl = new ServiciosDelClimaLocator();
   * System.out.println(sdcl.getTipoDelServicioDelClima(new AccuWeatherAPI())); }
   */

  /*
   * Funcan
   * 
   * @Test public void conversion() { Assertions.assertEquals(sgs.convertirTemperatura("F", 52.0),
   * 125.6); }
   * 
   * @Test public void noConversion() { Assertions.assertEquals(sgs.convertirTemperatura("C", 52.0),
   * 52.0); }
   */
}
