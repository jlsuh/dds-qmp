package domain.prenda;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneradorSugerenciasTest {

  @Test // TODO: Empleado con Stub
  public void generadorDeSugerenciasPermiteConocerCondicionesClimaticasDeBuenosAires() {
    StubGeneradorSugerencias sgs = new StubGeneradorSugerencias();
    List<Map<String, Object>> condicionesClimaticasBsAs =
        sgs.getCondicionesClimaticasBuenosAires("Buenos Aires, Argentina");
    Assertions.assertEquals(condicionesClimaticasBsAs.get(0).get("Link"),
        "http://www.accuweather.com/en/ar/villa-vil/7984");
  }

}
