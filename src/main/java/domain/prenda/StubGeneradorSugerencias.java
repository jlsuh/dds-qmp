package domain.prenda;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.ServiciosDelClimaLocator;

public class StubGeneradorSugerencias implements GeneradorSugerencias {

  private ServiciosDelClimaLocator servicioClimaLocator;

  public StubGeneradorSugerencias(ServiciosDelClimaLocator servicioClimaLocator) {
    this.servicioClimaLocator = servicioClimaLocator;
  }

  @Override
  // TODO: Como usuarie de QuéMePongo, quiero poder recibir sugerencias de atuendos que tengan una
  // prenda para cada categoría, aunque a futuro podrán tener más (Ej.: Una remera, un pantalón,
  // zapatos y un gorro). Suponemos que este requerimiento está resuelto en este código.
  public List<Sugerencia> generarSugerenciasDesde(List<Prenda> prendasAptas) {
    List<Prenda> prendasFiltradas =
        this.filtrarPrendasAcordeATemperaturaCiudad(prendasAptas, "Buenos Aires, Argentina");
    List<Sugerencia> listaSugerencias = new LinkedList<>();
    listaSugerencias.add(new Sugerencia(prendasFiltradas.get(0), prendasFiltradas.get(1),
        prendasFiltradas.get(2), prendasFiltradas.get(3)));
    return listaSugerencias;
  }

  public List<Prenda> filtrarPrendasAcordeATemperaturaCiudad(List<Prenda> prendas, String ciudad) {
    String tipoUnidadCiudad = this.getTipoDetalleTemperaturaCiudad(ciudad, "Unit");
    Double valorTemperaturaCiudad =
        new Double(this.getTipoDetalleTemperaturaCiudad(ciudad, "Value"));
    return prendas.stream()
        .filter(prenda -> this.convertirTemperatura(tipoUnidadCiudad,
            prenda.getTipoPrenda().getTemperaturaAdecuadaEnCelsius()) <= valorTemperaturaCiudad)
        .collect(Collectors.toList());
  }

  public List<Map<String, Object>> getCondicionesClimaticasCiudad(String ciudad) {
    return servicioClimaLocator.getServicioDeClimaAccuWeather().getWeather(ciudad);
  }

  public Map<String, Object> getInformacionTemperaturaCiudad(String ciudad) {
    return (Map<String, Object>) this.getCondicionesClimaticasCiudad(ciudad).get(0)
        .get("Temperature");
  }

  public String getTipoDetalleTemperaturaCiudad(String ciudad, String detalle) {
    return this.getInformacionTemperaturaCiudad(ciudad).get(detalle).toString();
  }

  private Double convertirTemperatura(String tipoUnidades, Double temperaturaEnCelsius) {
    return tipoUnidades.equals("F") ? this.celsiusAFahrenheits(temperaturaEnCelsius)
        : temperaturaEnCelsius;
    // TODO: Acá suponemos que solamente habrá Fahrenheits o Celsius.
    // En caso de extender: considerar enumeraciones.
  }

  private Double celsiusAFahrenheits(Double temperatura) {
    return temperatura * 1.8 + 32;
  }

}
