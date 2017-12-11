package com.care.app.controllers;

import com.care.app.entities.dao.Weather;
import com.care.app.services.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * AppController
 */
@RestController
public class AppController {

  @Autowired
  private WeatherService weatherService;

  @GetMapping
  public ModelAndView getIndex(ModelAndView mav) {

    mav.setViewName("index");

    return mav;
  }

  @GetMapping(value = "/{cityName}")
  public ResponseEntity<Weather> getWeather(@PathVariable String cityName) {

    Weather weather = this.weatherService.getWeather(cityName);

    return ResponseEntity.ok(weather);
  }
}