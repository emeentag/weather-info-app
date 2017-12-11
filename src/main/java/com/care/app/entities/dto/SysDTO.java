package com.care.app.entities.dto;

import java.util.Date;

import com.care.app.utils.UnixTimestampDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * SysDTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysDTO {

  @JsonProperty(value = "country")
  private String countryCode;

  @JsonProperty(value = "sunrise")
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date sunrise;

  @JsonProperty(value = "sunset")
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date sunset;

  /**
   * @param countryCode the countryCode to set
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  /**
   * @return the countryCode
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * @param sunrise the sunrise to set
   */
  public void setSunrise(Date sunrise) {
    this.sunrise = sunrise;
  }

  /**
   * @return the sunrise
   */
  public Date getSunrise() {
    return sunrise;
  }

  /**
   * @param sunset the sunset to set
   */
  public void setSunset(Date sunset) {
    this.sunset = sunset;
  }

  /**
   * @return the sunset
   */
  public Date getSunset() {
    return sunset;
  }
}