package com.care.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.care.app.entities.dao.Weather;
import com.care.app.services.WeatherService;

/**
 * OWMController
 */
@RestController
public class OWMController {

  @Autowired
  private WeatherService weatherService;

  @GetMapping(value = "/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Weather> getWeather(@PathVariable String cityName) {

    Weather weather = this.weatherService.getWeather(cityName);

    return ResponseEntity.ok(weather);
  }
}