package domain.suscripciones;

import java.util.List;
import service.NotificationService;

public class AlertaTormenta implements UltimaAlertaMeteorologicaSuscriber {

  @Override
  public void notificarAlertaMeteorologica(List<String> alertas,
      NotificationService notificationService) {
    if (alertas.contains("STORM")) {
      notificationService.notify("¡Alerta tormenta! Te recomendamos tener un paraguas a mano :)");
    }
  }

  @Override
  public String sePronostica() {
    return "tormentas";
  }

}
