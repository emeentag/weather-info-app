package com.care.app.services;

import com.care.app.entities.dao.Weather;
import com.care.app.entities.dto.ApiDTO;
import com.care.app.repositories.CityRepository;
import com.care.app.repositories.WeatherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * WeatherServiceImpl
 */
@Service
public class WeatherServiceImpl implements WeatherService {

  @Value(value = "${owm.api.key}")
  private String API_KEY;

  @Value(value = "${owm.api.url}")
  private String API_URL;

  @Value(value = "${owm.api.units}")
  private String API_UNITS;

  @Autowired
  private CityRepository cityRepository;

  @Autowired
  private WeatherRepository weatherRepository;

  @Override
  public Weather getWeather(String cityName) {

    String weatherInfo = UriComponentsBuilder.fromUriString(API_URL).queryParam("appid", API_KEY)
        .queryParam("units", API_UNITS).queryParam("q", cityName).build().toString();

    RestTemplate template = new RestTemplate();

    ResponseEntity<ApiDTO> response = template.getForEntity(weatherInfo, ApiDTO.class);

    Weather weather = ApiDTO.Map.toDAO(response.getBody());

    this.weatherRepository.save(weather);

    return weather;
  }

}