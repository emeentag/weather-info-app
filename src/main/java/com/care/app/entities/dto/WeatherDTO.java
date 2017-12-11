package com.care.app.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WeatherDTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {

  @JsonProperty(value = "id")
  private Integer code;

  @JsonProperty(value = "main")
  private String definition;

  @JsonProperty(value = "description")
  private String description;

  /**
   * @param code the code to set
   */
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * @return the code
   */
  public Integer getCode() {
    return code;
  }

  /**
   * @param definition the definition to set
   */
  public void setDefinition(String definition) {
    this.definition = definition;
  }

  /**
   * @return the definition
   */
  public String getDefinition() {
    return definition;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

}