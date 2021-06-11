package apisDelClima;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

  protected String getValorTemperatura(String ciudad) {
    return String.valueOf(this.getTemperatura(ciudad).get("Value"));
  }

  protected Map<String, Object> getTemperatura(String ciudad) {
    return (Map<String, Object>) this.getCondicionesClimaticas(ciudad).get("Temperature");
  }

  protected BigDecimal convertirTemperatura(String tipoUnidades, BigDecimal valor) {
    return tipoUnidades.equals("F") ? this.celsiusAFahrenheits(valor) : fahrenheitsACelsius(valor);
  }

  protected BigDecimal fahrenheitsACelsius(BigDecimal temperatura) {
    return (temperatura.subtract(new BigDecimal(32))).divide(BigDecimal.valueOf(1.8));
  }

  protected BigDecimal celsiusAFahrenheits(BigDecimal temperatura) {
    return (temperatura.multiply(BigDecimal.valueOf(1.8)).add(new BigDecimal(32)));
  }

  public final Map<String, List<String>> getAlerts(String ciudad) {
    HashMap<String, List<String>> currentAlerts = new HashMap<String, List<String>>();
    List<String> types = new ArrayList<>();
    types.add("STORM");
    types.add("HAIL");
    currentAlerts.put("CurrentAlerts", types);
    return currentAlerts;
  }
}
