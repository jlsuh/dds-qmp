package domain.prenda;

import java.util.List;

public interface GeneradorSugerencias {

  public List<Sugerencia> generarSugerenciasDesde(List<Prenda> prendasAptas);

}
