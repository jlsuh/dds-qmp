package domain.suscripciones;

import java.util.List;
import service.NotificationService;

public class AlertaGranizo implements UltimaAlertaMeteorologicaSuscriber {

  @Override
  public void notificarAlertaMeteorologica(List<String> alertas,
      NotificationService notificationService) {
    if (alertas.contains("HAIL")) {
      notificationService.notify("¡Alerta granizo! Te recomendamos no viajar en auto :)");
    }
  }

  @Override
  public String sePronostica() {
    return "granizo";
  }

}
