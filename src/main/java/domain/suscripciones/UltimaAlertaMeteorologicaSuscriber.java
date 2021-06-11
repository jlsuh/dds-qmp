package domain.suscripciones;

import java.util.List;
import service.NotificationService;

public interface UltimaAlertaMeteorologicaSuscriber {

  public void notificarAlertaMeteorologica(List<String> alertas, NotificationService notificationService);
  
  public String sePronostica();

}
