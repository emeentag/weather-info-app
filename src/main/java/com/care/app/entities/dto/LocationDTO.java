package com.care.app.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LocationDTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO {

  @JsonProperty(value = "lon")
  private Float lng;

  @JsonProperty(value = "lat")
  private Float lat;

  /**
   * @param lat the lat to set
   */
  public void setLat(Float lat) {
    this.lat = lat;
  }

  /**
   * @return the lat
   */
  public Float getLat() {
    return lat;
  }

  /**
   * @param lng the lng to set
   */
  public void setLng(Float lng) {
    this.lng = lng;
  }

  /**
   * @return the lng
   */
  public Float getLng() {
    return lng;
  }

}