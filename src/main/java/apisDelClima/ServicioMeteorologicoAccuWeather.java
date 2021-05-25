package apisDelClima;

import java.math.BigDecimal;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {
  // AccuWeather Adapter
  AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI();

  @Override
  public Map<String, Object> getCondicionesClimaticas(String ciudadPais) {
    return this.accuWeatherAPI.getWeather(ciudadPais).get(0);
  }

  @Override
  public BigDecimal getValorTemperaturaEnUnidades(String unidad, String ciudad) {
    return this.convertirTemperatura(unidad, new BigDecimal(this.getValorTemperatura(ciudad)));
  }

  private String getValorTemperatura(String ciudad) {
    return String.valueOf(this.getTemperatura(ciudad).get("Value"));
  }
  
  private Map<String, Object> getTemperatura(String ciudad) {
    return (Map<String, Object>) this.getCondicionesClimaticas(ciudad).get("Temperature");
  }

  private BigDecimal convertirTemperatura(String tipoUnidades, BigDecimal valor) {
    return tipoUnidades.equals("F") ? this.celsiusAFahrenheits(valor) : fahrenheitsACelsius(valor);
  }

  private BigDecimal fahrenheitsACelsius(BigDecimal temperatura) {
    return (temperatura.subtract(new BigDecimal(32))).divide(new BigDecimal(1.8));
  }

  private BigDecimal celsiusAFahrenheits(BigDecimal temperatura) {
    return temperatura.multiply(new BigDecimal(1.8)).add(new BigDecimal(32));
  }
}
