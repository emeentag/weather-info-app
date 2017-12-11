package com.care.app.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WindDTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WindDTO {

  @JsonProperty(value = "speed")
  private Float speed;

  @JsonProperty(value = "deg")
  private Integer degree;

  /**
   * @param degree the degree to set
   */
  public void setDegree(Integer degree) {
    this.degree = degree;
  }

  /**
   * @return the degree
   */
  public Integer getDegree() {
    return degree;
  }

  /**
   * @param speed the speed to set
   */
  public void setSpeed(Float speed) {
    this.speed = speed;
  }

  /**
   * @return the speed
   */
  public Float getSpeed() {
    return speed;
  }
}