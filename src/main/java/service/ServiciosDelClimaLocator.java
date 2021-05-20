package service;

public class ServiciosDelClimaLocator {

  // TODO: Hay un serio detractor en poder lograr un polimorfismo entre una API/código de tercero y
  // con nuestro código. Requerimiento 4 no satisfecho en su totalidad.
  private static AccuWeatherAPI servicioDeClimaAccuWeather = new AccuWeatherAPI();

  public AccuWeatherAPI getServicioDeClimaAccuWeather() {
    return servicioDeClimaAccuWeather;
  }

  /*
   * Ej.: public GoogleWeatherAPI getServicioGoogleWeather() { return servicioDeClimaGoogleWeather;
   * }
   */
}
