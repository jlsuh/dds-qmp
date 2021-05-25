package domain.prenda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import apisDelClima.StubServicioMeteorologicoAccuWeather;
import domain.material.TipoMaterial;
import domain.material.Trama;

public class GeneradorSugerenciasTest {

  String buenosAiresArgentina;
  StubServicioMeteorologicoAccuWeather stubServicioMeteorologicoAccuWeather;
  StubGeneradorSugerencias stubGeneradorSugerenciasAccuWeather;

  @BeforeEach
  public void inicializarContexto() {
    buenosAiresArgentina = "Buenos Aires, Argentina";
    stubServicioMeteorologicoAccuWeather = new StubServicioMeteorologicoAccuWeather();
    stubGeneradorSugerenciasAccuWeather =
        new StubGeneradorSugerencias(new StubServicioMeteorologicoAccuWeather());
  }

  @Test
  public void enBuenosAiresHacenTreceGradosCelsius() {
    Assertions.assertEquals(stubServicioMeteorologicoAccuWeather.getValorTemperaturaEnUnidades("C",
        buenosAiresArgentina), new BigDecimal(13));
  }

  @Test
  public void stubGeneradorDeSugerenciasFiltraPrendasParaBuenosAires() {
    List<Prenda> prendasNoFiltradas = new ArrayList<>();
    prendasNoFiltradas.add(new BorradorPrenda().configurarTipoPrenda(TipoPrenda.REMERAMANGALARGA)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, Trama.ACUADROS).crearPrenda());
    prendasNoFiltradas.add(new BorradorPrenda().configurarTipoPrenda(TipoPrenda.PANTALONDEVESTIR)
        .configurarMaterial("#000000", null, TipoMaterial.ALGODON, Trama.RAYADA).crearPrenda());
    prendasNoFiltradas.add(new BorradorPrenda().configurarTipoPrenda(TipoPrenda.CAMISA)
        .configurarMaterial("#000000", null, TipoMaterial.NYLON, Trama.ESTAMPADO).crearPrenda());
    Assertions.assertEquals(stubGeneradorSugerenciasAccuWeather
        .filtrarPrendasAcordeATemperatura(prendasNoFiltradas, buenosAiresArgentina).size(), 2);
  }

  @Test
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

    Assertions
        .assertTrue(stubGeneradorSugerenciasAccuWeather.generarSugerenciasDesde(prendasNoFiltradas)
            .get(0).getListadoPrenda().containsAll(prendasElectas));
  }
}
