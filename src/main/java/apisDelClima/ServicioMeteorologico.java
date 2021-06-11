package apisDelClima;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ServicioMeteorologico {

  public Map<String, Object> getCondicionesClimaticas(String ciudadPais);

  public Map<String, List<String>> getAlerts(String ciudad);

  public BigDecimal getValorTemperaturaEnUnidades(String unidad, String ciudad);

}
