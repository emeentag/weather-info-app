package com.care.app.entities.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Location
 */
@Embeddable
public class Location {

  @Column(name = "lng", columnDefinition = "FLOAT")
  private Float lng;

  @Column(name = "lat", columnDefinition = "FLOAT")
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