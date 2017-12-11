package com.care.app.entities.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Cloud
 */
@Embeddable
public class Cloud {

  @Column(name = "percent", columnDefinition = "TINYINT(2)")
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