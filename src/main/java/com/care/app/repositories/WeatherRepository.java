package com.care.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.care.app.entities.dao.Weather;

/**
 * WeatherRepository
 */
@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

}