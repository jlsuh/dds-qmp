package domain.publishers;

import java.time.LocalDate;
import java.util.List;
import apisDelClima.ServicioMeteorologico;
import domain.alertaMeteorologica.DatosAlertaMeteorologica;
import domain.suscripciones.AlertaMeteorologicaMailSuscriber;
import domain.suscripciones.UltimaAlertaMeteorologicaSuscriber;
import service.MailSender;
import service.NotificationService;

public class UltimaAlertaMeteorologicaPublisher {

  private ServicioMeteorologico servicioMeteorologico;
  private DatosAlertaMeteorologica datosAlertaMeteorologica;
  private List<String> ultimasAlertasMeteorologicas;
  private NotificationService notificationService;
  private MailSender mailSender;
  private List<UltimaAlertaMeteorologicaSuscriber> ultimaAlertaMeteorologicaSuscribers;
  private List<AlertaMeteorologicaMailSuscriber> alertaMeteorologicaMailSuscribers;

  public UltimaAlertaMeteorologicaPublisher(ServicioMeteorologico servicioMeteorologico,
      NotificationService notificationService, MailSender mailSender,
      List<UltimaAlertaMeteorologicaSuscriber> listaSuscriptores,
      List<AlertaMeteorologicaMailSuscriber> alertaMeteorologicaMailSuscribers) {
    this.servicioMeteorologico = servicioMeteorologico;
    this.notificationService = notificationService;
    this.mailSender = mailSender;
    this.ultimaAlertaMeteorologicaSuscribers = listaSuscriptores;
    this.alertaMeteorologicaMailSuscribers = alertaMeteorologicaMailSuscribers;
  }

  public void actualizarAlertaMeteorologica(String ciudad) {
    this.ultimaAlertaMeteorologicaSuscribers
        .forEach(suscriptor -> suscriptor.notificarAlertaMeteorologica(
            this.servicioMeteorologico.getAlerts(ciudad).get("CurrentAlerts"),
            this.notificationService));
    // this.suscriptores.notificarAlertaMeteorologica(servicioMeteorologico.getAlerts(ciudad).get("CurrentAlerts"),
    // this.notificationService);
    this.alertaMeteorologicaMailSuscribers.forEach(
        suscriptor -> this.mailSender.send(suscriptor.getAdress(), "Alerta meteorológico"));

    this.ultimasAlertasMeteorologicas =
        servicioMeteorologico.getAlerts(ciudad).get("CurrentAlerts");
  }

  public List<String> getUltimasAlertasMeteorologicas() {
    return this.ultimasAlertasMeteorologicas;
  }

  public LocalDate getFechaPublicacion() {
    return this.datosAlertaMeteorologica.getFechaPublicacion();
  }

  public NotificationService getNotificationService() {
    return this.notificationService;
  }

}
