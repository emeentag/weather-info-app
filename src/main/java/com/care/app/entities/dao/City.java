package com.care.app.entities.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Country
 */
@Entity
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "city_id", columnDefinition = "MEDIUMINT(6)")
  private Long cityId;

  @Column(name = "country_code", columnDefinition = "VARCHAR(3)")
  private String countryCode;

  @Column(name = "city_name", columnDefinition = "VARCHAR(55)")
  private String cityName;

  @Column(name = "sunrise", columnDefinition = "TIMESTAMP")
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date sunrise;

  @Column(name = "sunset", columnDefinition = "TIMESTAMP")
  private Date sunset;

  @OneToMany(mappedBy = "city", targetEntity = Weather.class, cascade = CascadeType.REMOVE)
  private List<Weather> weathers;

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

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

  /**
   * @param weathers the weathers to set
   */
  public void setWeathers(List<Weather> weathers) {
    this.weathers = weathers;
  }

  /**
   * @return the weathers
   */
  public List<Weather> getWeathers() {
    return weathers;
  }
}