package com.care.app.entities.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Wind
 */
@Embeddable
public class Wind {

  @Column(name = "speed", columnDefinition = "FLOAT")
  private Float speed;

  @Column(name = "degree", columnDefinition = "SMALLINT(3)")
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