package domain.prenda;

import java.util.List;
import java.util.Map;
import service.AccuWeatherAPI;

public class StubGeneradorSugerencias implements GeneradorSugerencias {

  @Override
  public List<Sugerencia> generarSugerenciasDesde(List<Prenda> prendasAptas) {
    return null;
  }

  public List<Map<String, Object>> getCondicionesClimaticasBuenosAires(String ciudad) {
    return new AccuWeatherAPI().getWeather(ciudad);
  }

}
