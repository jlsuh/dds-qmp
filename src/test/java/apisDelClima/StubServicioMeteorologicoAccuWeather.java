package apisDelClima;

import java.math.BigDecimal;

public class StubServicioMeteorologicoAccuWeather extends ServicioMeteorologicoAccuWeather {

  @Override
  public BigDecimal getValorTemperaturaEnUnidades(String unidad, String ciudad) {
    return new BigDecimal(13); // En grados celsius
  }

}
