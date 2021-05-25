package domain.prenda;

import java.util.List;

public interface GeneradorSugerencias {

  public List<Atuendo> generarSugerenciasDesde(List<Prenda> prendasAptas);

}
