package com.care.app.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CloudDTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudDTO {

  @JsonProperty(value = "all")
  private Short percent;

  /**
   * @param percent the percent to set
   */
  public void setPercent(Short percent) {
    this.percent = percent;
  }

  /**
   * @return the percent
   */
  public Short getPercent() {
    return percent;
  }
}