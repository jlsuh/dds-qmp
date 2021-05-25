package apisDelClima;

import java.math.BigDecimal;

public class StubServicioMeteorologicoAccuWeather extends ServicioMeteorologicoAccuWeather {

  private final BigDecimal TEMP_FAHR = new BigDecimal(57);
  private final BigDecimal TEMP_CELS = new BigDecimal(13);

  @Override
  public BigDecimal getValorTemperaturaEnUnidades(String unidad, String ciudad) {
    if (unidad == "C") {
      return TEMP_CELS; // En grados celsius
    } else {
      return TEMP_FAHR; // En grados fahrenheits
    }
  }
}
