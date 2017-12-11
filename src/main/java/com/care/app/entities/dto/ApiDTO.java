package com.care.app.entities.dto;

import java.util.List;

import com.care.app.entities.dao.City;
import com.care.app.entities.dao.Weather;
import com.care.app.entities.embeddable.Cloud;
import com.care.app.entities.embeddable.Location;
import com.care.app.entities.embeddable.Wind;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WeatherDTO
 */
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiDTO {

  @JsonProperty(value = "coord")
  private LocationDTO locationDTO;

  @JsonProperty(value = "weather")
  private List<WeatherDTO> weatherDTOs;

  @JsonProperty(value = "main")
  private MainDTO mainDTO;

  @JsonProperty(value = "wind")
  private WindDTO windDTO;

  @JsonProperty(value = "clouds")
  private CloudDTO cloudDTO;

  @JsonProperty(value = "sys")
  private SysDTO sysDTO;

  @JsonProperty(value = "name")
  private String cityName;

  @JsonProperty(value = "id")
  private Long cityId;

  /**
   * @param cityId the cityId to set
   */
  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }

  /**
   * @return the cityId
   */
  public Long getCityId() {
    return cityId;
  }

  /**
   * @param cityName the cityName to set
   */
  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  /**
   * @return the cityName
   */
  public String getCityName() {
    return cityName;
  }

  /**
   * @param cloudDTO the cloudDTO to set
   */
  public void setCloudDTO(CloudDTO cloudDTO) {
    this.cloudDTO = cloudDTO;
  }

  /**
   * @return the cloudDTO
   */
  public CloudDTO getCloudDTO() {
    return cloudDTO;
  }

  /**
   * @param locationDTO the locationDTO to set
   */
  public void setLocationDTO(LocationDTO locationDTO) {
    this.locationDTO = locationDTO;
  }

  /**
   * @return the locationDTO
   */
  public LocationDTO getLocationDTO() {
    return locationDTO;
  }

  /**
   * @param mainDTO the mainDTO to set
   */
  public void setMainDTO(MainDTO mainDTO) {
    this.mainDTO = mainDTO;
  }

  /**
   * @return the mainDTO
   */
  public MainDTO getMainDTO() {
    return mainDTO;
  }

  /**
   * @param sysDTO the sysDTO to set
   */
  public void setSysDTO(SysDTO sysDTO) {
    this.sysDTO = sysDTO;
  }

  /**
   * @return the sysDTO
   */
  public SysDTO getSysDTO() {
    return sysDTO;
  }

  /**
   * @param weatherDTOs the weatherDTOs to set
   */
  public void setWeatherDTOs(List<WeatherDTO> weatherDTOs) {
    this.weatherDTOs = weatherDTOs;
  }

  /**
   * @return the weatherDTOs
   */
  public List<WeatherDTO> getWeatherDTOs() {
    return weatherDTOs;
  }

  /**
   * @param windDTO the windDTO to set
   */
  public void setWindDTO(WindDTO windDTO) {
    this.windDTO = windDTO;
  }

  /**
   * @return the windDTO
   */
  public WindDTO getWindDTO() {
    return windDTO;
  }

  public static class Map {

    public static Weather toDAO(ApiDTO apiDTO) {

      Weather weatherDAO = new Weather();

      weatherDAO.setDefinition(apiDTO.getWeatherDTOs().get(0).getDefinition());
      weatherDAO.setDescription(apiDTO.getWeatherDTOs().get(0).getDescription());
      weatherDAO.setCode(apiDTO.getWeatherDTOs().get(0).getCode());
      weatherDAO.setHumadity(apiDTO.getMainDTO().getHumadity());
      weatherDAO.setTemprature(apiDTO.getMainDTO().getTemprature());
      weatherDAO.setPressure(apiDTO.getMainDTO().getPressure());

      Cloud cloud = new Cloud();
      cloud.setPercent(apiDTO.getCloudDTO().getPercent());
      weatherDAO.setCloud(cloud);

      Location location = new Location();
      location.setLat(apiDTO.getLocationDTO().getLat());
      location.setLng(apiDTO.getLocationDTO().getLng());
      weatherDAO.setLocation(location);

      Wind wind = new Wind();
      wind.setDegree(apiDTO.getWindDTO().getDegree());
      wind.setSpeed(apiDTO.getWindDTO().getSpeed());
      weatherDAO.setWind(wind);

      City cityDAO = new City();
      cityDAO.setCityId(apiDTO.getCityId());
      cityDAO.setCityName(apiDTO.getCityName());
      cityDAO.setCountryCode(apiDTO.getSysDTO().getCountryCode());
      cityDAO.setSunrise(apiDTO.getSysDTO().getSunrise());
      cityDAO.setSunset(apiDTO.getSysDTO().getSunset());

      weatherDAO.setCity(cityDAO);

      return weatherDAO;
    }
  }
}