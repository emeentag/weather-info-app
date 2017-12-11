package com.care.app.services;

import com.care.app.entities.dao.Weather;

/**
 * WeatherService
 */
public interface WeatherService {

  public Weather getWeather(String cityName);

}