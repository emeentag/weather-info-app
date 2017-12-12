package com.care.app.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MainDTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainDTO {

  @JsonProperty(value = "temp")
  private Float temprature;

  @JsonProperty(value = "pressure")
  private Short pressure;

  @JsonProperty(value = "humidity")
  private Byte humidity;

  /**
   * @param humadity the humadity to set
   */
  public void setHumidity(Byte humadity) {
    this.humidity = humadity;
  }

  /**
   * @return the humadity
   */
  public Byte getHumidity() {
    return humidity;
  }

  /**
   * @param pressure the pressure to set
   */
  public void setPressure(Short pressure) {
    this.pressure = pressure;
  }

  /**
   * @return the pressure
   */
  public Short getPressure() {
    return pressure;
  }

  /**
   * @param temprature the temprature to set
   */
  public void setTemprature(Float temprature) {
    this.temprature = temprature;
  }

  /**
   * @return the temprature
   */
  public Float getTemprature() {
    return temprature;
  }

}