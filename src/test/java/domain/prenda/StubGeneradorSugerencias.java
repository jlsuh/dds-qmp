package domain.prenda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import apisDelClima.ServicioMeteorologico;

public class StubGeneradorSugerencias implements GeneradorSugerencias {

  private ServicioMeteorologico servicioMeteorologico;

  public StubGeneradorSugerencias(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  @Override
  public List<Atuendo> generarSugerenciasDesde(List<Prenda> prendasAptas) {
    List<Prenda> prendasFiltradas =
        this.filtrarPrendasAcordeATemperatura(prendasAptas, "Buenos Aires, Argentina");
    List<Atuendo> listaSugerencias = new ArrayList<>();
    listaSugerencias.add(new Atuendo(prendasFiltradas.get(0), prendasFiltradas.get(1),
        prendasFiltradas.get(2), prendasFiltradas.get(3)));
    return listaSugerencias;
  }

  public List<Prenda> filtrarPrendasAcordeATemperatura(List<Prenda> prendas, String ciudad) {
    BigDecimal valorTemperaturaCiudadEnCelsius =
        servicioMeteorologico.getValorTemperaturaEnUnidades("C", ciudad);
    return prendas.stream()
        .filter(prenda -> prenda.esAdecuadoParaElClima(valorTemperaturaCiudadEnCelsius))
        .collect(Collectors.toList());
  }
}
