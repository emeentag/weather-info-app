package com.care.app.entities.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.care.app.entities.embeddable.Cloud;
import com.care.app.entities.embeddable.Location;
import com.care.app.entities.embeddable.Wind;

/**
 * Weather
 */
@Entity
public class Weather {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(columnDefinition = "SMALLINT(3)")
  private Integer code;

  @Column(columnDefinition = "VARCHAR(55)")
  private String definition;

  @Column(columnDefinition = "VARCHAR(155)")
  private String description;

  @Column(columnDefinition = "VARCHAR(4)")
  private String icon;

  @Column(columnDefinition = "FLOAT")
  private Float temprature;

  @Column(columnDefinition = "SMALLINT(3)")
  private Short pressure;

  @Column(columnDefinition = "TINYINT(3)")
  private Byte humidity;

  @Column(columnDefinition = "TIMESTAMP")
  private Date queryDateTime;

  @Embedded
  private Cloud cloud;

  @Embedded
  private Location location;

  @Embedded
  private Wind wind;

  @ManyToOne(targetEntity = City.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "city_id", referencedColumnName = "id")
  private City city;

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
   * @param city the city to set
   */
  public void setCity(City city) {
    this.city = city;
  }

  /**
   * @return the city
   */
  public City getCity() {
    return city;
  }

  /**
   * @param cloud the cloud to set
   */
  public void setCloud(Cloud cloud) {
    this.cloud = cloud;
  }

  /**
   * @return the cloud
   */
  public Cloud getCloud() {
    return cloud;
  }

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
   * @param location the location to set
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * @return the location
   */
  public Location getLocation() {
    return location;
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

  /**
   * @param wind the wind to set
   */
  public void setWind(Wind wind) {
    this.wind = wind;
  }

  /**
   * @return the wind
   */
  public Wind getWind() {
    return wind;
  }

  /**
   * @param icon the icon to set
   */
  public void setIcon(String icon) {
    this.icon = icon;
  }

  /**
   * @return the icon
   */
  public String getIcon() {
    return icon;
  }

  /**
   * @param queryDateTime the queryDateTime to set
   */
  public void setQueryDateTime(Date queryDateTime) {
    this.queryDateTime = queryDateTime;
  }

  /**
   * @return the queryDateTime
   */
  public Date getQueryDateTime() {
    return queryDateTime;
  }
}