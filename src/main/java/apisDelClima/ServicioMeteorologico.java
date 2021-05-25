package apisDelClima;

import java.math.BigDecimal;
import java.util.Map;

public interface ServicioMeteorologico {

  public Map<String, Object> getCondicionesClimaticas(String ciudadPais);

  public BigDecimal getValorTemperaturaEnUnidades(String unidad, String ciudad);

}
