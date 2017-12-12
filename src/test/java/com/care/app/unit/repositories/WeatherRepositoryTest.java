package com.care.app.unit.repositories;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import com.care.app.entities.dao.City;
import com.care.app.entities.dao.Weather;
import com.care.app.entities.dto.ApiDTO;
import com.care.app.repositories.CityRepository;
import com.care.app.repositories.WeatherRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * WeatherRepositoryTest
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class WeatherRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private WeatherRepository weatherRepository;

  @Autowired
  private CityRepository cityRepository;

  private Weather weather;

  private String apiResponse = "{\"coord\":{\"lon\":28.95,\"lat\":41.01},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":287.63,\"pressure\":1021,\"humidity\":72,\"temp_min\":287.15,\"temp_max\":288.15},\"visibility\":10000,\"wind\":{\"speed\":8.7,\"deg\":210},\"clouds\":{\"all\":0},\"dt\":1513005600,\"sys\":{\"type\":1,\"id\":6044,\"message\":0.0039,\"country\":\"TR\",\"sunrise\":1512969570,\"sunset\":1513002961},\"id\":745044,\"name\":\"Istanbul\",\"cod\":200}";

  @Before
  public void persist() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();

    ApiDTO apiDto = mapper.readValue(apiResponse, ApiDTO.class);

    Assert.assertEquals("Istanbul", apiDto.getCityName());
    Assert.assertEquals(Long.valueOf(745044), apiDto.getCityId());
    Assert.assertEquals("TR", apiDto.getSysDTO().getCountryCode());
    Assert.assertEquals(Date.from(Instant.ofEpochSecond(1512969570)), apiDto.getSysDTO().getSunrise());
    Assert.assertEquals(Date.from(Instant.ofEpochSecond(1513002961)), apiDto.getSysDTO().getSunset());
    Assert.assertEquals(Short.valueOf("0"), apiDto.getCloudDTO().getPercent());
    Assert.assertEquals(Float.valueOf(8.7f), apiDto.getWindDTO().getSpeed());
    Assert.assertEquals(Integer.valueOf(210), apiDto.getWindDTO().getDegree());
    Assert.assertEquals(Float.valueOf(287.63f), apiDto.getMainDTO().getTemprature());
    Assert.assertEquals(Short.valueOf("1021"), apiDto.getMainDTO().getPressure());
    Assert.assertEquals(Byte.valueOf("72"), apiDto.getMainDTO().getHumidity());
    Assert.assertEquals(Integer.valueOf(800), apiDto.getWeatherDTOs().get(0).getCode());
    Assert.assertEquals("Clear", apiDto.getWeatherDTOs().get(0).getDefinition());
    Assert.assertEquals("clear sky", apiDto.getWeatherDTOs().get(0).getDescription());
    Assert.assertEquals("01n", apiDto.getWeatherDTOs().get(0).getIcon());
    Assert.assertEquals(Float.valueOf(41.01f), apiDto.getLocationDTO().getLat());
    Assert.assertEquals(Float.valueOf(28.95f), apiDto.getLocationDTO().getLng());

    weather = ApiDTO.Map.toDAO(apiDto);

    Assert.assertEquals("Istanbul", weather.getCity().getCityName());
    Assert.assertEquals(Long.valueOf(745044), weather.getCity().getCityId());
    Assert.assertEquals("TR", weather.getCity().getCountryCode());
    Assert.assertEquals(Date.from(Instant.ofEpochSecond(1512969570)), weather.getCity().getSunrise());
    Assert.assertEquals(Date.from(Instant.ofEpochSecond(1513002961)), weather.getCity().getSunset());
    Assert.assertEquals(Short.valueOf("0"), weather.getCloud().getPercent());
    Assert.assertEquals(Float.valueOf(8.7f), weather.getWind().getSpeed());
    Assert.assertEquals(Integer.valueOf(210), weather.getWind().getDegree());
    Assert.assertEquals(Float.valueOf(287.63f), weather.getTemprature());
    Assert.assertEquals(Short.valueOf("1021"), weather.getPressure());
    Assert.assertEquals(Byte.valueOf("72"), weather.getHumidity());
    Assert.assertEquals(Integer.valueOf(800), weather.getCode());
    Assert.assertEquals("Clear", weather.getDefinition());
    Assert.assertEquals("clear sky", weather.getDescription());
    Assert.assertEquals("01n", weather.getIcon());
    Assert.assertEquals(Float.valueOf(41.01f), weather.getLocation().getLat());
    Assert.assertEquals(Float.valueOf(28.95f), weather.getLocation().getLng());

    this.entityManager.persist(weather);
  }

  @Test
  public void testSaveDaoWeather() {
    Assert.assertNotNull(weather.getId());
    Assert.assertEquals(Long.valueOf(1), weather.getId());
  }

  @Test
  public void testDaoCity() {
    City city = this.cityRepository.findOne(weather.getCity().getId());
    Assert.assertNotNull(city);
    Assert.assertEquals(Long.valueOf(2), city.getId());
    Assert.assertEquals(Long.valueOf(745044), city.getCityId());
  }
}